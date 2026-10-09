# Data Structures & Algorithms

Ce repository représente pour moi quelque chose de fondamental.

Après deux années à écrire du code et à apprendre des frameworks, j'ai fini par comprendre que tout repose sur l'algorithmique et les structures de données.

## D'où vient ce repo

J'ai un autre repo dans lequel je recode des petits jeux en console. C'est d'ailleurs historiquement ce tout premier repo qui m'a appris à coder. Dans ma liste de jeux, il y avait un petit projet : coder un sudoku.

À l'époque, l'IA n'existait pas, ou du moins n'était pas aussi omniprésente qu'aujourd'hui, et je me suis retrouvé bloqué. Je n'avais aucune connaissance en structures de données ni en algorithmique. En cherchant comment résoudre cet exercice, je suis tombé sur deux notions : les **piles** (*stacks*) et la **récursion**.

Je les ai apprises, et toutes les deux m'ont donné du fil à retordre. La récursion a été de loin la plus difficile : je pense ne l'avoir vraiment comprise que plusieurs mois après l'avoir étudiée.

Quand je suis revenu sur ce problème, la solution m'a paru évidente. J'en ai même écrit deux : l'une avec deux piles, l'autre avec la récursion. C'est, encore aujourd'hui, ma plus grande fierté de développeur. Non pas parce que c'est quelque chose d'exceptionnel, mais parce que c'était la première fois que je raisonnais de manière algorithmique, en choisissant comment organiser mes données.

Depuis, j'ai pris goût à l'algorithmique et aux structures de données.

## L'approche

J'ai décidé de creuser le sujet avec le livre ***Data Structures and Algorithms in Java*** de **Michael T. Goodrich**. C'est un excellent ouvrage pour apprendre deux choses essentielles : la programmation orientée objet et la réimplémentation de ces structures.

Il manque cependant quelques notions pour couvrir tout le spectre, notamment les grands *patterns* d'exercices : **Binary Search**, **Two Pointers**, **Sliding Window**, **Dynamic Programming** et **Greedy**.

J'ai donc construit mon propre sommaire. Chaque notion a sa propre page : le cours, la complexité des opérations, l'implémentation et les points à retenir. Chaque chapitre se termine par une page d'exercices.

## Sommaire

| # | Chapitre | Notions |
|---|----------|---------|
| **I** | **Fundamental Data Structures** | [Arrays](src/main/java/org/example/data_structure/arrays/doc/Arrays.md) · [Singly Linked List](src/main/java/org/example/data_structure/linked_list/doc/SinglyLinkedList.md) · [Circularly Linked List](src/main/java/org/example/data_structure/linked_list/doc/CircularlyLinkedList.md) · [Doubly Linked List](src/main/java/org/example/data_structure/linked_list/doc/DoublyLinkedList.md) |
| **II** | **Algorithm Analysis** | [Big-O & Complexity](src/main/java/org/example/algorithms/algorithm_analysis/doc/AlgorithmAnalysis.md) |
| **III** | **Recursion** | [Linear Recursion](src/main/java/org/example/algorithms/recursion/doc/LinearRecursion.md) · [Binary Recursion](src/main/java/org/example/algorithms/recursion/doc/BinaryRecursion.md) · [Multiple Recursion](src/main/java/org/example/algorithms/recursion/doc/MultipleRecursion.md) |
| **IV** | **Stacks, Queues & Deques** | [Stack](src/main/java/org/example/data_structure/stack_queue/doc/Stack.md) · [Queue](src/main/java/org/example/data_structure/stack_queue/doc/Queue.md) · [Deque](src/main/java/org/example/data_structure/stack_queue/doc/Deque.md) · [Exercices](src/main/java/org/example/data_structure/stack_queue/exercices/README.md) |
| **V** | **Lists & Iterators** | [ArrayList](src/main/java/org/example/data_structure/list/doc/ArrayList.md) · [Positional List](src/main/java/org/example/data_structure/list/doc/PositionalList.md) · [Iterators](src/main/java/org/example/data_structure/list/doc/Iterators.md) · [Exercices](src/main/java/org/example/data_structure/list/exercices/README.md) |
| **VI** | **Trees** | [General Trees](src/main/java/org/example/data_structure/trees/doc/GeneralTrees.md) · [Binary Trees](src/main/java/org/example/data_structure/trees/doc/BinaryTrees.md) · [Implementation](src/main/java/org/example/data_structure/trees/doc/Implementation.md) · [Traversal Algorithms](src/main/java/org/example/data_structure/trees/doc/TraversalAlgorithms.md) · [Exercices](src/main/java/org/example/data_structure/trees/exercices/README.md) |
| **VII** | **Priority Queues** | [Priority Queue](src/main/java/org/example/data_structure/priority_queue/doc/PriorityQueue.md) · [Implementation](src/main/java/org/example/data_structure/priority_queue/doc/Implementation.md) · [Heaps](src/main/java/org/example/data_structure/priority_queue/doc/Heaps.md) · [Sorting with a Priority Queue](src/main/java/org/example/data_structure/priority_queue/doc/PriorityQueueSort.md) · [Exercices](src/main/java/org/example/data_structure/priority_queue/exercices/README.md) |
| **VIII** | **Maps, Hash Tables & Sets** | [Map](src/main/java/org/example/data_structure/map/doc/Map.md) · [Hash Table](src/main/java/org/example/data_structure/map/doc/HashTable.md) · [Sorted Map](src/main/java/org/example/data_structure/map/doc/SortedMap.md) · [Skip List](src/main/java/org/example/data_structure/map/doc/SkipList.md) · [Sets](src/main/java/org/example/data_structure/set/doc/Sets.md) · [Exercices](src/main/java/org/example/data_structure/map/exercices/README.md) |
| **IX** | **Search Trees** | [Binary Search Tree](src/main/java/org/example/data_structure/search_trees/doc/BinarySearchTree.md) · [Balanced Search Trees](src/main/java/org/example/data_structure/search_trees/doc/BalancedSearchTrees.md) · [AVL Tree](src/main/java/org/example/data_structure/search_trees/doc/AVLTree.md) · [Red-Black Tree](src/main/java/org/example/data_structure/search_trees/doc/RedBlackTree.md) · [Exercices](src/main/java/org/example/data_structure/search_trees/exercices/README.md) |
| **X** | **Sorting & Selection** | [Sorting](src/main/java/org/example/algorithms/sorting/doc/Sorting.md) · [Selection](src/main/java/org/example/algorithms/sorting/doc/Selection.md) · [Exercices](src/main/java/org/example/algorithms/sorting/exercices/README.md) |
| **XI** | **Binary Search** | [Binary Search](src/main/java/org/example/algorithms/binary_search/doc/BinarySearch.md) · [Exercices](src/main/java/org/example/algorithms/binary_search/exercices/README.md) |
| **XII** | **Two Pointers & Sliding Window** | [Two Pointers](src/main/java/org/example/algorithms/two_pointers_sliding_window/doc/TwoPointers.md) · [Sliding Window](src/main/java/org/example/algorithms/two_pointers_sliding_window/doc/SlidingWindow.md) · [Exercices](src/main/java/org/example/algorithms/two_pointers_sliding_window/exercices/README.md) |
| **XIII** | **Dynamic Programming & Greedy** | [Dynamic Programming](src/main/java/org/example/algorithms/dynamic_programming_greedy/doc/DynamicProgramming.md) · [Greedy Method](src/main/java/org/example/algorithms/dynamic_programming_greedy/doc/Greedy.md) · [Exercices](src/main/java/org/example/algorithms/dynamic_programming_greedy/exercices/README.md) |
| **XIV** | **Text Processing** | [Pattern Matching](src/main/java/org/example/algorithms/text_processing/doc/PatternMatching.md) · [Tries](src/main/java/org/example/algorithms/text_processing/doc/Tries.md) · [Text Compression](src/main/java/org/example/algorithms/text_processing/doc/TextCompression.md) · [Exercices](src/main/java/org/example/algorithms/text_processing/exercices/README.md) |
| **XV** | **Graph Algorithms** | [Graph ADT](src/main/java/org/example/data_structure/graph/doc/GraphADT.md) · [Graph Data Structures](src/main/java/org/example/data_structure/graph/doc/GraphDataStructures.md) · [Graph Traversals](src/main/java/org/example/data_structure/graph/doc/GraphTraversals.md) · [Directed Acyclic Graphs](src/main/java/org/example/data_structure/graph/doc/DirectedAcyclicGraphs.md) · [Shortest Paths](src/main/java/org/example/data_structure/graph/doc/ShortestPaths.md) · [Minimum Spanning Trees](src/main/java/org/example/data_structure/graph/doc/MinimumSpanningTrees.md) · [Exercices](src/main/java/org/example/data_structure/graph/exercices/README.md) |
| **XVI** | **Memory Management & B-Trees** | [Memory Management](src/main/java/org/example/data_structure/b_trees/doc/MemoryManagement.md) · [Memory Hierarchy & Caching](src/main/java/org/example/data_structure/b_trees/doc/MemoryHierarchyCaching.md) · [B-Trees](src/main/java/org/example/data_structure/b_trees/doc/BTrees.md) · [External-Memory Sorting](src/main/java/org/example/data_structure/b_trees/doc/ExternalMemorySorting.md) · [Exercices](src/main/java/org/example/data_structure/b_trees/exercices/README.md) |

## Organisation du repo

Chaque notion a son propre dossier, qui regroupe tout ce qui la concerne :

```
src/main/java/org/example/
├── data_structure/
│   ├── map/
│   │   ├── implementation/       # Mon implémentation de la structure
│   │   ├── exercices/            # Les exercices (+ README.md avec la liste)
│   │   └── doc/                  # Le cours : définition, complexité, à retenir
│   ├── arrays/
│   ├── linked_list/
│   └── ...
└── algorithms/
    ├── binary_search/
    ├── two_pointers_sliding_window/
    └── ...

src/test/java/                    # Les tests JUnit, rangés de la même façon
```

## Lancer les tests

```bash
mvn test
```

## Référence

- Michael T. Goodrich, Roberto Tamassia, Michael H. Goldwasser — *Data Structures and Algorithms in Java*, 6th edition, Wiley.
