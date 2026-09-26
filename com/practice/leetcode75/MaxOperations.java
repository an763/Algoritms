package com.practice.leetcode75;

import java.util.HashMap;
import java.util.Map;

public class MaxOperations {
    //[1,2,3,4] k=5
    public int maxOperations(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int ops = 0;
        for(int num : nums){
            int search = k-num;
            if(map.getOrDefault(search, 0) > 0){
                ops++;
                if(map.get(search) == 1) {
                    map.remove(search);
                }else{
                    map.put(search,map.get(search) -1);
                }
            }else{
                map.put(num, map.getOrDefault(num,0)+1);
            }
        }
        return ops;
    }

}
