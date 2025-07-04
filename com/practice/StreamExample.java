package com.practice;

import java.util.List;
import java.util.stream.Collectors;

public class StreamExample {
    public static void main(String[] args) {
        List<String> names = List.of("Alice", "ABob", "Charlie", "ADavid");
        
        System.out.println(names.stream().allMatch(s -> s.startsWith("A")));
        System.out.println(names.stream().anyMatch(s -> s.startsWith("A")));
        
        
        List<String> filteredNames = names.stream()
                                          .filter(name -> name.startsWith("A"))
                                          .map(String::toUpperCase)
                                          .sorted()
                                          .collect(Collectors.toList());

        filteredNames.forEach(System.out::println);
    }
}