package org.example.data_structure.map.implementation.my_implementation.open_adressing;

import org.example.data_structure.collection.MyCollection;
import org.example.data_structure.set.MySet;
import org.example.data_structure.map.implementation.my_implementation.MyAbstractMap;
import org.example.data_structure.map.implementation.my_implementation.MyEntry;
import org.example.data_structure.map.implementation.my_implementation.MyMap;

public class MyMapOpenAddressing<K, V> extends MyAbstractMap<K, V>{
    private Node<K,V>[] bucket;
    private int[] maxDist;
    private final Node<K, V> DEFUNCT = new Node<>(null, null);
    private record Slot(int index, int distance){};

    // _______________________________________ MAP CONSTRUCTOR ______________________________________________
    public MyMapOpenAddressing(){
        super(0.5);
        this.bucket = (Node<K, V>[]) new Node[super.capacity];
        this.maxDist = new int[super.capacity];
    }

    // _______________________________________ INNER CLASS NODE _____________________________________________
    static class Node<K, V>{
        private K key;
        private V value;

        public Node(K key, V value){
            this.key = key;
            this.value = value;
        }

        public K getKey(){
            return this.key;
        }
        public V getValue(){
            return this.value;
        }
    }

    // ______________________________________ MAP METHOD A RECODER ___________________________________________
    @Override
    public V put(K key, V value) {
        if(key == null || value == null){
            throw new IllegalArgumentException("Cannot add null value");
        }
        int startIndex  = getIndex(key);

        Slot availableSlot = findSlot(null, startIndex, key, 0);
        V oldValue =  null;
        if(bucket[availableSlot.index] == null || bucket[availableSlot.index] == DEFUNCT){
            bucket[availableSlot.index] = new Node<>(key, value);
            incrementSize();
            incrementModCount();
        } else {
            oldValue = bucket[availableSlot.index].value;
            bucket[availableSlot.index].value = value;
        }

        maxDist[startIndex] = Math.max(maxDist[startIndex], availableSlot.distance);

        if(oldValue == null && super.calculateRatio() > super.MAXIMUM_RATIO){
            reHash();
        }
        return oldValue;
    }

    // Je pourrais améliorer ma fonction en disant : si maxDistance[index] != null alors while counter < maxDistance[index]
    private Slot findSlot(Slot defunctSlot, int index, K key, int counter){
        // Pour éviter de dépasser la taille du tableau, je réassigne index.
        index = index > capacity - 1 ? 0 : index;
        int max = maxDist[index] != 0 ? maxDist[index] : capacity;

        // Pour éviter de bouclé a l'infini, je vérifie si mon counter a par dépasser la capacité de mon tableau.
        if(counter <= max) {
            // On regarde si defunctSlot est présent si c'est le cas on a trouvé et on retourne
            if(defunctSlot != null) return defunctSlot;
            // Si non alors insertion impossible.
            throw new RuntimeException("Iterate through the entire map without finding availableSlot or defunct slot, insert is impossible");
        }

        // Maintenant on tombe sur un emplacement null.
        if(bucket[index] == null){
            // si defunctSlot est présent alors on le retourne
            if(defunctSlot != null)return defunctSlot;
            // sinon on crée un nouveau slot d'insertion.
            return new Slot(index, counter);
        }

        // Si la clé est égale alors on retourne cette position.
        if(bucket[index] != DEFUNCT && bucket[index].key.equals(key)){
            return new Slot(index, counter);
        }

        // Ici, si l'emplacement est une tombe est qu'aucun tombe n'a déja été créer alors on créer un emplacement et on continue la recherche.
        defunctSlot = bucket[index] == DEFUNCT && defunctSlot == null ? new Slot(index, counter) : defunctSlot;
        return findSlot(defunctSlot, index + 1, key, counter + 1);
    }

    //TODO --------------------------------------- TODO ----------------------------------------
    @Override
    public V remove(K key){
        // Ici quand je remove, je vais juste placer DEFUNCT à la place de ma node. peu importe où elle se situe.
        int index = getIndex(key);
        int max = maxDist[index];

        int counter = 0;
        while (counter <= max){
            if(bucket[index] == null){
                break; // Va chercher l'erreur en dessous de la map.
            }

            if(bucket[index] != DEFUNCT && bucket[index].key.equals(key)){
                V oldValue = bucket[index].value;
                bucket[index] = DEFUNCT;
                super.decrementSize();
                super.incrementModCount();
                return oldValue;
            }

            index = index + 1  < this.capacity ? index + 1 : 0;
            counter++;
        }

        throw new IllegalArgumentException("Cannot remove because, key don't exist in the map");
    }

    @Override
    public V getValue(K key){return null;}

    public void reHash(){};

    @Override
    public boolean containKey(K key){
        return false;
    }

    @Override
    public boolean containValue(V value){
        return false;
    }

    @Override
    public MySet<K> keySet() {
        return null;
    }

    @Override
    public MyCollection<V> values() {
        return null;
    }

    @Override
    public MySet<MyEntry<K, V>> entrySet() {
        return null;
    }

    // _____________________________________ Helper _______________________________
    public int getIndex(K key){
        return super.reduceHashValueToIndex(super.convertKeyToHashValue(key));
    }
}
