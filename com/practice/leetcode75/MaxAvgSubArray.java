package com.practice.leetcode75;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MaxAvgSubArray {

    public double findMaxAverage(int[] nums, int k) {
        Queue<Integer> myTracker = new LinkedList<>();
        double maxAvg = 0;
        int sumK = 0;
        for(int i=0; i <k ; i++){
            myTracker.add(nums[i]);
            sumK = sumK + nums[i];
            maxAvg = ((double)sumK)/k;
        }
        for(int i=k; i<nums.length;i++){
            int polled = myTracker.poll();
            myTracker.add(nums[i]);
            sumK = sumK - polled + nums[i];
            maxAvg = Math.max(maxAvg, ((double)sumK)/k);
        }
        return maxAvg;
    }

    public double findMaxAveragePointers(int[] nums, int k) {
        double maxAvg = 0;
        int sumK = 0;
        for(int i=0; i <k ; i++){
            sumK = sumK + nums[i];
            maxAvg = ((double)sumK)/k;
        }
        int start = 0;
        for(int i=k; i<nums.length;i++){
            int polled = nums[start++];
            sumK = sumK - polled + nums[i];
            maxAvg = Math.max(maxAvg, ((double)sumK)/k);
        }
        return maxAvg;
    }
}
