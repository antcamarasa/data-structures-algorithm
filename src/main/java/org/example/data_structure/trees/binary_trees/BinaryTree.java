package org.example.data_structure.trees.binary_trees;

import java.util.ArrayList;
import java.util.List;

public class BinaryTree<E> {
    Node<E> root = null;
    List<Node<E>> current;

    class Node<E>{
        E Value;
        Node<E> Left;
        Node<E> Right;

        public Node (E value){
            this.Value = value;
            this.Left  = null;
            this.Right = null;
        }

        public void setLeft(Node<E> left) {
            this.Left = left;
        }

        public void setRight(Node<E> right){
            this.Right = right;
        }

        public E getValue(){
            return this.Value;
        }

        public Node<E> getLeft(){
            return this.Left;
        }

        public Node<E> getRight(){
            return this.Right;
        }
    }


    public BinaryTree(E value){
        this.root = new Node<>(value);

        // Helper, pour ne jamais perdre la ref de root. this.root restera toujours root.
        this.current = new ArrayList<>();
        this.current.add(this.root);
    }

    public void addWithoutCurren(E value){
        // Il me faut un moyen de savoir ou ajouter ma valeur.
        List<Node<E>> nodesAtLevel = new ArrayList<>();
        nodesAtLevel.add(root);

        // On cherche un emplacement vide.
        while(true){
            for(Node<E> el : nodesAtLevel){
                if(el.Left == null){el.Left = new Node<>(value); return;}
                if(el.Right == null){el.Right = new Node<>(value); return;}
            }

            List<Node<E>> tmp = new ArrayList<>();
            for(Node<E> el : nodesAtLevel){
                tmp.add(el.Left);
                tmp.add(el.Right);
            }
            nodesAtLevel = tmp;
        }
    }


    public void add(E value){
        for(Node<E> el : this.current){
            if(el.Left == null){el.Left = new Node<>(value);return;}
            if(el.Right == null){el.Right = new Node<>(value);return;}
        }

        // Ici current est full.
        List<Node<E>> tmp = new ArrayList<>();
        for(Node<E> el : this.current){
            tmp.add(el.Left);
            tmp.add(el.Right);
        }
        this.current = tmp;
        addWithoutCurren(value);
    }


    public void display(){
        List<Node<E>> curr = new ArrayList<>();
        curr.add(root);

        int space = 0;
        while (true){
            for(Node<E> el : curr){
                if(el == null)return;
                System.out.println("  ".repeat(space) + el.getValue());
            }

            space = space + 1;
            List<Node<E>> tmp = new ArrayList<>();
            for(Node<E> el : curr){
                tmp.add(el.Left);
                tmp.add(el.Right);
            }
            curr = tmp;
        }



    }
}
