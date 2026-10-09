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
| **I** | **Fundamental Data Structures** | [Arrays](docs/01-fundamental-data-structures/Arrays.md) · [Singly Linked List](docs/01-fundamental-data-structures/SinglyLinkedList.md) · [Circularly Linked List](docs/01-fundamental-data-structures/CircularlyLinkedList.md) · [Doubly Linked List](docs/01-fundamental-data-structures/DoublyLinkedList.md) |
| **II** | **Algorithm Analysis** | [Big-O & Complexity](docs/02-algorithm-analysis/AlgorithmAnalysis.md) |
| **III** | **Recursion** | [Linear Recursion](docs/03-recursion/LinearRecursion.md) · [Binary Recursion](docs/03-recursion/BinaryRecursion.md) · [Multiple Recursion](docs/03-recursion/MultipleRecursion.md) |
| **IV** | **Stacks, Queues & Deques** | [Stack](docs/04-stacks-queues-deques/Stack.md) · [Queue](docs/04-stacks-queues-deques/Queue.md) · [Deque](docs/04-stacks-queues-deques/Deque.md) · [Exercices](docs/04-stacks-queues-deques/Exercices.md) |
| **V** | **Lists & Iterators** | [ArrayList](docs/05-lists-iterators/ArrayList.md) · [Positional List](docs/05-lists-iterators/PositionalList.md) · [Iterators](docs/05-lists-iterators/Iterators.md) · [Exercices](docs/05-lists-iterators/Exercices.md) |
| **VI** | **Trees** | [General Trees](docs/06-trees/GeneralTrees.md) · [Binary Trees](docs/06-trees/BinaryTrees.md) · [Implementation](docs/06-trees/Implementation.md) · [Traversal Algorithms](docs/06-trees/TraversalAlgorithms.md) · [Exercices](docs/06-trees/Exercices.md) |
| **VII** | **Priority Queues** | [Priority Queue](docs/07-priority-queues/PriorityQueue.md) · [Implementation](docs/07-priority-queues/Implementation.md) · [Heaps](docs/07-priority-queues/Heaps.md) · [Sorting with a Priority Queue](docs/07-priority-queues/PriorityQueueSort.md) · [Exercices](docs/07-priority-queues/Exercices.md) |
| **VIII** | **Maps, Hash Tables & Sets** | [Map](docs/08-maps-hash-tables-sets/Map.md) · [Hash Table](docs/08-maps-hash-tables-sets/HashTable.md) · [Sorted Map](docs/08-maps-hash-tables-sets/SortedMap.md) · [Skip List](docs/08-maps-hash-tables-sets/SkipList.md) · [Sets](docs/08-maps-hash-tables-sets/Sets.md) · [Exercices](docs/08-maps-hash-tables-sets/Exercices.md) |
| **IX** | **Search Trees** | [Binary Search Tree](docs/09-search-trees/BinarySearchTree.md) · [Balanced Search Trees](docs/09-search-trees/BalancedSearchTrees.md) · [AVL Tree](docs/09-search-trees/AVLTree.md) · [Red-Black Tree](docs/09-search-trees/RedBlackTree.md) · [Exercices](docs/09-search-trees/Exercices.md) |
| **X** | **Sorting & Selection** | [Sorting](docs/10-sorting-selection/Sorting.md) · [Selection](docs/10-sorting-selection/Selection.md) · [Exercices](docs/10-sorting-selection/Exercices.md) |
| **XI** | **Binary Search** | [Binary Search](docs/11-binary-search/BinarySearch.md) · [Exercices](docs/11-binary-search/Exercices.md) |
| **XII** | **Two Pointers & Sliding Window** | [Two Pointers](docs/12-two-pointers-sliding-window/TwoPointers.md) · [Sliding Window](docs/12-two-pointers-sliding-window/SlidingWindow.md) · [Exercices](docs/12-two-pointers-sliding-window/Exercices.md) |
| **XIII** | **Dynamic Programming & Greedy** | [Dynamic Programming](docs/13-dynamic-programming-greedy/DynamicProgramming.md) · [Greedy Method](docs/13-dynamic-programming-greedy/Greedy.md) · [Exercices](docs/13-dynamic-programming-greedy/Exercices.md) |
| **XIV** | **Text Processing** | [Pattern Matching](docs/14-text-processing/PatternMatching.md) · [Tries](docs/14-text-processing/Tries.md) · [Text Compression](docs/14-text-processing/TextCompression.md) · [Exercices](docs/14-text-processing/Exercices.md) |
| **XV** | **Graph Algorithms** | [Graph ADT](docs/15-graph-algorithms/GraphADT.md) · [Graph Data Structures](docs/15-graph-algorithms/GraphDataStructures.md) · [Graph Traversals](docs/15-graph-algorithms/GraphTraversals.md) · [Directed Acyclic Graphs](docs/15-graph-algorithms/DirectedAcyclicGraphs.md) · [Shortest Paths](docs/15-graph-algorithms/ShortestPaths.md) · [Minimum Spanning Trees](docs/15-graph-algorithms/MinimumSpanningTrees.md) · [Exercices](docs/15-graph-algorithms/Exercices.md) |
| **XVI** | **Memory Management & B-Trees** | [Memory Management](docs/16-memory-management-b-trees/MemoryManagement.md) · [Memory Hierarchy & Caching](docs/16-memory-management-b-trees/MemoryHierarchyCaching.md) · [B-Trees](docs/16-memory-management-b-trees/BTrees.md) · [External-Memory Sorting](docs/16-memory-management-b-trees/ExternalMemorySorting.md) · [Exercices](docs/16-memory-management-b-trees/Exercices.md) |

## Organisation du repo

```
.
├── docs/                         # Une page .md par notion, rangée par chapitre
│   ├── 01-fundamental-data-structures/
│   ├── ...
│   └── 16-memory-management-b-trees/
└── src/
    ├── main/java/org/example/
    │   ├── data_structure/       # Implémentations des structures de données
    │   └── algorithms/           # Implémentations des algorithmes et patterns
    └── test/java/                # Tests JUnit
```

## Lancer les tests

```bash
mvn test
```

## Référence

- Michael T. Goodrich, Roberto Tamassia, Michael H. Goldwasser — *Data Structures and Algorithms in Java*, 6th edition, Wiley.
