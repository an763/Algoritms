package com.practice.leetcode75;

public class ReverseStringWords {

    public String reverseWords(String s) {
        s = s.trim();
        StringBuilder sb = new StringBuilder();
        int endPointer = s.length();
        for(int i = s.length()-1; i>=0; i--){
            if(s.charAt(i) == ' '){
                if(s.charAt(i+1) != ' '){
                    sb.append(s.substring(i+1,endPointer));
                    sb.append(' ');
                }
                endPointer = i;
            }
        }
        sb.append(s.substring(0, endPointer));
        return sb.toString();
    }
}
