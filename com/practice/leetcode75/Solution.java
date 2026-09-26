package com.practice.leetcode75;

public class Solution {
    public static Integer maxScore(int[] cards, Integer k) {

        int start = 0;
        int sum = 0;
        int max_sum = 0;

        int [] new_cards = new int[cards.length+k];
        for(int i =0; i< cards.length; i++){
            new_cards[i] = cards[i];
        }
        for(int i = 0; i<k; i++){
            new_cards[cards.length + i] = cards[i];
        }

        for(int end = 0; end <  k; end++){
            sum += new_cards[end];
        }
        max_sum = sum;
        sum = 0;
        start = cards.length -k;
        for(int end = cards.length -k ; end < new_cards.length; end++ ){
            sum +=new_cards[end];
            if(end - start +1 > k){
                sum = sum - new_cards[start];
                max_sum = Math.max(max_sum, sum);
                start++;
            }
        }
        return max_sum;
    }

    public static void main(String args[]){
        int[] cards = {1,2,3,4,5,6,1};
        int k = 3;
        int max_sum = maxScore(cards,k);
    }
}