package com.practice.leetcode75;

import java.util.Stack;

public class AstroidCollision {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> helper = new Stack();
        for(int i=asteroids.length-1; i>=0; i--){
            stackHelper(helper,asteroids[i]);
        }
        int [] result;
        int i =0;
        if(!helper.isEmpty()){
            result = new int [helper.size()];
            while(!helper.isEmpty()){
                result[i++] = helper.pop();
            }
        }else{
            result = new int[0];
        }
        return result;
    }

    private void stackHelper(Stack<Integer> helper , int asteroid){
        if(helper.isEmpty() || asteroid < 0) {
            helper.push(asteroid);
            return;
        }
        while(!helper.isEmpty()){
            if ((asteroid ^ helper.peek()) < 0){
                if (Math.abs(asteroid) > Math.abs(helper.peek())) {
                    helper.pop();
                    if(helper.isEmpty()) {
                        helper.push(asteroid);
                        break;
                    }
                }else if(Math.abs(asteroid) == Math.abs(helper.peek())){
                    helper.pop();
                    break;
                }else{
                    break;
                }
            }else{
                helper.push(asteroid);
                break;
            }
        }
    }
}
