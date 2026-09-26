package com.practice.leetcode75;

public class LongestSubArrayDelOne {
    public int longestSubarray(int[] nums) {
        int maxLength = 0;
        int zeros = 0;
        int left = 0;
        int k = 1;

        for(int right = 0; right < nums.length; right++){
            if(nums[right] == 0) zeros++;

            while(zeros > k){
                if(nums[left++] == 0) zeros--;
            }
            maxLength = Math.max(maxLength, right-left+1);
        }
        return maxLength-1  ;
    }
}
