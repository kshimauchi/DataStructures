package Programming.Graphs;

import java.util.*;

public class Graph{

    private Map<Vertex, List<Vertex>> adjVertices;

    public Graph(){
        //no-arg constructor
    }

    public Graph(Map<Vertex, List<Vertex>> adjVertex) {
        this.adjVertices = adjVertex;
    }

    public Map<Vertex, List<Vertex>> getAdjList() {
        return adjVertices;
    }

    public void setAdjList(Map<Vertex, List<Vertex>> adjList) {
        this.adjVertices = adjList;
    }
    public void addVertex(String label){
        adjVertices.putIfAbsent(new Vertex(label), new ArrayList<>());
    }
    public void removeVertex(String label){
        Vertex v = new Vertex(label);
        adjVertices.values().stream().forEach(e -> e.remove(v));
        adjVertices.remove(new Vertex(label));
    }
    public void addEdge(String label1, String label2){
        Vertex v1 = new Vertex(label1);
        Vertex v2 = new Vertex(label2);
        adjVertices.get(v1).add(v2);
        adjVertices.get(v2).add(v1);
    }
    public void removeEdge(String label1, String label2){
        Vertex v1 = new Vertex(label1);
        Vertex v2 = new Vertex(label2);

        List<Vertex> eV1 = adjVertices.get(v1);
        List<Vertex> eV2 = adjVertices.get(v2);

        if(eV1 != null)
            eV1.remove(v2);
        if(eV2 != null)
            eV2.remove(v1);
    }
    public Graph makeGraph(){
        Graph graph = new Graph();

        graph.addVertex("Alice");
        graph.addVertex("Bob");
        graph.addVertex("Mark");
        graph.addVertex("Rob");
        graph.addVertex("Maria");

        graph.addEdge("Bob", "Alice");
        graph.addEdge("Bob", "Rob");
        graph.addEdge("Alice", "Mark");
        graph.addEdge("Rob", "Mark");
        graph.addEdge("Alice", "Maria");
        graph.addEdge("Rob", "Maria");

        return graph;
    }
    public List<Vertex> getAdjVertices(String label){
        return adjVertices.get(new Vertex(label));
    }
    public static Set<String> depthFirstTraversal(Graph graph, String root) {
        Set<String> visited = new LinkedHashSet<String>();
        Stack<String> stack = new Stack<String>();
        stack.push(root);
        while (!stack.isEmpty()) {
            String vertex = stack.pop();
            if (!visited.contains(vertex)) {
                visited.add(vertex);
                for (Vertex v : graph.getAdjVertices(vertex)) {
                    stack.push(v.label);
                }
            }
        }
        return visited;
    }
    public Set<String> breadthFirstTraversal(Graph graph, String root) {
        Set<String> visited = new LinkedHashSet<String>();
        Queue<String> queue = new LinkedList<String>();
        queue.add(root);
        visited.add(root);
        while (!queue.isEmpty()) {
            String vertex = queue.poll();
            for (Vertex v : graph.getAdjVertices(vertex)) {
                if (!visited.contains(v.label)) {
                    visited.add(v.label);
                    queue.add(v.label);
                }
            }
        }
        return visited;
    }
}
