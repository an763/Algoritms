package com.practice.meta;

public class MaxStockProfit2 {

    public static int maxProfit2(int a[]){
        int profit = 0;
        for(int i= 1; i< a.length; i++){
            if(a[i] > a[i-1]){
                profit += a[i] - a[i-1];
            }
        }
        return profit;
    }
}
