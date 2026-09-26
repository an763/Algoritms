package com.practice.meta;

class MergeSortedArrays {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int resultMover = m+n-1;
        int num1Mover = m-1;
        int num2Mover = n-1;

        while (num1Mover >= 0 && num2Mover >= 0){
            if(nums1[num1Mover] >= nums2[num2Mover]){
                nums1[resultMover] = nums1[num1Mover];
                num1Mover--;
                resultMover--;
            }else{
                nums1[resultMover] = nums2[num2Mover];
                num2Mover--;
                resultMover--;
            }
        }
        if(num1Mover >= 0){
            nums1[resultMover] = nums1[num1Mover];
            num1Mover--;
            resultMover--;
        }
        if(num2Mover >= 0){
            nums1[resultMover] = nums2[num2Mover];
            num2Mover--;
            resultMover--;
        }
    }

    public static void main(String args[]){
        int [] nums1 = new int[]{4,5,6,0,0,0};
        int [] nums2 = new int[]{1,2,3};
        merge(nums1,3,nums2,3);

    }
}