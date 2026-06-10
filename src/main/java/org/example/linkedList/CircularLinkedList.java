package org.example.linkedList;

public class CircularLinkedList<E> {
        private static class Node<E> {
            private E Element;
            private Node<E> Next;

            public Node(E element, Node<E> node){
                this.Element = element;
                this.Next = node;
            }


            public E getElement(){
                return this.Element;
            }
            public Node<E> getNext(){
                return this.Next;
            }
            public void setNext(Node<E> n){
                this.Next = n;
            }
        }

        private int Size = 0;
        private Node<E> Tail = null;

        public CircularLinkedList(){};

        public int getSize(){
            return this.Size;
        }
        public boolean isEmpty(){
            return this.Size == 0;
        }


        // E first => Donne moi le premier element.
        public E getFirst(){
            if(isEmpty())
                return null;
            return this.Size > 1 ? this.Tail.Next.Element : this.Tail.Element;
        }

        // E last => Donne moi le dernier element.
        public E getLast(){
            if (isEmpty())
                return null;
            return this.Tail.Element;
        }

        public void rotate(){
            this.Tail = this.Tail.Next;
        }

        // addFirst => ?
        public void addFirst(E e){
            Node<E> current = new Node<>(e, null);
            if(isEmpty()){
                this.Tail = current;
                this.Tail.setNext(this.Tail); // Link to itSelf circular linkedList.
            }
            else {
                current.setNext(this.Tail.getNext());
                this.Tail.setNext(current); // setNext est une methode de la classe Node qui prend un node en paramètre.
            }
            this.Size++;
        }

        // addLast => ?
        public void addLast(E e){
            addFirst(e);
            this.Tail = this.Tail.Next;
        }


        public E removeFirst(){
            if(isEmpty())
                return null;

            if(this.Size <= 1){
                Node<E> removedNode = this.Tail;
                this.Tail = null;
                return removedNode.getElement();
            }

            Node<E> head = this.Tail.Next;
            if(head == this.Tail){
                this.Tail = null;
            }
            else{
                this.Tail.setNext(head.getNext());
            }
            return head.getElement();
        }


        public void display(){
            Node<E> current = this.Tail.Next;
            while(current != null){
                System.out.println(current.Element);
                current = current.Next;
            }

        }
}
