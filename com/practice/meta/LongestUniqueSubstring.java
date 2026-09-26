package com.practice.meta;

import java.util.*;

public class LongestUniqueSubstring {

    public static int findLongestSubstring(String input){
        if(input == null || input.trim().equals("")) return 0;
        Map<Character , Integer> charHolder = new HashMap<>();
        input = input.trim();
        char[] a = input.toCharArray();
        int maxStart = 0;
        int maxEnd = 0;
        int start =0;
        int end = 0;
        for(int i=0; i<a.length; i++){
            if(charHolder.containsKey(a[i])) {
                start = Math.max(charHolder.get(a[i]) + 1, start);
            }
            charHolder.put(a[i], i);
            end = i;
            if(maxEnd - maxStart < end - start){
                maxEnd = end;
                maxStart = start;
            }
            Queue<Integer> queue = new LinkedList<>();

        }
       // return input.substring(maxStart,maxEnd+1);

        return maxEnd - maxStart +1;
    }

    public static void main(String args[]){
        System.out.println("Longest substring "+findLongestSubstring("  "));
    }

}
