package org.example.data_structure.collection;

public interface MyCollection<T> extends Iterable<T>{
     boolean add(T t);
     boolean remove(T t);
     boolean contains(T t);
     int size();
     boolean isEmpty();
}
