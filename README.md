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

J'ai donc construit mon propre sommaire. Chaque structure de données et chaque algorithme a sa propre page `.md`, rangée dans son dossier à côté du code : le cours, la complexité des opérations, les points à retenir et la liste des exercices.

## Sommaire

| # | Chapitre | Notions | Page | Progression |
|---|----------|---------|------|:---:|
| **I** | **Fundamental Data Structures** | Arrays, Singly Linked List, Circularly Linked List, Doubly Linked List | [Arrays.md](src/main/java/org/example/data_structure/arrays/Arrays.md) · [LinkedList.md](src/main/java/org/example/data_structure/linked_list/LinkedList.md) | 28 / 93 |
| **II** | **Algorithm Analysis** | Big-O & Complexity | [AlgorithmAnalysis.md](src/main/java/org/example/algorithms/algorithm_analysis/AlgorithmAnalysis.md) | 0 / 1 |
| **III** | **Recursion** | Linear Recursion, Binary Recursion, Multiple Recursion | [Recursion.md](src/main/java/org/example/algorithms/recursion/Recursion.md) | 3 / 36 |
| **IV** | **Stacks, Queues & Deques** | Stack, Queue, Deque | [StackQueue.md](src/main/java/org/example/data_structure/stack_queue/StackQueue.md) | 0 / 31 |
| **V** | **Lists & Iterators** | ArrayList, Positional List, Iterators | [List.md](src/main/java/org/example/data_structure/list/List.md) | 1 / 1 |
| **VI** | **Trees** | General Trees, Binary Trees, Implementation, Traversal Algorithms | [Trees.md](src/main/java/org/example/data_structure/trees/Trees.md) | 0 / 33 |
| **VII** | **Priority Queues** | Priority Queue, Implementation, Heaps, Sorting with a Priority Queue | [PriorityQueue.md](src/main/java/org/example/data_structure/priority_queue/PriorityQueue.md) | 0 / 20 |
| **VIII** | **Maps, Hash Tables & Sets** | Map, Hash Table, Sorted Map, Skip List, Sets | [Map.md](src/main/java/org/example/data_structure/map/Map.md) · [Set.md](src/main/java/org/example/data_structure/set/Set.md) | 4 / 13 |
| **IX** | **Search Trees** | Binary Search Tree, Balanced Search Trees, AVL Tree, Red-Black Tree | [SearchTrees.md](src/main/java/org/example/data_structure/search_trees/SearchTrees.md) | 0 / 15 |
| **X** | **Sorting & Selection** | Sorting, Selection | [Sorting.md](src/main/java/org/example/algorithms/sorting/Sorting.md) | 0 / 7 |
| **XI** | **Binary Search** | Binary Search | [BinarySearch.md](src/main/java/org/example/algorithms/binary_search/BinarySearch.md) | 0 / 32 |
| **XII** | **Two Pointers & Sliding Window** | Two Pointers, Sliding Window | [TwoPointersSlidingWindow.md](src/main/java/org/example/algorithms/two_pointers_sliding_window/TwoPointersSlidingWindow.md) | 0 / 13 |
| **XIII** | **Dynamic Programming & Greedy** | Dynamic Programming, Greedy Method | [DynamicProgrammingGreedy.md](src/main/java/org/example/algorithms/dynamic_programming_greedy/DynamicProgrammingGreedy.md) | 0 / 67 |
| **XIV** | **Text Processing** | Pattern Matching, Tries, Text Compression | [TextProcessing.md](src/main/java/org/example/algorithms/text_processing/TextProcessing.md) | 0 / 31 |
| **XV** | **Graph Algorithms** | Graph ADT, Graph Data Structures, Graph Traversals, Directed Acyclic Graphs, Shortest Paths, Minimum Spanning Trees | [Graph.md](src/main/java/org/example/data_structure/graph/Graph.md) | 0 / 46 |
| **XVI** | **Memory Management & B-Trees** | Memory Management, Memory Hierarchy & Caching, B-Trees, External-Memory Sorting | [BTrees.md](src/main/java/org/example/data_structure/b_trees/BTrees.md) | — |

Les exercices viennent de la [Striver A2Z DSA Sheet](https://takeuforward.org/prep-hub/strivers-a2z-dsa-sheet), complétés par mes propres exercices. Chaque page contient son tableau de suivi : ✅ fait · 🟡 en cours · ⬜ à faire.

## Organisation du repo

Un dossier par structure de données ou par algorithme, avec sa page `.md` à l'intérieur :

```
src/main/java/org/example/
├── data_structure/
│   ├── map/
│   │   ├── Map.md                # Le cours et la liste des exercices
│   │   ├── implementation/
│   │   └── exercices/
│   ├── arrays/
│   │   └── Arrays.md
│   └── ...
└── algorithms/
    ├── binary_search/
    │   └── BinarySearch.md
    └── ...

src/test/java/                    # Les tests JUnit, rangés de la même façon
```

## Lancer les tests

```bash
mvn test
```

## Référence

- Michael T. Goodrich, Roberto Tamassia, Michael H. Goldwasser — *Data Structures and Algorithms in Java*, 6th edition, Wiley.
