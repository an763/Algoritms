package com.practice.leetcode75;

import java.util.HashMap;
import java.util.Map;

public class EqualRowAndColumnPair {

    public int equalPairs(int[][] grid) {
        Map<String,Integer> pairMap = new HashMap<>();
        for(int row = 0 ; row < grid.length; row++){
            String key = encode(grid[row]);
            pairMap.put(key,pairMap.getOrDefault(key, 0) + 1);
        }
        int ans = 0;
        for(int i=0; i< grid.length; i++){
            int col [] = new int[grid.length];
            for(int j=0; j<grid.length; j++){
                col[j] = grid[j][i];
            }
            String key = encode(col);
            ans = ans + pairMap.getOrDefault(key, 0);
        }
        return ans;
    }


    private String encode(int [] arr){
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<arr.length; i++){
            if(i>0) sb.append(",");
            sb.append(arr[i]);
        }
        return sb.toString();
    }
}
