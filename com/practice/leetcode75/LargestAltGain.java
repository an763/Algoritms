package com.practice.leetcode75;

public class LargestAltGain {

    public int largestAltitude(int[] gain) {
        int best = 0;
        int current = 0;

        for(int g : gain){
            current = current + g;
            best = Math.max(best , current);
        }
        return best;
    }
}
