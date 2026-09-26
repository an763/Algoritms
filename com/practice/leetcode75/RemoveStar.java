package com.practice.leetcode75;

import java.util.Stack;

public class RemoveStar {

    public String removeStars(String s) {
        char arr [] = s.toCharArray();
        Stack helper = new Stack();
        int removeWord = 0;

        for(int i = arr.length-1; i>=0; i--){
            if(arr[i] == '*' ){
                removeWord ++;
                continue;
            }
            if(arr[i] != '*' && removeWord > 0){
                removeWord--;
                continue;
            }
            helper.push(arr[i]);
        }
        StringBuilder sb = new StringBuilder();
        while (!helper.isEmpty()) {
            sb.append(helper.pop()); // pops from top, so order will be reversed
        }
        String result = sb.toString();
        return result;
    }

    public String removeStarsOpt(String s) {
        char[] a = s.toCharArray();
        int w = 0; // write pointer: size of "stack"
        for (char c : a) {
            if (c == '*') {
                if (w > 0) w--;   // pop last kept char
            } else {
                a[w++] = c;       // push char
            }
        }
        return new String(a, 0, w);
    }
}
