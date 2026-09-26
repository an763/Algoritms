package com.practice.leetcode75;

public class MaxConsOnes {

    public int longestOnes(int[] nums, int k) {
        int maxLength = 0;
        int runningZero = 0;
        int left = 0;

        for(int right = 0; right < nums.length; right++ ){
            if(nums[right] == 0) runningZero++;

            while(runningZero > k){
                if(nums[left++] == 0) runningZero--;
            }

            maxLength = Math.max(maxLength , right-left + 1);
        }
        return maxLength;
    }
}
