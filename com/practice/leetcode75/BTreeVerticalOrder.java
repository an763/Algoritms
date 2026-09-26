package com.practice.leetcode75;

public class BTreeVerticalOrder {

   public static void main(String args[]){
       for(int i = 1; i<= 10; i++){
           int stars = 2*i-1;
           int spaces = 10 - i;
           System.out.println(" ".repeat(spaces) + "*".repeat(stars)+" ".repeat(spaces));
       }

   }

}


class Node {
    Node left;
    Node right;
    int value;
}