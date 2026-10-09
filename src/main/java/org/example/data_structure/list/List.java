package org.example.data_structure.list;

public interface List<E> {

    // Return the number of element in the list.
    int size();

    // Return a boolean indicating whether the list is empty.
    boolean isEmpty();

    // Return the element of the list having index i; an error condition occurs if i
    // is not int the range [0, size() -1]
    E get(int index) throws IndexOutOfBoundsException; // TODO pourquoi ici ?

    // Replaces the element at index i with e and return old element that was replaced.
    E set(int index, E e) throws IndexOutOfBoundsException;

    // Inserts a new element e into the list, moving all subsequent by one place and add element.
    void add(int index, E e) throws IndexOutOfBoundsException;

    // Remove and returns the element at index i
    E removes(int index) throws IndexOutOfBoundsException;
}
