package com.practice.leetcode75;

public class FlowerPlanting {

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int numPlant = 0;
        boolean canPlant = true;

        for(int i = 0; i< flowerbed.length; i++){
            if(flowerbed[i] == 0){
                int back =  i-1> 0 ? i-1 : 0;
                int forward =  i+1<flowerbed.length? i+1:i;
                if(flowerbed[back] == 0 && flowerbed[forward] == 0 && canPlant){
                    numPlant++;
                    canPlant = false;
                }else{
                    canPlant = true;
                }
            }
        }
        return numPlant >= n;
    }
}
