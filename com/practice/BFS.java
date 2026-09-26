package com.practice;

import java.util.*;

public class BFS {

    public static class Node{
        List<Node> neighbors;
        int value;

        public Node( int val){
            value = val;
            neighbors = new ArrayList<>();
        }
    }

    public void BFSTraversal(Node root){
        Set<Node> visited = new HashSet<>();
        Queue<Node> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);
        visited.add(root);
        while(!nodeQueue.isEmpty()){
            Node current = nodeQueue.poll();
            System.out.println(current.value+",");
            for(Node neighb : current.neighbors){
                 if(visited.contains(neighb)) continue;
                 visited.add(neighb);
                 nodeQueue.add(neighb);
            }
        }
    }

    public boolean BFSSearch(Node root, Node target){
        if(target == null || root == null) return false;
        if(root == target) return true;
        Set<Node> visited = new HashSet<>();
        Queue<Node> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);
        visited.add(root);
        while(!nodeQueue.isEmpty()){
            Node current = nodeQueue.poll();
            for(Node neighb : current.neighbors){
                if(neighb == target) return true;
                if(visited.contains(neighb)) continue;
                visited.add(neighb);
                nodeQueue.add(neighb);
            }
        }
        return false;
    }
}
