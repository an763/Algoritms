package com.practice.threads;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class FutureExamples {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            return  "Anurag";
        }).thenApply(user -> {
            return  user.toLowerCase();
        });

    String name = future.get();
        CompletableFuture<String> futureOne = CompletableFuture.supplyAsync(() -> {
            return  "Anurag";
        });
        CompletableFuture<String> futureTwo = CompletableFuture.supplyAsync(() -> {
            return  "Alka";
        });
        CompletableFuture<String> futureThree = CompletableFuture.supplyAsync(() -> {
            return  "Arnav";
        });
        CompletableFuture<String> futureFour = CompletableFuture.supplyAsync(() -> {
            return  "Arav";
        });
        CompletableFuture<String> futureFive = CompletableFuture.supplyAsync(() -> {
            return  "Buddy";
        });

        CompletableFuture<Void> allDone = CompletableFuture.allOf(futureOne,futureTwo,futureThree,futureFour,futureFive);
        allDone.thenApply(v->{
            String one = futureOne.join();
            String two = futureTwo.join();
            String three = futureThree.join();
            String four = futureFour.join();
            String five = futureFive.join();
        return one + two  + three+four+five;
        });

    }

}
