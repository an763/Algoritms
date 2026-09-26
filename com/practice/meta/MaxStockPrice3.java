package com.practice.meta;

public class MaxStockPrice3 {

    public int findMaxPrice(int a[]){
        int [] max_profit_forward = new int[a.length];
        int [] max_profit_bakcward = new int[a.length];

        int min_price = Integer.MAX_VALUE;
        int max_profit_f = Integer.MIN_VALUE;

        for(int i= 0; i<a.length;i++){
            min_price = Math.min(min_price, a[i] );
            max_profit_f = Math.max(max_profit_f, a[i] - min_price);
            max_profit_forward[i] = max_profit_f;
        }

        int max_price_b = Integer.MIN_VALUE;
        int max_profit_b = Integer.MIN_VALUE;

        for(int i=a.length-1; i>=0; i--){
              max_price_b = Math.max(max_price_b, a[i]);
              max_profit_b = Math.max(max_profit_b , max_price_b - a[i]);
            max_profit_bakcward[i] =  max_profit_b;
        }
        int max_profit = 0;
        for(int i=0; i<a.length  ; i++){
            max_profit = Math.max(max_profit_forward[i] + max_profit_bakcward[i] , max_profit);
        }

        return max_profit;

    }
}
