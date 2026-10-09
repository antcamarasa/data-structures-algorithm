package org.example.data_structure.trees.binary_trees;

import java.util.*;

/**
 * A implementer :
 * -> 1. Attach sur nœud non feuille
 *       Implémente un attach avancé qui, si p n’a pas deux places libres, cherche récursivement la prochaine position disponible
 *       dans le sous-arbre de p et y accroche t1 puis t2.
 *
 * -> 2. Remove d’un nœud avec deux enfants
 *  Implémente la suppression d’un nœud avec deux enfants en le remplaçant par un nœud de substitution choisi selon une règle
 *  claire, par exemple :
 *    - le dernier nœud le plus profond à droite
 *    - ou le premier nœud feuille trouvé en parcours BFS
 *
 *  -> 3 Delete subtree
 *  Implémente la suppression d’un sous-arbre entier à partir d’un nœud donné, avec mise coorecte :
 *  - Parent
 *  - Taille
 *  - Marquage des noeuds supprimés.
 *
 *  -> 4. Créer add() qui ajoute automatiquement au premier emplacement libre parcours en largeur.
 *
 * -> Touts les algos de parcours inOrder, postOrder... cours strivers DSA.
 */



/**
 * Concrete implementation of a binary tree using a node-based linked structure.
 */
public class BinaryTreeImplementation<E> {

    protected Node<E> Root = null;   // root of the tree
    protected int Size = 0;          // number of nodes in the tree


    //---------------- nested Node class ----------------
    /**
     * Node of a binary tree storing element and references
     * to parent, left child and right child.
     */
    public static class Node<E>{

        private E element;        // element stored in this node
        private Node<E> parent;   // reference to the parent node
        private Node<E> left;     // reference to left child
        private Node<E> right;    // reference to right child

        /**
         * Constructs a node with the given element and neighbors.
         */
        public Node(E e, Node<E> parent, Node<E> left, Node<E> right){
            element = e;
            this.parent = parent;
            this.left = left;
            this.right = right;
        }

        // accessor methods
        public E getElement(){ return element; }
        public Node<E> getParent(){ return parent; }
        public Node<E> getLeft(){ return left; }
        public Node<E> getRight(){ return right; }

        // update methods
        public void setElement(E e){ element = e; }
        public void setParent(Node<E> parentNode){ parent = parentNode; }
        public void setLeft(Node<E> leftChild){ left = leftChild; }
        public void setRight(Node<E> rightChild){ right = rightChild; }
    }
    //---------------- end of nested Node class ----------------


    /**
     * Constructs an empty binary tree.
     */
    public BinaryTreeImplementation(){}


    //---------------- utility methods ----------------

    /**
     * Validates the node and ensures it still belongs to the tree.
     */
    public void validate(Node<E> p){
        if(p == null)
            throw new IllegalArgumentException("Null node");

        if(p.getParent() == p)
            throw new IllegalArgumentException("Node is no longer in the tree");
    }


    //---------------- accessor methods ----------------

    /**
     * Returns the number of nodes in the tree.
     */
    public int size(){
        return Size;
    }

    /**
     * Tests whether the tree is empty.
     */
    public boolean isEmpty(){
        return Size == 0;
    }

    /**
     * Returns the root node of the tree.
     */
    public Node<E> root(){
        return Root;
    }

    /**
     * Returns the parent of node p.
     */
    public Node<E> parent(Node<E> p){
        validate(p);
        return p.getParent();
    }

    /**
     * Returns the left child of node p.
     */
    public Node<E> left(Node<E> p){
        validate(p);
        return p.getLeft();
    }

    /**
     * Returns the right child of node p.
     */
    public Node<E> right(Node<E> p){
        validate(p);
        return p.getRight();
    }

    /**
     * Returns true if node p has at least one child.
     */
    public boolean isInternal(Node<E> p){
        return p.getLeft() != null || p.getRight() != null;
    }


    //---------------- update methods ----------------

    /**
     * Places element e at the root of an empty tree
     * and returns its node.
     */
    public Node<E> addRoot(E e){

        if(!isEmpty())
            throw new IllegalStateException("Tree is not empty");

        Root = new Node<>(e,null,null,null);
        Size = 1;

        return Root;
    }

    /**
     *  Iterate to the three in level order, and insert at the first empty position.
     */
    public Node<E> add(E e){
        if(e == null){throw  new IllegalArgumentException("The value is null");}

        this.Size++;
        Node<E> current = new Node<>(e, null, null, null);
        if(this.Root == null){this.Root = current; return current;}

        List<Node<E>> listNodeLevel = new ArrayList<>();
        while(true){
            List<Node<E>> tmp = new ArrayList<>();

            if(listNodeLevel.isEmpty()){listNodeLevel.add(root()); continue;}
            for(Node<E> node : listNodeLevel){
                if(node.left == null){node.left = current; node.left.parent = node; return current;}
                tmp.add(node.left);

                if(node.right == null){node.right = current; node.right.parent = node; return current;}
                tmp.add(node.right);

            }

            listNodeLevel = tmp;
        }
    }

    /**
     * Creates a new left child of node p storing element e
     * and returns the new node.
     */
    public Node<E> addLeft(Node<E> p, E e){

        validate(p);

        if(p.getLeft() != null)
            throw new IllegalArgumentException("p already has a left child");

        Node<E> child = new Node<>(e,p,null,null);
        p.setLeft(child);

        Size++;
        return child;
    }


    /**
     * Creates a new right child of node p storing element e
     * and returns the new node.
     */
    public Node<E> addRight(Node<E> p, E e){

        validate(p);

        if(p.getRight() != null)
            throw new IllegalArgumentException("p already has a right child");

        Node<E> child = new Node<>(e,p,null,null);
        p.setRight(child);

        Size++;
        return child;
    }


    /**
     * Replaces the element at node p with e
     * and returns the replaced element.
     */
    public E set(Node<E> p, E e){

        validate(p);

        E temp = p.getElement();
        p.setElement(e);

        return temp;
    }


    /**
     * Attaches trees t1 and t2 as left and right subtrees of node p.
     * After attachment, t1 and t2 become empty trees.
     * An error occurs if p is not a leaf.
     */
    public void attach(Node<E> p,
                       BinaryTreeImplementation<E> t1,
                       BinaryTreeImplementation<E> t2){

        validate(p);

        if(isInternal(p))
            throw new IllegalArgumentException("p must be a leaf");

        Size += t1.Size + t2.Size;

        if(!t1.isEmpty()){
            t1.Root.setParent(p);
            p.setLeft(t1.Root);

            t1.Root = null;
            t1.Size = 0;
        }

        if(!t2.isEmpty()){
            t2.Root.setParent(p);
            p.setRight(t2.Root);

            t2.Root = null;
            t2.Size = 0;
        }
    }


    /**
     * Removes node p and replaces it with its child (if any).
     * Returns the element stored at p.
     * Throws an error if p has two children.
     */
    public E remove(Node<E> p){

        validate(p);

        if(p.getLeft() != null && p.getRight() != null)
            throw new IllegalArgumentException("p has two children");

        Node<E> child =
                (p.getLeft() != null ? p.getLeft() : p.getRight());

        if(child != null)
            child.setParent(p.getParent());

        if(p == Root)
            Root = child;

        else{
            Node<E> parent = p.getParent();

            if(p == parent.getLeft())
                parent.setLeft(child);
            else
                parent.setRight(child);
        }

        Size--;

        E temp = p.getElement();

        // help garbage collection
        p.setElement(null);
        p.setLeft(null);
        p.setRight(null);
        p.setParent(p);   // convention for defunct node

        return temp;
    }

    // ####################################################################
    // ######################## TRAVERSAL ALGORITHM #######################

    // ________________________ TRAVERSAL, Level order_____________________
    /**
     * Level Order traversals and Breadth First Search
     */
    public void levelOrderTraversals(){
        if(this.Root == null) throw new IllegalArgumentException("Root is null !");
        List<Node<E>> levelNodeLst = new ArrayList<>();
        levelNodeLst.add(Root);

        while(!levelNodeLst.isEmpty()){
            List<Node<E>> tmp = new ArrayList<>();
            for(Node<E> e : levelNodeLst){
                System.out.print(e.element);

                if(e.left != null)tmp.add(e.left);
                if(e.right != null)tmp.add(e.right);
            }
            System.out.println();
            levelNodeLst = tmp;

        }
    }
    public void levelOrderTraversalsRecursive(List<Node<E>> nodeLevel) {
        if(nodeLevel.isEmpty())return;

        List<Node<E>> tmp = new ArrayList<>();
        for(Node<E> e : nodeLevel){
            System.out.print(e.element);

            if(e.left != null)tmp.add(e.left);
            if(e.right != null)tmp.add(e.right);
        }
        System.out.println();
        levelOrderTraversalsRecursive(tmp);
    }
    public void levelOrderUsingQueue(Deque<Node<E>> queue){
        if(queue.isEmpty())return;
        int nbrElementToDisplay = queue.size();

        while (nbrElementToDisplay > 0){
            Node<E> current = queue.poll();
            System.out.println(current.element);
            if(current.left != null)queue.add(current.left);
            if(current.right != null)queue.add(current.right);
            nbrElementToDisplay -= 1;
        }

        levelOrderUsingQueue(queue);
    }

    // _______________________ TRAVERSAL, Pre order_____________________
    /**
     * Pre Order : DFS : Node / Left / Right
     */
    public void preOrderTraversalsRecursif(Node<E> e){
        System.out.println(e.element);
        if(e.left != null)  preOrderTraversalsRecursif(e.left);
        if(e.right != null) preOrderTraversalsRecursif(e.right);
    }
    public void preOrderTraversalStack(Node<E> e){
        Deque<Node<E>> stack = new ArrayDeque<>();
        stack.add(e);

        while(!stack.isEmpty()){
            Node<E> current = stack.pop();
            System.out.println(current.element);

            if(current.right != null)stack.push(current.right);
            if(current.left != null)stack.push(current.left);
        }
    }

    public void preOrderTraversalSecond(Set<Node<E>> visited, Node<E>e){
        if(e != null){
            System.out.println(e.element);
        }

        if(e.left != null && !visited.contains(e.left)){
            visited.add(e.left);
            preOrderTraversalSecond(visited, e.left);

        };

        if(e.right != null && !visited.contains(e.right)){
            visited.add(e.right);
            preOrderTraversalSecond(visited, e.right);
        }
    }
    public void preOrderUsingStack(Node<E> e){
        Set<Node<E>> visited = new HashSet<>();
        Deque<Node<E>> stack = new ArrayDeque<>();
        stack.push(e);

        while(!stack.isEmpty()){
            Node<E> current = stack.pop();
            System.out.println(current.element);

            if(current.right != null)stack.push(current.right);
            if(current.left!=null)stack.push(current.left);
        }

    }

    // Sand box, preOrderMorris et preOrderMorris2
    public void preOrderMorris(Node<E> current){
        Set<Node<E>> visited = new HashSet<>();

        while(true){
            //1. display current.
            if(!visited.contains(current)){System.out.println(current.element);}

            //2. set current à l'élément le plus à droite du sous arbre de gauche.
            Node<E> currentCopy = current;

            currentCopy = currentCopy.left;
            // TODO =>  a vérifier.
            if(currentCopy != null && !visited.contains(current) && current.right != null){
                while(currentCopy.right != null){
                    currentCopy = currentCopy.right;
                }
                currentCopy.right = current;
            }


            if(!visited.contains(current))visited.add(current);

            // 3.
            if(current.left != null && !visited.contains(current.left)){current = current.left;continue;}


            if(current.right != null){
                // TODO comment supprimer le lien ?
                if(visited.contains(current.right)){
                    var tmp = current.right;
                    current.right = null;
                    current = tmp;
                }
                else{current = current.right;}
                continue;
            }
            break;
        }


        display();
    }
    public void preOrderMorris2(Node<E> current){
        Set<Node<E>> visited = new HashSet<>();
        while (true){
            if(!visited.contains(current))System.out.println(current.element); // 5

            if(!visited.contains(current) && current.right != null && !(visited.contains(current.right))){
                Node<E> rightesNested = current.left;
                if(rightesNested != null) {
                    while (rightesNested.right != null) {
                        rightesNested = rightesNested.right;
                    }
                    rightesNested.right = current;
                }
            }

            visited.add(current);

            if(current.left != null && !visited.contains(current.left)){current = current.left; continue;}
            if(current.right != null){
                if(!visited.contains(current.right)){
                    current = current.right;
                }
                else{
                    Node<E> tmp = current.right; // 4
                    current.right = null;
                    current = tmp;
                }
                continue;
            }
            break;
        }
    }

    // Better way but non optimal
    public void morris(Node<E> current){

        while(true){
            if(current.left != null){
                Node<E> rightMost = current.left;
                boolean isCycle = false;

                while (rightMost.right != null){
                    if( rightMost.right == current){
                        // Cycle détecté
                        rightMost.right = null;
                        current = current.right;
                        isCycle = true;
                        break;
                    }
                    rightMost = rightMost.right;
                }

                if(isCycle)continue;

                System.out.println(current.element);
                rightMost.right = current;
                current = current.left;
                continue;
            }

            if(current.right != null){
                System.out.println(current.element);
                current = current.right;
                continue;
            }

            System.out.println(current.element);
            break;
        }
    }
    public void correctionMorrisPreOrder(Node<E> current){}


    // ________________________ TRAVERSAL, In order_____________________

    public void inOrderUsingStack(Node<E> root){
        Set<Node<E>> alreadyUsedValue = new HashSet<>();
        Deque<Node<E>> stack = new ArrayDeque<>();

        stack.push(root); // 4
        while(!stack.isEmpty()){
            Node<E> current = stack.peek();

            if(current.left != null && !alreadyUsedValue.contains(current.left)){
                stack.push(current.left);
                continue;
            }

            Node<E> removedValue = stack.pop();
            alreadyUsedValue.add(removedValue);
            System.out.println(removedValue.element);

            if(current.right != null && ! alreadyUsedValue.contains(current.right)){
                stack.push(current.right);
            }
        }
    }
    // La grande différence est de se servir de root et de stack, et non de remplir stack et ensuite modifier stack.
    public void inOrderStackCorrection(Node<E> root){
        Deque<Node<E>> stack = new ArrayDeque<>();


        while(root != null || !stack.isEmpty()){
           if(root != null){
               stack.push(root);
               root = root.left;
                continue;
           }
            Node<E> current = stack.pop();
            System.out.println(current.element);
            root = current.right;
        }
    }
    public void inOrderRecursive(Node<E> curr){
        if(curr.left != null) inOrderRecursive(curr.left);
        System.out.println(curr.element);
        if(curr.right != null) inOrderRecursive(curr.right);
    }
    public void inOrderMorris(Node<E> curr){
        if(curr == null) return;

        Set<Node<E>> seen = new HashSet<>();
        while(true){
            if(curr.left != null){
                // 1. Set rightMost.
                Node<E> rightMost = curr.left;
                while(rightMost.right != null){
                    rightMost = rightMost.right;
                }
                rightMost.right = curr;
                seen.add(curr);

                // Dive into next : tree left element.
                curr = curr.left;
                continue;
            }

            // Si node.left est vide alors
            System.out.println(curr.element);

            // Vérification Morris
            Node<E> suspiciousMorris = curr.right;
            if(suspiciousMorris != null && seen.contains(suspiciousMorris)){
                System.out.println(suspiciousMorris.element);
                curr.right = null; // Rompre le lien Morris.
                curr = suspiciousMorris.right;
                continue;
            }

            if(curr.right != null){
                curr = curr.right;
                continue;
            }

            break;
        }
    }
    public void inOrderMorrisCorrection(Node<E> curr){
        List<E> answer = new ArrayList<>();

        while(curr != null){
            if(curr.left == null){
                answer.add(curr.element);
                curr = curr.right;
                continue;
            }

            Node<E> rightMost = curr.left;
            while(rightMost.right != null && rightMost.right != curr ){
                rightMost = rightMost.right;
            }

            if(rightMost.right == null){
                rightMost.right = curr;
                curr = curr.left;
            }
            else{
                rightMost.right = null;
                answer.add(curr.element);
                curr = curr.right;
            }
        }
    }


    // _______________________ TRAVERSAL, Post order____________________
    /**
     * Post Order => Left / Right / Node
     */
    public void postOrderTraversal(Node<E> c){
        if(c.left != null){
            postOrderTraversal(c.left);
        }
        if(c.right != null){
            postOrderTraversal(c.right);
        }
        System.out.println(c.element);
    }
    public void postOrderStack(Node<E> c){
        Deque<Node<E>> stack = new ArrayDeque<>();
        stack.push(c);
        Set<Node<E>> values = new HashSet<>();
        while(!stack.isEmpty()){
            Node<E> current = stack.peek(); // 1
            if(current.left != null && !values.contains(current.left)){
                stack.push(current.left);
                continue;
            }
            if(current.right != null && !values.contains(current.right)){
                stack.push(current.right);
                continue;
            }
            values.add(current);
            System.out.println(current.element);
            stack.pop();
        }
    }



    // ####################################################################
    // #################### BT Operation and ALGORITHM ####################

    // 1. Invert a binary tree
    public void invertBinaryTreeFirstIteration(List<Node<E>> lst){
        if(lst.isEmpty()) return;

        List<Node<E>> current = new ArrayList<>();
        for(Node<E> e : lst){
            Node<E> currentLeft = null;
            Node<E> currentRight = null;

            if(e.left != null) {
                current.add(e.left);
                currentLeft = e.left;
            };

            if(e.right != null) {
                current.add(e.right);
                currentRight = e.right;
            };

            e.left  = currentRight;
            e.right = currentLeft;
        }
        invertBinaryTreeFirstIteration(current);
    }
    public void invertBinaryTreeCorrection(Node<E> r){
        Deque<Node<E>> queue = new ArrayDeque<>();
        queue.offer(r);

        while(!queue.isEmpty()){
           Node<E> curr = queue.poll();

           Node<E> tmp = curr.left;
           curr.left = curr.right;
           curr.right = tmp;

            if(curr.left != null) queue.offer(curr.left);
            if(curr.right != null) queue.offer(curr.right);
        }
    }

    // TODO => Correction
    //2. Maximum depth of binary tree recursive
    public int maximumDepthOfBinaryTreeDFS(Node<E> current, int counter){
        int maxcounter = 0;

        if(current.left != null){
            maxcounter = Math.max(maximumDepthOfBinaryTreeDFS(current.left, counter + 1), maxcounter);
        }

        if(current.right != null){
            maxcounter = Math.max(maximumDepthOfBinaryTreeDFS(current.right, counter + 1), maxcounter);
        }

        return Math.max(counter, maxcounter);
    }
    public int maximumDepthOfBinaryTreeUsingQueueBFS(Node<E> current){
        if(current == null) return 0;

        int counter = 0;
        Deque<Node<E>> queue = new ArrayDeque<>();
        queue.offer(current);

        while (!queue.isEmpty()){
            counter += 1;
            int nbrOfElementInLevel = queue.size();
            while(nbrOfElementInLevel > 0){
                Node<E> element = queue.poll();
                if(element.left != null){queue.offer(element.left);}
                if(element.right != null){queue.offer(element.right);}
                nbrOfElementInLevel -= 1;
            }

        }

        return counter;
    }
    public int maximumDepthOfBinaryTreeLastNode(Node<E> current){
        if(current == null) return 0;
        int counter = 0;

        Deque<Node<E>> queue = new ArrayDeque<>();
        queue.offer(current);

        while(!queue.isEmpty()){
            Node<E> lastNode = queue.peekLast();

            while(true){
                Node<E> inner = queue.poll();

                if(inner.left != null){queue.offer(inner.left);}
                if(inner.right != null){queue.offer(inner.right);}

                if(inner == lastNode){counter += 1; break;}
            }
        }

        return counter;
    }


    // Correction
    // recursive, top down approach =>
    public int maxDepthRecursive(Node<E> current, int counter){
        counter = current != null ? counter + 1 : counter;
        if(current == null) return counter;
        return Math.max(maxDepthRecursive(current.left, counter), maxDepthRecursive(current.right, counter));
    }

    // recursive bottom-up
    public int maxDepthRecursiveBottomUp(Node<E> current){
        if(current == null) return 0;

        var leftRs  = 1 + maxDepthRecursiveBottomUp(current.left);
        var rightRs = 1 + maxDepthRecursiveBottomUp(current.right);
        return Math.max(leftRs, rightRs);
    }
    public int maxDepthRecursiveBottomUpFinal(Node<E> current){
        if(current == null) return 0;

        var left  = maxDepthRecursiveBottomUpFinal(current.left);
        var right = maxDepthRecursiveBottomUpFinal(current.right);

        return 1 + Math.max(left, right);
    }

    // TODO => Iterative DFS
    public int iterativeDFS(Node<E> current){
        if(current == null) return 0;

        int maxLevel = 0;

        // Explication du Frame<E> a faire.
        record Frame<E>(Node<E> curr, int level){}
        Deque<Frame<E>> stack = new ArrayDeque<>();
        stack.push(new Frame<>(current, 1));

        while(!stack.isEmpty()){
            Frame<E> frame = stack.pop();
            maxLevel = Math.max(maxLevel, frame.level);

            if(frame.curr.right != null)stack.push(new Frame<>(frame.curr.right, frame.level + 1));
            if(frame.curr.left != null)stack.push(new Frame<>(frame.curr.left, frame.level + 1));
        }

        return maxLevel;
    }

    // ####################################################################
    // ########################## DISPLAY METHOD ##########################

    /**
     * Displays the tree level by level.
     */
    public void display(List<Node<E>> list, int indent){

        if(list.isEmpty())
            return;

        List<Node<E>> next = new ArrayList<>();

        for(Node<E> n : list){

            System.out.println(" ".repeat(indent) + n.getElement());

            if(n.getLeft() != null)
                next.add(n.getLeft());

            if(n.getRight() != null)
                next.add(n.getRight());
        }

        display(next, indent + 2);
    }
    public void display(){
        List<Node<E>> lstLevel = new ArrayList<>();

        if (this.Root == null) {System.out.println("The tree is empty...");return;}
        lstLevel.add(this.Root);

        while(!lstLevel.isEmpty()){
            List<Node<E>> tmp = new ArrayList<>();

            int leaf = 0;
            int count = 0;
            for(Node<E> e : lstLevel){
                if(count > 0){
                    System.out.print(e.element + " ");
                    leaf++;
                    count++;
                }

                else{
                    System.out.print(e.element + " ");
                    leaf++;
                    count++;
                }

                if(e.left != null){tmp.add(e.left);}
                if(e.right != null){tmp.add(e.right);}
            }

            System.out.println();
            if(!tmp.isEmpty()){
                for(int i = 0; i < leaf; i++){
                    System.out.print("/ \\" + "  ");
                }
            }
            System.out.println();
            lstLevel = tmp;
        }


    }
}