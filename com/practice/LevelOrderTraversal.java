package com.practice;

import java.util.*;

public class LevelOrderTraversal {
    public static class Node{
        List<Node> neighbors;
        int value;
        public Node(int val){
            value = val;
        }
    }

    public void traverseLevelOrder(Node root){
        Set<Node> visited = new HashSet<>();
        Queue<Node> holder = new LinkedList<>();
        Node marker = new Node(-1);

        holder.add(root);
        holder.add(marker);

        while(!holder.isEmpty()){
            Node current = holder.poll();
            if(visited.contains(current)) continue;
            if(current  == marker){
                System.out.println("#######");
                if(!holder.isEmpty()) {
                    holder.add(marker);
                }
                continue;
            }else{
                System.out.print(current.value +",");
                visited.add(current);
            }
            for (Node neighb : current.neighbors){
                holder.add(neighb);
            }
        }
    }

}
