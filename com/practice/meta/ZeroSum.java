package com.practice.meta;

import java.util.HashMap;
import java.util.Map;

public class ZeroSum {

    public static int[] findZeroSum(int a[]){
        Map<Long, Integer> map = new HashMap<>();
        long sum  = 0;
        int start = 0;
        for(int i=0; i<a.length; i++){
            sum += a[i];
            if(sum == 0){
                return new int[]{0,i};
            }
            if(map.containsKey(sum)){
                start = map.get(sum) +1;
                return new int[]{start,i};
            }
            map.put(sum,i);
        }
        return new int[] {-1,-1};
    }
}
