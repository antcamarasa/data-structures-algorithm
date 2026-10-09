package org.example.data_structure.map.implementation.book;

import java.util.Map;

public interface MyMap<K, V> {
    int size();
    boolean isEmpty();

    V get(K key);
    V put(K key, V value);
    V remove(K key);

    Iterable<K> keySet();
    Iterable<V> values();

    // Iterable<T>, T = returned type
    Iterable<Map.Entry<K, V>> entrySet();


}
