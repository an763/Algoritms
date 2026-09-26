package com.practice;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DFSTraverse {

    public void dfsTraverse(Node start) {
        if (start == null) return;
        Set<Node> visited = new HashSet<>();
        dfsVisit(start, visited);
    }

    private void dfsVisit(Node node, Set<Node> visited) {
        if (!visited.add(node)) return;        // mark & skip if seen
        System.out.println("Visited node " + node.val);

        if (node.neighbors == null) return;    // null-safe
        for (Node nb : node.neighbors) {
            if (nb != null) {
                dfsVisit(nb, visited);
            }
        }
    }

    public boolean dfsSearch(Node source, Node target){
        if(source == null || target == null) return false;
        if (source == target) return true;
        Set<Node> visited = new HashSet<>();
        return dfsSearch(source,target,visited);
    }

    public boolean dfsSearch(Node source, Node target,Set<Node> visited){
        if(source == target) return true;
        visited.add(source);
        for(Node neighbor : source.neighbors){
            if(neighbor != null && !visited.contains(neighbor)){
                if(dfsSearch(neighbor,target,visited)){
                    return true;
                }
            }
        }
        return false;
    }

    private static class Node{
        List<Node> neighbors;
        int val;

    }
}
