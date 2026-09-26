package com.practice;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class JavaStreams {


    public static void main(String[] args) {
        int[] intArray = {1, 2, 3, 4, 5};

        List<Integer> list = Arrays.stream(intArray)    // IntStream
                            .boxed()             // convert int → Integer
                            .collect(Collectors.toList());

        System.out.println(list); // [1, 2, 3, 4, 5]



    }



}
