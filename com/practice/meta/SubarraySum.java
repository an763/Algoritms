package com.practice.meta;

public class SubarraySum {

    public static int[] findSum(int [] a, int target) {

        int high = 0;
        int low = 0;
        int sum = 0;

        while (high < a.length ) {
            sum += a[high];

            while(sum > target && low <= high){
                sum -= a[low++];
            }

            if(sum == target){
                return  new int[] {low,high};
            }
        }

        return new int[]{-1,-1};
    }

}
