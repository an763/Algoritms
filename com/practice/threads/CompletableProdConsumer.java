package com.practice.threads;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Queue;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class CompletableProdConsumer {

    int capacity = 0;

    private ReentrantLock myLock = new ReentrantLock(true);
    private Condition notFull = myLock.newCondition();
    private Condition notEmpty = myLock.newCondition();
    private Queue<Integer> queue = new ArrayDeque<>();

    public CompletableProdConsumer(int capacity){
        this.capacity = capacity;
    }

    public void add(int num){
        myLock.lock();
        try {
        while(queue.size() == capacity) {

                notFull.await();

        }
            queue.add(num);

            notEmpty.signal();
         } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }finally{
            myLock.unlock();
        }

    }

    public int pop(){
        myLock.lock();
        try{
        while(queue.isEmpty()) {
            notEmpty.await();
        }

        int num = queue.poll();
        notFull.signal();
              return num;
        } catch (InterruptedException e) {
                throw new RuntimeException(e);
        }finally {
            myLock.unlock();
        }

    }

    public static void main(String[] args) {
        CompletableProdConsumer prodcon = new CompletableProdConsumer(5);
    /*    Thread producer = new Thread(() -> {
            for(int i=0; i<20; i++){
                System.out.println("produced "+i);
                prodcon.add(i);

            }
        });

        Thread consumer = new Thread(() -> {
            for (int i = 0; i< 20; i++){
                System.out.println("consumed  "+prodcon.pop());
            }
        });
        producer.start();
        consumer.start();*/

        CompletableFuture<Void> producer = CompletableFuture.runAsync(() -> {
            for(int i=0; i<20; i++){
                System.out.println("produced "+i);
                prodcon.add(i);
            }
        });

        CompletableFuture<Void> consumer =CompletableFuture.runAsync(() -> {
            for (int i = 0; i< 20; i++){
                System.out.println("consumed  "+prodcon.pop());
            }
        });

        CompletableFuture.allOf(producer, consumer).join();

    }
}
