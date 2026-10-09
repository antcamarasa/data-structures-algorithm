package org.example.data_structure.list.array_list;

import org.example.data_structure.list.Iterable;
import org.example.data_structure.list.Iterator;
import org.example.data_structure.list.List;

public class ArrayList <E> implements List<E>, Iterable<E> {
    private int size = 0;
    private int capacity = 16;
    private E[] data;

    public ArrayList(){
        data = (E[]) new Object[this.capacity];
    }

    // ________________ CORRECTION ________________________
    public int size(){return this.size;}

    public boolean isEmpty(){return this.size == 0;}

    public E get(int i) throws IndexOutOfBoundsException{
        checkIndex(i, this.size);
        return this.data[i];
    }

    // Replaces the element at index e, and return the replaced element.
    public E set(int i, E e) throws IndexOutOfBoundsException {
        checkIndex(i, this.size);
        E replaced = this.data[i];
        this.data[i] = e;
        return replaced;
    }

    // ____________________________________________________
    // Inserts element e to be at index i, shifting subsequent element.
    @Override
    public void add(int i, E e) throws IndexOutOfBoundsException {
       checkIndex(i, this.size);

       // Vérifie size + 1 < capacity.
       if(this.size + 1 >= capacity){resize();}

       // Move all subsequent element.
       for(int index = size; index <= i; i--){
           this.data[index] = this.data[index - 1];
       }

       // Insert E at i.
        this.data[i] = e;
       this.size++;
    }

    @Override
    public E removes(int index) throws IndexOutOfBoundsException {
        E current = this.data[index];

        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException("L'index est < 0 ou > à la taille maximum du tableau courant.");
        }

        for(int i = index; i < this.size - 1; i++){
            this.data[i] = this.data[i+1];
        }
        this.data[this.size - 1] = null;
        this.size --;

        return current;
    }

    // Resize
    public void resize(){
        // On double la taille du tableau.
        int new_capacity = this.capacity * 2;

        // On crée un nouveau tableau avec la bonne taille
        E[] newArray = (E[]) new Object[new_capacity];

        // On copie toutes les valeurs
        for(int i = 0; i < this.capacity; i++){
            newArray[i] = this.data[i];
        }

        // On set la nouvelle longeur et l'ancienne valeur
        this.capacity = new_capacity;
        this.data = newArray;
    }


    public void checkIndex(int i, int n){
        if(i < 0 || i >= n){
            throw new IndexOutOfBoundsException("Index is less than 0 or, up of curent size");
        }
    }


    // =================== Iterator ====================
    public Iterator iterator(){
        return new ArrayListIterator();
    }

    private class ArrayListIterator implements Iterator<E>{
        int cursor = 0;

        @Override
        public boolean hasNext() {
            return cursor < size;
        }

        @Override
        public E next() {
            E element = data[cursor];
            cursor++;
            return element;
        }
    }

    @Override
    public String toString() {
       StringBuilder sb = new StringBuilder();
       sb.append("[");
       for(int i = 0; i < this.size; i++){
           sb.append(this.data[i]);
           sb.append(", ");
       }
       sb.append("]");
       return sb.toString();
    }

    public String toStringForDebug(){
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for(E element : this.data){
            sb.append(element);
            sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
}
