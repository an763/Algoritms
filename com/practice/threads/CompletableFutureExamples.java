package com.practice.threads;

import java.util.concurrent.*;

public class CompletableFutureExamples {

    public void customPools(){
        // Option 1: Fixed thread pool
        ExecutorService customPool = Executors.newFixedThreadPool(20);

        CompletableFuture.runAsync(() -> {
            System.out.println("");
            //doWork();
        }, customPool);  // ← Pass custom pool as second argument

// Option 2: Cached thread pool (grows as needed)
        ExecutorService cachedPool = Executors.newCachedThreadPool();

        CompletableFuture.supplyAsync(() -> {
            return "test"; // fetchData
        }, cachedPool);

// Option 3: Custom ForkJoinPool
        ForkJoinPool customForkJoin = new ForkJoinPool(50);

        CompletableFuture.runAsync(() -> {
            //doWork();
        }, customForkJoin);

        // When to Use Custom Thread Pools
        // 1. I/O-Heavy Operations (Need MORE threads)
        // Default pool: 7 threads (on 8-core CPU)
// But you're making 100 concurrent API calls - not enough!

        ExecutorService ioPool = Executors.newFixedThreadPool(100);

        for (int i = 0; i < 100; i++) {
            CompletableFuture.supplyAsync(() -> {
                return new Object();//httpClient.get(apiUrl);  // Blocking I/O
            }, ioPool);  // Use larger pool
        }

        // 2. CPU-Intensive Operations (Use DEFAULT pool)
        // Default pool is perfect for CPU-bound tasks
        for (int i = 0; i < 100; i++) {
            CompletableFuture.supplyAsync(() -> {
                return new Object();  // CPU work //heavyComputation(data);
            });  // No second argument = uses default pool
        }

        // DON'T block the common pool with JDBC!
        ExecutorService dbPool = Executors.newFixedThreadPool(20);

        CompletableFuture.supplyAsync(() -> {
            // Blocking JDBC call
            return new Object();//jdbcTemplate.queryForObject(sql, User.class);
        }, dbPool);  // Use dedicated pool for blocking DB calls


        // 1. Fixed Thread Pool - Fixed number of threads
        ExecutorService fixed = Executors.newFixedThreadPool(10);
// Good for: Known workload, prevent resource exhaustion

// 2. Cached Thread Pool - Creates threads as needed
        ExecutorService cached = Executors.newCachedThreadPool();
// Good for: Many short-lived tasks, I/O operations

// 3. Single Thread Executor - Only 1 thread
        ExecutorService single = Executors.newSingleThreadExecutor();
// Good for: Sequential processing, order matters

// 4. Scheduled Thread Pool - For delayed/periodic tasks
        ScheduledExecutorService scheduled =
                Executors.newScheduledThreadPool(5);
// Good for: Periodic tasks, delayed execution

// 5. Work-Stealing Pool (ForkJoinPool) - Dynamic work distribution
        ForkJoinPool forkJoin = new ForkJoinPool(20);
// Good for: Recursive tasks, divide-and-conquer algorithms


    }
}
//3. Mixed Workloads (Separate pools)
class MyService {
    // Pool for I/O operations
    private final ExecutorService ioPool =
            Executors.newFixedThreadPool(50);

    // Pool for CPU operations (or use default)
    private final ExecutorService cpuPool =
            Executors.newFixedThreadPool(
                    Runtime.getRuntime().availableProcessors()
            );

    public CompletableFuture<String> fetchData() {
        return CompletableFuture.supplyAsync(() -> {
            return new String() ; //httpClient.get(url);
        }, ioPool);  // I/O work
    }

    public CompletableFuture<Integer> processData(String data) {
        return CompletableFuture.supplyAsync(() -> {
            return Integer.parseInt("2");// heavyComputation(data);
        }, cpuPool);  // CPU work
    }
}
