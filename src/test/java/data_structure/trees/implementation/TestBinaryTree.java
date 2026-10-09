package data_structure.trees.implementation;
import org.example.data_structure.trees.implementation.BinaryTreeImplementation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

public class TestBinaryTree {
    BinaryTreeImplementation<Integer> binaryTree;
    BinaryTreeImplementation<Integer> t1;
    BinaryTreeImplementation<Integer> t2;

    @BeforeEach
    public void setUp(){
        this.binaryTree = new BinaryTreeImplementation<>();
        this.t1 = new BinaryTreeImplementation<>();
        this.t2 = new BinaryTreeImplementation<>();
    }

    @Test
    public void testBinaryTree(){
        BinaryTreeImplementation.Node<Integer> position  = this.binaryTree.addRoot(1);

        BinaryTreeImplementation.Node<Integer> rootT1 = this.t1.addRoot(2);
        this.t1.addLeft(rootT1, 4);
        this.t1.addRight(rootT1, 5);

        BinaryTreeImplementation.Node<Integer> rootT2 = this.t2.addRoot(3);
        this.t2.addLeft(rootT2, 6);
        this.t2.addRight(rootT2, 7);

        List<BinaryTreeImplementation.Node<Integer>> lstT1 = new ArrayList<>();
        lstT1.add(rootT1);
        //binaryTree.display(lstT1, 1);

        List<BinaryTreeImplementation.Node<Integer>> lstT2 = new ArrayList<>();
        lstT1.add(rootT2);
        //binaryTree.display(lstT2, 1);

        binaryTree.attach(position, t1, t2);
        List<BinaryTreeImplementation.Node<Integer>> lst = new ArrayList<>();
        lst.add(position);
        binaryTree.display(lst, 1);
    }

    @Test
    public void testAddBinaryTree(){
        binaryTree.add(1);
        binaryTree.add(2);
        binaryTree.add(3);
        binaryTree.add(4);
        binaryTree.add(5);
        binaryTree.add(6);
        binaryTree.add(7);
        binaryTree.add(8);
        binaryTree.add(9);
        binaryTree.add(10);
        binaryTree.add(11);
        binaryTree.add(12);
        binaryTree.add(13);
        binaryTree.add(14);
        binaryTree.levelOrderTraversals();
    }

    @Test
    public void testLevelOrderTraversalsRecursive(){
        BinaryTreeImplementation.Node<Integer> root = binaryTree.addRoot(1);
        binaryTree.add(2);
        binaryTree.add(3);
        binaryTree.add(4);
        binaryTree.add(5);
        binaryTree.add(6);
        binaryTree.add(7);

        List<BinaryTreeImplementation.Node<Integer>> lst = new ArrayList<>();
        lst.add(root);

        binaryTree.levelOrderTraversalsRecursive(lst);
    }

    @Test
    public void testPreOrderTraversalsRecursif(){
            BinaryTreeImplementation.Node<Integer> root = binaryTree.addRoot(1);
            binaryTree.add(2);
            binaryTree.add(3);
            binaryTree.add(4);
            binaryTree.add(5);
            binaryTree.add(6);
            binaryTree.add(7);


            binaryTree.preOrderTraversalsRecursif(root);
    }

    @Test
    public void testPreOrderTraversalStack(){
        BinaryTreeImplementation.Node<Integer> root = binaryTree.addRoot(1);
        binaryTree.add(2);
        binaryTree.add(3);
        binaryTree.add(4);
        binaryTree.add(5);
        binaryTree.add(6);
        binaryTree.add(7);

        binaryTree.preOrderTraversalStack(root);
    }

    @Test
    public void testInOrderTraversal(){
        BinaryTreeImplementation.Node<Integer> root = binaryTree.addRoot(4);
        binaryTree.add(2);
        binaryTree.add(6);
        binaryTree.add(1);
        binaryTree.add(3);
        binaryTree.add(5);
        binaryTree.add(7);

        binaryTree.inOrderUsingStack(root);
    }

    @Test
    public void testPostOrderTraversal(){
        BinaryTreeImplementation.Node<Integer> root = binaryTree.addRoot(1);
        binaryTree.add(2);
        binaryTree.add(3);
        binaryTree.add(4);
        binaryTree.add(5);
        binaryTree.add(6);
        binaryTree.add(7);

        binaryTree.postOrderStack(root);
    }


    // ============================ Correction ================================
    @Test
    public void preOrderTraversalSecond(){
        BinaryTreeImplementation.Node<Integer> root = binaryTree.addRoot(1);
        binaryTree.add(2);
        binaryTree.add(3);
        binaryTree.add(4);
        binaryTree.add(5);
        binaryTree.add(6);
        binaryTree.add(7);

        binaryTree.morris(root);
    }

    @Test
    public void testInOrderSecondUsingStack(){
        BinaryTreeImplementation.Node<Integer> root = binaryTree.addRoot(4);
        binaryTree.add(2);
        binaryTree.add(6);
        binaryTree.add(1);
        binaryTree.add(3);
        binaryTree.add(5);
        binaryTree.add(7);

        binaryTree.inOrderMorrisCorrection(root);
    }

    // =========================== Invert a binary tree ===========================
    @Test
    public void testInvertBinaryTree(){
        BinaryTreeImplementation.Node<Integer> root = binaryTree.addRoot(4);
        binaryTree.add(2);
        binaryTree.add(7);
        binaryTree.add(1);
        binaryTree.add(3);
        binaryTree.add(6);
        binaryTree.add(9);



        List<BinaryTreeImplementation.Node<Integer>> lst = new ArrayList<>(List.of(root));
        binaryTree.invertBinaryTreeFirstIteration(lst);
        binaryTree.display();
    }

    @Test
    public void testLevelOrderUsingQueue(){
        BinaryTreeImplementation.Node<Integer> root = binaryTree.addRoot(4);
        binaryTree.add(2);
        binaryTree.add(7);
        binaryTree.add(1);
        binaryTree.add(3);
        binaryTree.add(6);
        binaryTree.add(9);

        Deque<BinaryTreeImplementation.Node<Integer>> queue = new ArrayDeque<>();
        queue.push(root);

        binaryTree.levelOrderUsingQueue(queue);
    }

    @Test
    public void testInvertBinaryTreeCorrection(){
        BinaryTreeImplementation.Node<Integer> root = binaryTree.addRoot(4);
        binaryTree.add(2);
        binaryTree.add(7);
        binaryTree.add(1);
        binaryTree.add(3);
        binaryTree.add(6);
        binaryTree.add(9);

        binaryTree.invertBinaryTreeCorrection(root);
        binaryTree.display();
    }

    // ====================== Maximum depth of  a binary tree =======================
    @Test
    public void testMaximumDepthOfBinaryTree(){
        BinaryTreeImplementation.Node<Integer> root = binaryTree.addRoot(1);
        binaryTree.add(2);
        binaryTree.add(3);
        binaryTree.add(4);

        int maxDepth = binaryTree.maximumDepthOfBinaryTreeDFS(root, 1);
        System.out.println("Max depth : " + maxDepth);
    }

    @Test
    public void testMaximumDepthOfBinaryTreeUsingQueue(){
        BinaryTreeImplementation.Node<Integer> root = binaryTree.addRoot(1);
        binaryTree.add(2);
        binaryTree.add(3);
        binaryTree.add(4);
        binaryTree.add(5);
        binaryTree.add(6);
        binaryTree.add(7);
        binaryTree.add(8);

        int maxDepth = binaryTree.maximumDepthOfBinaryTreeUsingQueueBFS(root);
        System.out.println("Maximum depth : " + maxDepth);
    }

    @Test
    public void testMaximumDepthOfBinaryTreeLastNode(){
        BinaryTreeImplementation.Node<Integer> root = binaryTree.addRoot(1);
        binaryTree.add(2);
        binaryTree.add(3);
        binaryTree.add(4);
        binaryTree.add(5);
        binaryTree.add(6);
        binaryTree.add(7);
        binaryTree.add(8);

        int maxDepth = binaryTree.maximumDepthOfBinaryTreeLastNode(root);
        System.out.println("Maximum depth : " + maxDepth);
    }

    @Test
    public void testMaxDepthRecursive(){
        BinaryTreeImplementation.Node<Integer> root = binaryTree.addRoot(1);
        binaryTree.add(2);
        binaryTree.add(3);
        binaryTree.add(4);
        binaryTree.add(5);
        binaryTree.add(6);
        binaryTree.add(7);
        binaryTree.add(8);

        binaryTree.maxDepthRecursiveBottomUp(root);
    }

    @Test
    public void testIterativeDFS(){
        BinaryTreeImplementation.Node<Integer> root = binaryTree.addRoot(3);
        binaryTree.add(9);
        binaryTree.add(20);
        binaryTree.add(15);
        binaryTree.add(7);
        binaryTree.add(14);
        binaryTree.add(22);

        int maxLevel = binaryTree.iterativeDFS(root);
        System.out.println("Maxlevel : " + maxLevel);
    }
}
