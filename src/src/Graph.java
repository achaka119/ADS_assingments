import java.util.*;

public class Graph {

    private List<Vertex> vertices;
    private List<Edge> edges;

    public Graph() {
        vertices = new ArrayList<>();
        edges = new ArrayList<>();
    }
    public void addVertex(Vertex v) {
        vertices.add(v);
    }
    public void addEdge(int from, int to) {
        Vertex source = findVertex(from);
        Vertex destination = findVertex(to);
        if (source != null && destination != null) {
            edges.add(new Edge(source, destination));
            edges.add(new Edge(destination, source));
        }
    }
    private Vertex findVertex(int id) {
        for (Vertex v : vertices) {
            if (v.getId() == id) {
                return v;
            }
        }
        return null;
    }
    public void printGraph() {
        System.out.println("Graph edges:");

        for (Edge edge : edges) {
            System.out.println(edge);
        }
    }
    public List<Integer> bfs(int start) {
        List<Integer> order = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();

        visited.add(start);
        queue.add(start);
        while (!queue.isEmpty()) {
            int current = queue.poll();
            order.add(current);
            for (Edge edge : edges) {
                if (edge.getSource().getId() == current) {
                    int neighbor = edge.getDestination().getId();
                    if (!visited.contains(neighbor)) {
                        visited.add(neighbor);
                        queue.add(neighbor);
                    }
                }
            }
        }
        return order;
    }

    public List<Integer> dfs(int start) {
        List<Integer> order = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        dfsHelper(start, visited, order);

        return order;
    }

    private void dfsHelper(int current, Set<Integer> visited, List<Integer> order) {
        visited.add(current);
        order.add(current);
        for (Edge edge : edges) {
            if (edge.getSource().getId() == current) {
                int neighbor = edge.getDestination().getId();
                if (!visited.contains(neighbor)) {
                    dfsHelper(neighbor, visited, order);
                }
            }
        }
    }
    public int getNumberOfVertices() {
        return vertices.size();
    }
}