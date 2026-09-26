package com.practice.leetcode75;

import java.util.HashSet;
import java.util.Set;

public class ReverseVowels {


    public String reverseVowels(String s) {
        char [] arr = s.toCharArray();
        int start = 0; int end = arr.length-1;
        while(start < end){
            char startChar = arr[start];
            char endChar = arr[end];
            if(isVowel(startChar) && isVowel(endChar)){
                swapChar(arr, start, end);
                start++; end--;
            }else if(!isVowel(startChar) && !isVowel(endChar)){
                start++; end--;
            }else if(!isVowel(endChar)){
                end--;
            }else if(!isVowel(startChar)){
                start++;
            }
        }
        return new String(arr);
    }

    boolean isVowel(char c) {
        return c == 'a' || c == 'i' || c == 'e' || c == 'o' || c == 'u'
                || c == 'A' || c == 'I' || c == 'E' || c == 'O' || c == 'U';
    }

    private void swapChar(char [] arr, int start , int end){
        char temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
    }
}
