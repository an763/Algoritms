package com.practice.threads;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicBoolean;

public class ThreadPoolExecutor {

    BlockingQueue<Runnable> taskQueue = null;
    Worker workers [] = null;
    AtomicBoolean isShutdown = new AtomicBoolean(false);
    public ThreadPoolExecutor(int num){
        taskQueue = new LinkedBlockingQueue<>(num);
        createThreadsAndStore(num);
    }


    private void createThreadsAndStore(int numThreads){
        workers = new Worker[numThreads];
        for(int i=0; i<numThreads; i++){
            workers[i] = new Worker();
            workers[i].start();
        }
    }

    public void submit(Runnable task){
        if(!isShutdown.get()){
            taskQueue.offer(task);
        }else{
            throw new IllegalStateException("The task can not be added as its shutdown");
        }
    }

    public void shutDown(){
        isShutdown.set(true);
        for(Worker worker : workers){
            worker.interrupt();
        }
    }

    public  class Worker extends Thread{
        public void run(){
            try {
                while (true) {
                    Runnable task;
                    if (!isShutdown.get() || !taskQueue.isEmpty()) {
                        task = taskQueue.poll();
                        if (task != null) {
                            task.run();
                        } else {
                            Thread.sleep(50);
                        }
                    }else{
                        break;
                    }
                }
            }catch(Exception e){
                // catch Exception
            }
        }

    }

    public static void main(String args[]){
        // for CPU intensive
    /*    int coreCount = Runtime.getRuntime().availableProcessors();
        ExecutorService service = Executors.newFixedThreadPool(coreCount);

        // for io intensive
        coreCount = 100;
         service = Executors.newFixedThreadPool(coreCount);*/
        ThreadPoolExecutor tp = new ThreadPoolExecutor(10);
        Thread worker = new Thread(() -> System.out.println("Anurag"));
        tp.submit(worker);

    }

}
