package com.practice.leetcode75;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class UniqueOccurences {

    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            map.put(arr[i], map.getOrDefault(arr[i],0)+1);
        }
        Set<Integer> valueHolder = new HashSet<>();
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            if(valueHolder.contains(entry.getValue())){
                return false;
            }else{
                valueHolder.add(entry.getValue());
            }
        }
        return true;
    }
}
