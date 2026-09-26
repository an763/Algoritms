package com.practice.leetcode75;

public class MaxVowels {

    public int maxVowels(String s, int k) {
        int maxVowels = 0;

        for (int i = 0; i < k; i++) {
            maxVowels = maxVowels + (isVowel(s.charAt(i)) ? 1 : 0);
        }
        int runningVowels = maxVowels;
        int start = 0;
        for (int i = k; i < s.length(); i++) {
            runningVowels = runningVowels - (isVowel(s.charAt(start++)) ? 1 : 0) + (isVowel(s.charAt(i)) ? 1 : 0);
            maxVowels = Math.max(maxVowels, runningVowels);
        }
        return maxVowels;
    }
    private boolean isVowel(char c){
        return c == 'a' || c == 'e' || c=='i' || c == 'o' || c =='u';
    }
}
