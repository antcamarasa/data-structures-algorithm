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

J'ai donc repris le sommaire du livre et j'y ai ajouté ces notions comme de nouveaux chapitres.

## Sommaire

| # | Chapitre | Page |
|:-:|----------|------|
| 1 | Fundamental Data Structures | [Arrays.md](src/main/java/org/example/data_structure/arrays/Arrays.md) · [LinkedList.md](src/main/java/org/example/data_structure/linked_list/LinkedList.md) |
| 2 | Two Pointers | [TwoPointers.md](src/main/java/org/example/algorithms/two_pointers/TwoPointers.md) |
| 3 | Sliding Window | [SlidingWindow.md](src/main/java/org/example/algorithms/sliding_window/SlidingWindow.md) |
| 4 | Algorithm Analysis | [AlgorithmAnalysis.md](src/main/java/org/example/algorithms/algorithm_analysis/AlgorithmAnalysis.md) |
| 5 | Recursion | [Recursion.md](src/main/java/org/example/algorithms/recursion/Recursion.md) |
| 6 | Backtracking | [Backtracking.md](src/main/java/org/example/algorithms/backtracking/Backtracking.md) |
| 7 | Stacks, Queues, and Deques | [Stack.md](src/main/java/org/example/data_structure/stack_queue/stack/Stack.md) · [Queue.md](src/main/java/org/example/data_structure/stack_queue/queue/Queue.md) · [Deque.md](src/main/java/org/example/data_structure/stack_queue/deque/Deque.md) |
| 8 | List and Iterator ADTs | [List.md](src/main/java/org/example/data_structure/list/List.md) |
| 9 | Trees | [Trees.md](src/main/java/org/example/data_structure/trees/Trees.md) |
| 10 | Priority Queues | [PriorityQueue.md](src/main/java/org/example/data_structure/priority_queue/PriorityQueue.md) |
| 11 | Maps, Hash Tables, and Skip Lists | [Map.md](src/main/java/org/example/data_structure/map/Map.md) · [Set.md](src/main/java/org/example/data_structure/set/Set.md) |
| 12 | Binary Search | [BinarySearch.md](src/main/java/org/example/algorithms/binary_search/BinarySearch.md) |
| 13 | Search Trees | [SearchTrees.md](src/main/java/org/example/data_structure/search_trees/SearchTrees.md) |
| 14 | Sorting and Selection | [Sorting.md](src/main/java/org/example/algorithms/sorting/Sorting.md) |
| 15 | Text Processing | [TextProcessing.md](src/main/java/org/example/algorithms/text_processing/TextProcessing.md) |
| 16 | Greedy | [Greedy.md](src/main/java/org/example/algorithms/greedy/Greedy.md) |
| 17 | Dynamic Programming | [DynamicProgramming.md](src/main/java/org/example/algorithms/dynamic_programming/DynamicProgramming.md) |
| 18 | Graph Algorithms | [Graph.md](src/main/java/org/example/data_structure/graph/Graph.md) |
| 19 | Memory Management and B-Trees | [BTrees.md](src/main/java/org/example/data_structure/b_trees/BTrees.md) |

## Organisation du repo

Un dossier par structure de données ou par algorithme, avec sa page `.md` à l'intérieur :

```
src/main/java/org/example/
├── data_structure/
│   ├── map/
│   │   ├── Map.md
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
