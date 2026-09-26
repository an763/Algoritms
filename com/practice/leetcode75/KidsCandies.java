package com.practice.leetcode75;

import java.util.ArrayList;
import java.util.List;

public class KidsCandies {

    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = candies[0];
        for(int i =0; i<candies.length ; i++){
            max = candies[i] > max ? candies[i] : max;
        }
        List<Boolean> booleanList = new ArrayList<>();
        for(int i =0; i<candies.length ; i++){
            if(candies[i] + extraCandies >= max){
                booleanList.add(true);
            }else{
                booleanList.add(false);
            }
        }
        return booleanList;
    }
}
