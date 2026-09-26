package com.practice;

import java.util.*;

public class DFS {

    public static class Node {
        List<Node> neighbors;
        int value ;
        public Node(int val){
            this.value = val;
            neighbors = new ArrayList<>();
        }
    }

    public void dfsTraversal(Node root){
            Set<Node> visited = new HashSet<>();
            dfsTraverse(root,visited);
    }

    public void dfsTraverse(Node node , Set<Node> visited){
        if(node == null || visited.contains(node)) return;
        System.out.print(node.value+ ", ");
        visited.add(node);
        for(Node neighb : node.neighbors){
                dfsTraverse(neighb, visited);
        }
    }

    public boolean searchDFS(Node root, Node target){
        if(root == null || target == null ) return false;
        if(root == target) return true;
        Set<Node> visited = new HashSet<>();
        return searchDFS(root, target, visited);
    }

    public boolean searchDFS(Node root, Node target, Set<Node> visited){
        if(root == null || target == null) return false;
        if(root == target) return true;
        if(visited.contains(root)) return false;
        visited.add(root);

        for(Node neighb : root.neighbors){
            if(searchDFS(neighb,target,visited)){
                return true;
            }
        }
        return false;
    }

    public static void main(String args[]) throws InterruptedException {
        while(true){
            Thread.sleep(5000);
            System.out.println("testing");

        }
    }

    public void dfsTraverse(Node node){
        if (node == null) return;
        Set<Node> visited = new HashSet<>();
        dfsTravel(node, visited);
    }

    public void dfsTravel(Node node, Set<Node> visited){
        if(node == null) return;
        visited.add(node);
        System.out.println("Visited node "+node.value);

        for(Node neighbor : node.neighbors){
            if(!visited.contains(neighbor)){
                dfsTravel(neighbor,visited);
            }
        }
    }

    public void bfs(Node node){
        Queue<Node> queue = new LinkedList<>();
        Set<Node> visited = new HashSet<>();
        queue.add(node);
        while (!queue.isEmpty()){
            Node myNode = queue.poll();
            System.out.println("Visited "+myNode.value);
            visited.add(myNode);
            for (Node neighbor : myNode.neighbors){
                if(!visited.contains(neighbor)){
                    queue.add(neighbor);
                }

            }
        }
    }


    public Node cloneGraph(Node root){
        Map<Node, Node> mapper = new HashMap<>();
        return cloneGraph(root,mapper);
    }

    public Node cloneGraph(Node node , Map<Node, Node> mapper){
        if(node == null) return null;
        // check if mapper contains node
        if(mapper.containsKey(node)) return mapper.get(node);

        Node clonedNode = new Node(node.value);
        mapper.put(node,clonedNode);

        for(Node neighbor : node.neighbors){
            clonedNode.neighbors.add(cloneGraph(neighbor,mapper));
        }
        return clonedNode;
    }


}
