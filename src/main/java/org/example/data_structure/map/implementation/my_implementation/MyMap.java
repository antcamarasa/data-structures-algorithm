package org.example.data_structure.map.implementation.my_implementation;

import org.example.data_structure.collection.MyCollection;
import org.example.data_structure.set.MySet;

public interface MyMap<K, V> {
    V put(K key, V value);
    V getValue(K key);
    V remove(K key);

    boolean containKey(K key);
    boolean containValue(V value);
    int size();
    boolean isEmpty();

    MySet<K> keySet();
    MyCollection<V> values();
    MySet<MyEntry<K, V>> entrySet();

}
