

import java.util.*;



public class ShortestPath {
    
    public static void main(String[] args) {
        // Create a directed graph
        GraphNew graph = new GraphNew();
        graph.addEdge("A", "B", 4);
        graph.addEdge("A", "C", 2);
        graph.addEdge("B", "C", 1);
        graph.addEdge("B", "D", 5);
        graph.addEdge("C", "D", 8);
        graph.addEdge("C", "E", 10);
        graph.addEdge("D", "E", 2);
        graph.addEdge("D", "F", 6);
        graph.addEdge("E", "F", 2);

        String startNode = "A";
        String endNode = "F";

        List<String> shortestPath = findShortestPath(graph, startNode, endNode);
        
        if (shortestPath != null) {
            System.out.println("Shortest Path from " + startNode + " to " + endNode + ": " + shortestPath);
        } else {
            System.out.println("No path found from " + startNode + " to " + endNode);
        }
    }
    
    public static List<String> findShortestPath(GraphNew graph, String startNode, String endNode) {
        Map<String, Integer> distances = new HashMap<>();
        Map<String, String> previous = new HashMap<>();
        PriorityQueue<String> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(distances::get));
        
        // Initialize distances and previous nodes
        for (String vertex : graph.getVertices()) {
            if (vertex.equals(startNode)) {
                distances.put(vertex, 0);
            } else {
                distances.put(vertex, Integer.MAX_VALUE);
            }
            previous.put(vertex, null);
            priorityQueue.add(vertex);
        }
        
        while (!priorityQueue.isEmpty()) {
            String current = priorityQueue.poll();
            if (current.equals(endNode)) {
                break;  // Reached the end node, stop iterating
            }
            
            List<Edge> neighbors = graph.getNeighbors(current);
            for (Edge edge : neighbors) {
                int distance = distances.get(current) + edge.getWeight();
                if (distance < distances.get(edge.getDestination())) {
                    distances.put(edge.getDestination(), distance);
                    previous.put(edge.getDestination(), current);
                    // Update priorityQueue with new distance
                    priorityQueue.remove(edge.getDestination());
                    priorityQueue.add(edge.getDestination());
                }
            }
        }
        
        // Reconstruct the shortest path
        List<String> shortestPath = new ArrayList<>();
        String current = endNode;
        while (current != null) {
            shortestPath.add(0, current);
            current = previous.get(current);
        }
        
        if (shortestPath.get(0).equals(startNode)) {
            return shortestPath;
        } else {
            return null;  // No path found
        }
    }
}

class GraphNew {
    private Map<String, List<Edge>> adjacencyList;

    public GraphNew() {
        adjacencyList = new HashMap<>();
    }

    public void addEdge(String source, String destination, int weight) {
        adjacencyList.computeIfAbsent(source, k -> new ArrayList<>()).add(new Edge(destination, weight));
    }

    public List<String> getVertices() {
        return new ArrayList<>(adjacencyList.keySet());
    }

    public List<Edge> getNeighbors(String vertex) {
        return adjacencyList.getOrDefault(vertex, new ArrayList<>());
    }
}

class Edge {
    private String destination;
    private int weight;

    public Edge(String destination, int weight) {
        this.destination = destination;
        this.weight = weight;
    }

    public String getDestination() {
        return destination;
    }

    public int getWeight() {
        return weight;
    }
}

