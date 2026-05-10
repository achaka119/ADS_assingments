import java.util.List;

public class Experiment {

    public void runTraversals(Graph graph, int startVertex, boolean printTraversal) {
        System.out.println("-----------------------------------");
        System.out.println("Graph size: " + graph.getNumberOfVertices() + " vertices");

        long bfsStart = System.nanoTime();
        List<Integer> bfsOrder = graph.bfs(startVertex);
        long bfsEnd = System.nanoTime();
        long bfsTime = bfsEnd - bfsStart;

        long dfsStart = System.nanoTime();
        List<Integer> dfsOrder = graph.dfs(startVertex);
        long dfsEnd = System.nanoTime();
        long dfsTime = dfsEnd - dfsStart;

        if (printTraversal) {
            System.out.println("BFS Traversal Order:");
            System.out.println(bfsOrder);
            System.out.println("DFS Traversal Order:");
            System.out.println(dfsOrder);
        }
        System.out.println("BFS execution time: " + bfsTime + " ns");
        System.out.println("DFS execution time: " + dfsTime + " ns");
    }

    public void runMultipleTests() {
        Graph smallGraph = createGraph(10);
        Graph mediumGraph = createGraph(30);
        Graph largeGraph = createGraph(100);
        System.out.println("SMALL GRAPH STRUCTURE");
        smallGraph.printGraph();

        runTraversals(smallGraph, 0, true);
        runTraversals(mediumGraph, 0, false);
        runTraversals(largeGraph, 0, false);
    }

    private Graph createGraph(int size) {
        Graph graph = new Graph();

        for (int i = 0; i < size; i++) {
            graph.addVertex(new Vertex(i));
        }
        for (int i = 0; i < size - 1; i++) {
            graph.addEdge(i, i + 1);
        }
        for (int i = 0; i < size - 2; i += 2) {
            graph.addEdge(i, i + 2);
        }
        return graph;
    }

    public void printResults() {
        System.out.println("-----------------------------------");
        System.out.println("Experiment completed.");
        System.out.println("BFS and DFS were tested on graphs with 10, 30, and 100 vertices.");
        System.out.println("Both algorithms have time complexity O(V + E).");
    }
}