package org.example.data_structure.linked_list.implementation;
import org.example.data_structure.list.implementation.Iterable;
import org.example.data_structure.list.implementation.Iterator;
import java.util.*;

public class LinkedList<E extends Comparable<E>> implements Iterable<E> {
    Scanner scanner = new Scanner(System.in);

    private static class Node<E>{
        private E element;
        private Node<E> next;

        public Node(E e, Node<E> n){
            this.element = e;
            this.next = n;
        }

        E getElement(){return this.element;}
        Node<E> getNext(){return this.next;}
        void setNext(Node<E> n){this.next = n;}
        void displays(Node<E> n){
            System.out.println("Element : " + this.element);
            System.out.println("Next : " + this.next.element);
        }
    }

    // Instancie variable
    private Node<E> head = null;
    private Node<E> tail = null;
    private int size = 0;

    public LinkedList(){}; // Constructeur vide, LinkedList est une structure, pas une donnée.

    // Access methods
    public int size(){return this.size;}
    public boolean isEmpty(){return this.size == 0;}
    public E first(){
        if(isEmpty()) return null;
        return this.head.getElement();
    }
    public E last(){
        if(isEmpty()) return null;
        return this.tail.getElement();
    }

    // Update methods
    public void addFirst(E e){
        this.head = new Node<>(e, this.head);
        if(size == 0)
            this.tail = this.head;
        size++;
    }
    public void addLast(E e){
        Node<E> newest = new Node<>(e, null);

        if(isEmpty())
            this.head = newest;
        else
            this.tail.setNext(newest);

        this.tail = newest;
        size++;
    }

    public void add(E e){
        addLast(e);
    }
    public void addAll(Collection<E> lst){
        if(Objects.equals(lst, this)) return;

        for(E e : lst){
            addLast(e);
        }
    }
    public E removeFirst(){
        if(isEmpty()) return null;

        E element = this.head.getElement();
        this.head = this.head.getNext();
        size--;

        if(size == 0)
            this.tail = null;

        return element;
    }


    // ________________________________ ITERATORS ____________________________________
    @Override
    public Iterator<E> iterator(){
        return new LinkedListIterator();
    }

    // TODO => Pourquoi devoir créer une class ??
    private class LinkedListIterator implements Iterator<E>{
        private Node<E> current = head;
        public boolean hasNext(){
            return current != null;
        }

        public E next(){
            if (current == null) throw new NoSuchElementException();
            E element = current.getElement();
            current = current.next;
            return element;
        }

    }

    //____________________________ REVERSE IMPLEMENTATION ____________________________
    public void reverse(){
        Node<E> oldHead = this.head;
        Node<E> previous = null;
        Node<E> current = this.head;

        int size = this.size;
        while(size > 0){
            // _______ Current(base case futur recursion) _______
            if(current.next == null){
                current.next = previous;
                this.head = current;
                this.tail = oldHead;
                break;
            }

            // _________ Main logic __________
            Node<E> tmp = current.next;
            current.setNext(previous);
            previous = current;
            current = tmp;
            size--;
        }
    }
    public void reverseRecursive(){
        Node<E> previous = null;
        Node<E> current = this.head;


        if(this.head == null || this.head.next == null) return; // Cas ll vide ou un seul élément.
        this.tail = this.head; // Simplifie les arguments de ma méthode récursive.

        //helperRecursive(previous, current);
        this.head = correctionReverseRecursive(this.head);

    }
    private void helperRecursive(Node<E> previous, Node<E> current){
        if(current.next == null){ // Base Case.
            current.next = previous;
            this.head = current;
            return;
        }

        Node<E> nextNode = current.next;
        current.next = previous;
        helperRecursive(current, nextNode);
    }
    private Node<E> correctionReverseRecursive(Node<E> head){
        if(head == null)
            return null;


        Node<E> newHead = head;
        if(head.next != null){
            newHead = correctionReverseRecursive(head.next);
            // Je lis head.next a head (ciruclar linkedList temporaire)
            head.next.next = head;
            head.next = null;
            this.tail = head;
        }

        return newHead;
    }

    //______________________________ MERGE TWO SORTED _________________________________

    /**
     *  Ici, afin de pouvoir comparer deux valeurs génériques, on fait place a deux nouveaux concept :
     *  1. Comparable
     *  2. Comparator.
     */
    public void mergeTwoSorted(List<E> lst1, List<E> lst2){
        if(lst1.isEmpty() && lst2.isEmpty()) return;

        while(!lst1.isEmpty() && !lst2.isEmpty()){
            Node<E> newNode = new Node<>(
                lst1.get(0).compareTo(lst2.get(0)) <= 0
                        ? lst1.remove(0)
                        : lst2.remove(0),
                null);

            if(this.head == null){this.head = newNode; this.tail = this.head; this.size++;}
            else{this.tail.next = newNode; this.tail = this.tail.next; this.size++;}
        }

        addAll(!lst1.isEmpty() ? lst1: lst2);
    }
    public Node<E> mergeTwoSortedRecursive(List<E> list1, List<E> list2){
        if(list1.isEmpty() && list2.isEmpty())
            return null;

        if(list1.isEmpty() || list2.isEmpty()){
            addAll(!list1.isEmpty() ? list1: list2);
            return this.head;
        }

        Node<E> current = list1.get(0).compareTo(list2.get(0)) <= 0
                ? new Node<>(list1.remove(0), null)
                : new Node<>(list2.remove(0), null);

        mergeTwoSortedRecursive(list1, list2);

        current.next = this.head;
        this.head = current;
        this.size++;

        return this.head;
    }
    public Node<E> mergeRecursive(List<E> list1, List<E> list2, int pointer1, int pointer2){
        if(list1.isEmpty() && list2.isEmpty())
            return null;

        if(pointer1 >= list1.size() || pointer2 >= list2.size()){
            addAll(pointer1 < list1.size() ? list1.subList(pointer1, list1.size()): list2.subList(pointer2, list2.size()));
            return this.head;
        }

        Node<E> current = list1.get(pointer1).compareTo(list2.get(pointer2)) <= 0
                ? new Node<>(list1.get(pointer1), null)
                : new Node<>(list2.get(pointer2), null);

        if(Objects.equals(current.element, list1.get(pointer1))){pointer1++;}
        else{pointer2++;}

        mergeRecursive(
                list1,
                list2,
                pointer1,
                pointer2
        );

        current.next = this.head;
        this.head = current;
        this.size++;

        return this.head;
    }
    public Node<E> mergeRecursifBetter(List<E> list1, List<E> list2){
        if(list1.isEmpty()){
            addAll(list2);
            return this.head;
        }

        if(list2.isEmpty()){
            addAll(list2);
            return this.head;
        }

        Node<E> newHead;
        if(list1.get(0).compareTo(list2.get(0)) <= 0){
            newHead = new Node<>(list1.remove(0), null);
        }
        else{
            newHead = new Node<>(list2.remove(0), null);
        }

        newHead.next = mergeRecursifBetter(list1, list2);
        this.size++;

        this.head = newHead;
        return newHead;
    }

    //______________________________ Cycle detection _________________________________
    public boolean hasCycle(){
        Set<Node<E>> unique = new HashSet<>();

        Node<E> current = this.head;

        while(current != null){
            if(!unique.contains(current)){
                unique.add(current);
                current = current.next;
            }
            else{
                return true;
            }
        }
        return false;
    }
    public boolean hasCycleFAstAndSlowPointer(){
        Node<E> slow = this.head; // 1 // 2 -> 3
        Node<E> fast = this.head; // 1 // 3 -> 4

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) return true;
        }
        return false;
    }
    public E hasCycleFastAndSlow(){
        Node<E> slow = this.head; // 1 // 2 -> 3
        Node<E> fast = this.head; // 1 // 3 -> 4

        boolean circular = false;
        Set<Node<E>> uniques = new HashSet<>();

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast){
                if(!circular){
                    slow = this.head;
                    circular = true;
                    continue;
                }
                return slow.element;
            }
        }
        return null;
    }

    // ________________________________ Find middle ___________________________________
    public E middle(){
        Node<E> slow = this.head;
        Node<E> fast = this.head;

        while(true){
            // Fast ans slow pointeur vérifier que fast != null && fast.next != null;
            if(fast == null || fast.getNext() == null){
                return slow.element; // return the middle.
            }

            fast = fast.getNext().getNext();
            slow = slow.getNext();
        }
    }

    // ______________________________ ReorderLinked List ______________________________
    public void reorder(){
        Node<E> current = this.head;

        while(current != null && current.next != null){
            this.tail.next = current.next;
            current.next = this.tail;
            current = this.tail.next;
            this.tail = getTail();
            this.tail.next = null;
        }
    }
    private Node<E> getTail(){
        Node<E> current = this.head;
        int counter = 1;

        while (counter < this.size){
            current = current.next;
            counter++;
        }


        return current;
    }
    private Node<E> setTail(){
        Node<E> current = this.head;
        int counter = 1;

        while (counter < this.size){
            current = current.next;
            counter++;
        }
        current.next = null;
        return current;
    }
    public void reorderRecursive(){
        Node<E> current = this.head;
        reorderHelperRecursive(current, this.tail);
    }
    private void reorderHelperRecursive(Node<E> c, Node<E> t){
            if(c == null || c.next == null){
                return;
            }

            t.next = c.next;
            c.next = t;

            reorderHelperRecursive(t.next, setTail());
    }

    // TODO => Correction a comprendre et réimplémenter.
    public void reorderReverseAndMerge(){
        Node<E> slow = this.head;
        Node<E> fast = this.head;
        Node<E> middle = null;

        while(true){
            if(fast == null || fast.next == null){
                middle = slow;
                break;
            }

            fast = fast.getNext().getNext();
            slow = slow.next;
        }

        // 2. Reverse from middle + 1 to tail.
        Node<E> current = middle;
        Node<E> tmp =  null;
        while (current.next != null){
            tmp = current.next;
            current.next = this.tail;
            current = current.next;
            current.next = tmp;
            getNewTail();
        }

        // 3. merge.
        Node<E> currHead = this.head;
        Node<E> ll = null;
        while(middle.next != null){
            tmp = middle.next;
            middle.next = tmp.next;
            tmp.next = null;

            ll = currHead.next;
            displayLinkedList(ll);

            currHead.next = tmp;
            currHead = currHead.getNext();
            displayLinkedList();

            currHead.next = ll;
            currHead = currHead.getNext();
            getNewTail();
        }
    };
    public void getNewTail(){
        int counter = 0;
        Node<E> current = this.head;
        while (counter < this.size - 1){
            current = current.next;
            counter++;
        }
        this.tail = current;
        this.tail.next = null;
    }
    public void displayLinkedList(){
        int size = this.size;
        Node<E> current = this.head;
        while(current != null){
            System.out.println(current.getElement());
            current = current.next;
        }
    }
    public void displayLinkedList(Node<E> e){
        Node<E> current = e;
        while(current != null){
            System.out.println(current.getElement());
            current = current.next;
        }
    }
    public void displayNode(E e){
        Node<E> curr = this.head;
        while (curr != null){
            if(curr.element == e){
                curr.displays(curr);
                break;
            }
            else{
                curr = curr.next;
            }
        }
    }
}
