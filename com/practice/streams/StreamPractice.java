package com.practice.streams;

import java.util.Arrays;
import java.util.List;

public class StreamPractice {

    public static void main(String args[]){
        List<Integer> numbers = Arrays.asList(1,2,3);
        int sum = numbers.stream().reduce(Integer.MAX_VALUE, (a,b) -> Math.min(a,b));
        System.out.println(sum);
    }
}
