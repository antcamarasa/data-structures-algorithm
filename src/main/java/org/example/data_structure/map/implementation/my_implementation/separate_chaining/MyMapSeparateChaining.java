package org.example.data_structure.map.implementation.my_implementation.separate_chaining;

import org.example.data_structure.collection.MyCollection;
import org.example.data_structure.set.implementation.MySet;
import org.example.data_structure.map.implementation.my_implementation.MyEntry;

import java.util.*;
import java.util.function.Function;


public class MyMapSeparateChaining<K, V>{
    private int modCount;
    private int capacity;
    private int size;
    private final double MAXIMUM_RATIO = 0.75;
    private Node<K, V>[] bucket;

    // ________________________________________ Constructor
    public MyMapSeparateChaining(){
        this.modCount = 0;
        this.capacity = 5;
        this.size = 0;
        this.bucket = (Node<K, V>[]) new Node[capacity];
    }

    // ________________________________________ Inner static (without reference)
    public static class Node<K,V> implements MyEntry<K, V> {
        private K key;
        private V value;
        private Node<K, V> next;

        public Node(K key, V value){
            this.key = key;
            this.value = value;
        }

        @Override
        public K getKey() {
            return this.key;
        }

        @Override
        public V getValue(){return this.value;}
    }

    // _________________________________________ Final Private Inner class
    final class KeySet implements MySet<K>{
        @Override
        public boolean add(K k) {
            throw new UnsupportedOperationException("Unsupported operation, on keyset!");
        }

        @Override
        public boolean remove(K k) {throw new UnsupportedOperationException("Unsupported operation, on keyset!");}

        @Override
        public boolean contains(K k) {
            return MyMapSeparateChaining.this.containKey(k);
        }

        @Override
        public int size() {
            return MyMapSeparateChaining.this.size;
        }

        @Override
        public boolean isEmpty() {
            return MyMapSeparateChaining.this.size == 0;
        }

        @Override
        public Iterator<K> iterator(){
            return new GenericIterator<>(Node::getKey);
        }
    }
    final class Values implements MyCollection<V> {
        @Override
        public boolean add(V v) {throw new UnsupportedOperationException("Unsupported operation on views!");}

        @Override
        public boolean remove(V v) {throw new UnsupportedOperationException("Unsupported operation on view!");}

        @Override
        public boolean contains(V v) {return MyMapSeparateChaining.this.containsValue(v);}

        @Override
        public int size() {return MyMapSeparateChaining.this.size;}

        @Override
        public boolean isEmpty() {return MyMapSeparateChaining.this.isEmpty();}

        @Override
        public Iterator<V> iterator(){return new GenericIterator<>(Node::getValue);}

    }
    final class EntrySet implements MySet<MyEntry<K, V>>{
        @Override
        public boolean add(MyEntry<K, V> entry) {throw new UnsupportedOperationException("Unsupported operation on view!");}

        @Override
        public boolean remove(MyEntry<K, V> entry) {throw new UnsupportedOperationException("Unsupported operation on view!");}

        @Override
        public boolean contains(MyEntry<K, V> entry) {
            MyEntry<K, V> foundNode = MyMapSeparateChaining.this.getEntry(entry.getKey());
            // pas besoin de tester la clé car si elle est != null alors c'est quelle est deja trouvé.
            return foundNode != null && foundNode.getValue().equals(entry.getValue());
        }

        @Override
        public int size() {
            return MyMapSeparateChaining.this.size;
        }

        @Override
        public boolean isEmpty(){
            return MyMapSeparateChaining.this.isEmpty();
        }

        @Override
        public Iterator<MyEntry<K, V>> iterator(){
            return new GenericIterator<>(x -> x);
        }
    }

    // Version 1: Héritage
    abstract class BaseIterator{
        private final int expectedModCount;
        private Node<K, V> nextItem;
        private Integer bucketCurrentIndex;

        public BaseIterator(){
            bucketCurrentIndex = 0;
            this.expectedModCount = MyMapSeparateChaining.this.modCount;
            initialize();
        }

        public boolean hasNext(){
            return this.nextItem != null;
        }

        public Node<K, V> nextNode(){
            if(expectedModCount != MyMapSeparateChaining.this.modCount){
                throw new ConcurrentModificationException("Cannot iterate through a collection who has changed");
            }

            if(nextItem == null){
                throw new NoSuchElementException("No such element");
            }

            Node<K, V> tmp = nextItem;
            nextItem = getNextValue();
            return tmp;
        }


        private void initialize(){
            bucketCurrentIndex = getNextValidBucketIndex(bucketCurrentIndex);
            if(bucketCurrentIndex != null){
                nextItem = bucket[bucketCurrentIndex];
            }
        }
        private Integer getNextValidBucketIndex(int index){
            for(int i = index; i < capacity; i++){
                if(bucket[i] != null){
                    return i;
                }
            }
            return null;
        }
        private Node<K, V> getNextValue(){
            if(nextItem.next != null){
                return nextItem.next;
            }

            bucketCurrentIndex = getNextValidBucketIndex(bucketCurrentIndex + 1);
            return bucketCurrentIndex == null ? null : bucket[bucketCurrentIndex];
        }
    }
    final class KeyIterator extends BaseIterator implements Iterator<K>{
        @Override
        public K next() {
            return nextNode().key;
        }
    }
    final class ValueIterator extends BaseIterator implements Iterator<V>{
        @Override
        public V next() {
            return nextNode().value;
        }
    }

    // Version 2 : Générique avec methode d'extraction
    class GenericIterator<T> implements Iterator<T>{
        private final int expectedModCount;
        private final Function<Node<K, V>, T> extractor;
        private Node<K, V> nextItem;
        private Integer bucketCurrentIndex;


        public GenericIterator(Function<Node<K, V>, T> extractor){
            this.extractor = extractor;
            bucketCurrentIndex = 0;
            this.expectedModCount = MyMapSeparateChaining.this.modCount;
            initialize();
        }

        @Override
        public boolean hasNext(){
            return this.nextItem != null;
        }

        @Override
        public T next(){
            return extractor.apply(nextNode());
        }


        public Node<K, V> nextNode(){
            if(expectedModCount != MyMapSeparateChaining.this.modCount){
                throw new ConcurrentModificationException("Cannot iterate through a collection who has changed");
            }

            if(nextItem == null){
                throw new NoSuchElementException("No such element");
            }

            Node<K, V> tmp = nextItem;
            nextItem = getNextValue();
            return tmp;
        }


        private void initialize(){
            bucketCurrentIndex = getNextValidBucketIndex(bucketCurrentIndex);
            if(bucketCurrentIndex != null){
                nextItem = bucket[bucketCurrentIndex];
            }
        }
        private Integer getNextValidBucketIndex(int index){
            for(int i = index; i < capacity; i++){
                if(bucket[i] != null){
                    return i;
                }
            }
            return null;
        }
        private Node<K, V> getNextValue(){
            if(nextItem.next != null){
                return nextItem.next;
            }

            bucketCurrentIndex = getNextValidBucketIndex(bucketCurrentIndex + 1);
            return bucketCurrentIndex == null ? null : bucket[bucketCurrentIndex];
        }
    }

    // ********************************************** PUT ************************************************
    public V put(K key, V value){
        // 1. Check if key and value are non null.
        if(key == null || value == null){
            throw new NullPointerException("Key and value can't be null");
        }

        V returnedValue = null; // null if added, V if replaced
        int indexToInsert = reduceHashValueToIndex(convertKeyToHashValue(key));

        // 2. If bucket[index] == null on insère.
        if(bucket[indexToInsert] == null){
            bucket[indexToInsert] = new Node<>(key, value);
        } else {
            returnedValue = insertRecursive(bucket[indexToInsert], key, value);
        }

        if(returnedValue == null){
            size++;
            modCount++;
            if(calculateRatio() > MAXIMUM_RATIO) {
                reHash();
            }
        }

        return returnedValue;
    }
    private V insertRecursive(Node<K, V> prev, K keyToInsert, V valueToInsert){
        if(prev.key.equals(keyToInsert)){
            V oldValue = prev.value;
            prev.value = valueToInsert;
            return oldValue;
        }

        if(prev.next == null){
            prev.next = new Node<>(keyToInsert, valueToInsert);
            return null;
        }

        return insertRecursive(prev.next, keyToInsert, valueToInsert);
    }

    // ********************************************* GET *************************************************
    public V getValue(K searchKey){
        int index = reduceHashValueToIndex(convertKeyToHashValue(searchKey));
        Node<K, V> foundNode = searchByKey(bucket[index], searchKey);
        return foundNode!= null ? foundNode.value : null;
    }
    public MyEntry<K, V> getEntry(K searchKey){
        int index = reduceHashValueToIndex(convertKeyToHashValue(searchKey));
        return searchByKey(bucket[index], searchKey);
    }

    // **************************************** CONTAINS ************************************************
    // contains key retourne quoi ?
    public boolean containKey(K key){
        int index = reduceHashValueToIndex(convertKeyToHashValue(key));
        Node<K, V> foundNode = searchByKey(bucket[index], key);
        return foundNode != null;
    }

    public boolean containsValue(V value){
        boolean isValueInMap = false;
        for(int i = 0; i < bucket.length; i++){
            if(bucket[i] == null){
                continue;
            }
            isValueInMap = recursiveForContainsValue(bucket[i], value);

            if(isValueInMap) return isValueInMap;
        }
        return isValueInMap;
    }
    public boolean recursiveForContainsValue(Node<K,V> currentNode, V searchValue){
        if(currentNode == null) return false;
        if(currentNode.value.equals(searchValue))return true;
        return recursiveForContainsValue(currentNode.next, searchValue);
    }

    private Node<K, V> searchByKey(Node<K, V> current, K searchKey){
        if(current == null) return null;
        if(current.key.equals(searchKey)) return current;
        return searchByKey(current.next, searchKey);
    }

    // ***************** Set<K>keySet() | Set<V>values() | Set<Node<K, V>> entrySet *******************
    public MySet<K> keySet(){
        return new KeySet();
    }

    // values()
    public MyCollection<V> values(){return new Values();}

    // entrySet()
    public MySet<MyEntry<K, V>> entrySet(){
        return new EntrySet();
    }

    // ****************************************** DELETE *************************************************
    public V remove(K key){
        int index = reduceHashValueToIndex(convertKeyToHashValue(key));
        return recursiveRemove(index, null, this.bucket[index], key);
    }
    private V recursiveRemove(int index, Node<K, V> previous, Node<K, V> current, K searchKey){
        // Base case
        if(current == null){
            return null;
        }

        if(current.key.equals(searchKey)){
                    if(previous == null){
                        this.bucket[index] = current.next;
                    }
                    else{
                        previous.next = current.next;
                    }
                    size--;
                    modCount++;
                    return current.value;

            }
            return recursiveRemove(index, current, current.next, searchKey);
    }


    // *********************************** None to code function ****************************************
    // Non to code function, to first implémentation
    private Long convertKeyToHashValue(K key){
        int h = key.hashCode();
        return (long) (h ^ (h >>> 16));
    };
    private int reduceHashValueToIndex(Long hashValue){
        return (int) Math.floorMod(hashValue, (long) this.capacity);
    };
    private double calculateRatio(){
        return (double)this.size / (double)this.capacity;
    }


    // ******************************************** ReHash **********************************************
    private void reHash(){
        // 1. je copie la ref de bucket.
        var copyRef = bucket;

        // 2. je change la ref de bucket.
        capacity = capacity * 2;
        bucket = (Node<K, V>[]) new Node[capacity];

        // 3. Iteration sur tous les element de copyRef
        for(Node<K, V> currentNode : copyRef){
            Node<K, V> tmp  = currentNode;

            while( tmp != null){
                Node<K, V> next = tmp.next;
                tmp.next = null;

                int index = reduceHashValueToIndex(convertKeyToHashValue(tmp.key));

                // Insertion en tête.
                Node<K, V> oldHead = bucket[index];
                bucket[index] = tmp;
                tmp.next = oldHead;

                tmp = next;
            }
        }
    }

    // ____________ Deprecated
    private void reHashDeprecated(){
        // 1. On crée un tableau temporaire contenant toutes les valeurs de bucket.
        Node<K, V>[] temporaryBucket = (Node<K, V>[]) new Node[size];
        int temporaryIndex = 0;

        for(Node<K, V> currentNode : bucket){
            temporaryIndex = fillArrayDeprecated(currentNode, temporaryIndex, temporaryBucket);
        }

        // 2. On double la taille de bucket
        capacity = capacity * 2;
        size = 0;
        bucket = (Node<K, V>[]) new Node[capacity];

        //3. Je déplis temporaryBucket et j'insère chaque élément dans le nouveau bucket.
        Arrays.stream(temporaryBucket).filter(Objects::nonNull).forEach(x -> MyMapSeparateChaining.this.put(x.key, x.value));
        System.out.println("TOTO");
    }
    private int fillArrayDeprecated(Node<K, V> currentNode, int tmpIndex, Node<K, V>[] tmpBucket){
        if(currentNode == null) return tmpIndex;
        tmpBucket[tmpIndex] = currentNode;
        return fillArrayDeprecated(currentNode.next, tmpIndex + 1, tmpBucket);
    }

    // ______________________________________ END OF THIS PART __________________________________________

    // ******************************************* Getter ***********************************************
    public int size(){
        return this.size;
    }
    public boolean isEmpty(){
        for(Node<K, V> node : bucket){
            if(node != null)return false;
        }
        return true;
    }
}
