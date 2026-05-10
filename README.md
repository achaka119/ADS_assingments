# ADS_assingments
### Name: Askar Kairatbek

### Group: IT-2501

#### Assignment 4 Graph Traversal and Representation System

## Project Overview

This project is a Java program that represents a graph using an adjacency list and performs two graph traversal algorithms:

- Breadth-First Search (BFS)
- Depth-First Search (DFS)

The program creates graphs of different sizes, runs BFS and DFS on each graph, and measures the execution time using `System.nanoTime()`.

A graph is made of vertices and edges.  
A vertex represents a node, and an edge represents a connection between two nodes.

Example:

```text
0 -- 1 -- 2
|         |
3 ------- 4
```

# Classes
### Vertex
The Vertex class represents a node in the graph.
It stores a unique ID for each vertex.

Main methods:
```text
Vertex(int id)
getId()
toString()
```
### Edge

The Edge class represents a connection between two vertices.
It stores:

1) source vertex
2) destination vertex

Main methods:
```text
Edge(Vertex source, Vertex destination)
getSource()
getDestination()
toString()
```
### Graph

The Graph class represents the graph using an adjacency list.
An adjacency list stores every vertex with its connected neighbors.

Example:

0 -> 1 2

1 -> 0 3

2 -> 0

3 -> 1

Main methods:
```text
addVertex(Vertex v)
addEdge(int from, int to)
printGraph()
bfs(int start)
dfs(int start)
```

# Algorithms
### Breadth-First Search, BFS

BFS visits vertices level by level.

It starts from one vertex, visits all direct neighbors first, then visits the neighbors of those neighbors.

BFS uses a queue.

BFS Steps:

Start from a vertex.
Mark it as visited.
Add it to the queue.
Remove the first vertex from the queue.
Visit all unvisited neighbors.
Add those neighbors to the queue.
Repeat until the queue is empty.

BFS is useful for:

finding the shortest path in an unweighted graph
exploring a graph level by level
finding the closest connection
BFS Complexity
O(V + E)

Where:
V is the number of vertices,
E is the number of edges

### Depth-First Search, DFS

DFS goes as deep as possible before going back.

It starts from one vertex, visits one neighbor, continues deeper, and then backtracks when there are no more unvisited neighbors.
DFS can be implemented using recursion or a stack.

DFS Steps:

Start from a vertex.
Mark it as visited.
Visit one unvisited neighbor.
Continue going deeper.
If there are no unvisited neighbors, go back.
Repeat until all reachable vertices are visited.

DFS is useful for:

path finding,
cycle detection,
connected components,
exploring all possible paths,
DFS Complexity
O(V + E)

Where:
V is the number of vertices,
E is the number of edges

| Graph Size | BFS Time (ns) | DFS Time (ns) |
|---|---------------|---------------|
| 10 vertices | 393250        | 13625         |
| 30 vertices | 55083         | 28666         |
| 100 vertices | 135792        | 94375         |

![Graph Structure](docs/images/output21.png)

![BFS Output and DFS Output](docs/images/output22.png)

# Analysis
### How does graph size affect BFS and DFS performance?

When the graph size increases, the execution time usually increases too. 
This is because both BFS and DFS need to visit more vertices and edges.
The graph with 100 vertices takes more time than the graph with 10 vertices.

### Which traversal is faster?

In my experiment, DFS was slightly faster than BFS.
However, the difference was small.
Both algorithms have similar performance because both have the same time complexity: O(V + E).

### Do the results match O(V + E)?

Yes, the results match the expected complexity.
BFS and DFS both visit each vertex and each edge once. 
Therefore, as the number of vertices and edges increases, the execution time also increases.

### How does graph structure affect traversal order?

Graph structure affects the order of traversal.
BFS visits nearby vertices first.
DFS goes deep into one path before returning to other vertices.
The traversal order also depends on the order of neighbors inside the adjacency list.

### When is BFS preferred over DFS?

BFS is preferred when we need to find the shortest path in an unweighted graph.
It is also useful when we want to explore nodes level by level.

### What are the limitations of DFS?

DFS does not always find the shortest path.
DFS can also go very deep in large graphs. If recursion is used, it may cause a stack overflow.

# Reflection

In this project, I learned how to represent a graph using an adjacency list in Java. 
I also learned how vertices and edges are used to build a graph structure.
I learned that BFS and DFS are both important graph traversal algorithms. 
BFS visits vertices level by level and is useful for finding the shortest path in an unweighted graph. 
DFS goes deep into one path before backtracking and is useful for exploring paths and detecting cycles.
One challenge was understanding how the visited set works. 
It is important because it prevents the program from visiting the same vertex many times.