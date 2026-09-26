package com.practice.leetcode75;

class MergeStrings {
    public String mergeAlternately(String word1, String word2) {
        int length1 = 0;
        int length2 = 0;
        StringBuilder merged = new StringBuilder();
        while(length1 < word1.length() && length2 < word2.length()) {
            merged = merged.append(word1.charAt(length1)).append(word2.charAt(length2));
            length1++;
            length2++;
        }

        if(word1.length() != word2.length()) {
            if(length1 == word1.length()) {
                merged.append(word2, length2, word2.length());
            }else {
                merged.append(word1, length1, word1.length());
            }
        }
        return merged.toString();
    }
}