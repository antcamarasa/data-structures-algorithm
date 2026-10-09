package org.example.data_structure.map.implementation.book;

import java.util.Map;

public abstract class MyAbstractMap<K, V> implements MyMap<K, V>{

    /**
     * Concrete implementations of the keySet and values methods, based upon an
     * adaption to the entrySet method. In this way, concrete map classes need only
     * implement the entrySet method to provide all three forms of iteration.
     * We implement the iterations using the technique introduced in Section 7.4.2
     * (at that time providing an iteration of all elements of a positional list given
     * an iteration of all positions of the list).
     */
    public boolean isEmpty(){
        return this.size() == 0;
    }

     protected static class MapEntry<K, V> implements Map.Entry<K, V> {
         private K k;
         private V v;

         MapEntry(K k, V v){
             this.k = k;
             this.v = v;
         }

         public K getKey(){return this.k;}
         public V getValue(){return this.v;}

         public V setValue(V externalValue){
             V oldValue = v;
             this.v = externalValue;
             return oldValue;
         }
         public boolean equals(Object o){
             if(!( o instanceof Map.Entry<?,?> other)){
                return false;
             }
             return this.k == other.getKey() && this.v == other.getValue();
         }
         public int hashCode(){
             return (this.k == null ? 0 : this.k.hashCode()) ^ (this.v == null ? 0 : this.v.hashCode());
         }
     }

     //----------- end of nested MapEntry class -----------
    //__________________________________________________________________________
    //___________________________ 2. KeySet & Values ___________________________
    /**
     * TODO
     * Des implémentations concrètes des méthodes keySet et values,
     * basées sur une adaptation de la méthode entrySet. De cette manière,
     * les classes concrètes de Map n’ont besoin d’implémenter que la méthode
     * entrySet pour fournir les trois formes d’itération.
     */
}
