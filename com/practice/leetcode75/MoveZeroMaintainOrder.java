package com.practice.leetcode75;

public class MoveZeroMaintainOrder {

    public void moveZeroes(int[] nums) {
        int zt = 0;
        int nzt = 0;

        while(nzt < nums.length){
            if(nums[zt] == 0){
                while(nzt < nums.length && nums[nzt] == 0){
                    nzt++;
                }
                if(nzt == nums.length ) break;
                swap(nums,zt,nzt);
                nzt=zt;
            }
            zt++;
            nzt++;
        }
    }

    private void swap(int [] arr , int zt, int nzt){
        int temp  = arr[zt];
        arr[zt] = arr[nzt];
        arr[nzt] = temp;
    }
}
