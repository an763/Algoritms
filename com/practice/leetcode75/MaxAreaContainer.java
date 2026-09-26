package com.practice.leetcode75;

import java.util.HashMap;
import java.util.Map;

public class MaxAreaContainer {

    public int maxArea(int[] height) {
        int best = 0;
        int left = 0; int right = height.length -1;
        int wall = 0;

        while(left < right){
            wall = Math.min(height[left] , height[right]);
            best = Math.max(best , wall * (right - left));
            if(height[left] < height[right]){
                left++;
            }else{
                right--;
            }
        }
        return best;
    }
}
