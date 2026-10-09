package org.example.data_structure.set.implementation;

import org.example.data_structure.map.implementation.my_implementation.separate_chaining.MyMapSeparateChaining;

import java.util.Iterator;

public class MyHashSet<T> implements MySet<T>{
    // ********************************** FIELD *********************************
    private final static Object SENTINELLE = new Object();
    private final MyMapSeparateChaining<T, Object> myMapSeparateChaining;

    // ******************************* CONSTRUCTOR ******************************
    public MyHashSet(){
        this.myMapSeparateChaining = new MyMapSeparateChaining<>();
    }


    // ***************************** IMPLEMENT contract ***************************
    public boolean add(T t){
        return myMapSeparateChaining.put(t, SENTINELLE) == null;
    }
    public boolean remove(T t){
        return myMapSeparateChaining.remove(t) != null;
    }
    public boolean contains(T t){return myMapSeparateChaining.containKey(t);}
    public int size(){return myMapSeparateChaining.size();}
    public boolean isEmpty(){return myMapSeparateChaining.isEmpty();}

    public Iterator<T> iterator(){
        return myMapSeparateChaining.keySet().iterator();
    }
}
