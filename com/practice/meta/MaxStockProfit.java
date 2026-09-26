package com.practice.meta;

public class MaxStockProfit {


    public static long findMaxProfit(int [] a) {
        int min = Integer.MAX_VALUE;
        int maxProfit = Integer.MIN_VALUE;

        for (int i = 0; i <a.length; i++){
            min = Math.min(min,a[i]);
            maxProfit = Math.max(maxProfit , a[i] - min);
        }
        return maxProfit;
    }
}
