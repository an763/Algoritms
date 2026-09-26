package com.practice.threads;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class ExecutorFrameworkExample {

    public static int square(int n){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return n*n;
    }

    public static void main(String args[]){
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        executorService.submit(() -> System.out.println("test"));


        List<Callable<Integer>>  callables = Arrays.asList(
                () -> square(1),
                () -> square(2),
                () -> square(3),
                () -> square(4),
                () -> square(5)

        );
        List<Future<Integer>> results = null;
        try {

            results = executorService.invokeAll(callables);
            int total = 0;
            for (Future<Integer> result : results){
                total += result.get();
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }finally {
            executorService.shutdown();
            try {
                if(executorService.awaitTermination(5,TimeUnit.SECONDS)){
                    executorService.shutdown();
                }
            } catch (InterruptedException e) {
                executorService.shutdown();
            }
        }

    }
}
