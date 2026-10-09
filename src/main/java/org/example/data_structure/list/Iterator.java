package org.example.data_structure.list;

public interface Iterator<E> {

    // Return true if hasNext element. False if not.
    boolean hasNext();

    // return the current element.
    E next();
}
