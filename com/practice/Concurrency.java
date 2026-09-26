package com.practice;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Concurrency {

    public static void main(String args[]) throws InterruptedException {
      //  produceAndConsume(new Object(), 10);
        Random ran = new Random();
       int count =  ran.nextInt(20);
        System.out.println("main done ***************************************************************"+count);

    }

    public static void produceAndConsume(Object obj, int capacity) throws InterruptedException {
        BlockingQueue<Object> queue = new ArrayBlockingQueue<>(capacity);

        Thread producer = new Thread(() -> {
            try {
                for(int i=0; i< 100 ; i++) {
                    System.out.println("Going to put in queue "+i);
                    queue.put(new Object());
                    System.out.println("put done "+i);
                }
            }catch(Exception w){}
        });

        Thread consumer = new Thread(() -> {
            try {
                for(int i=0; i< 100 ; i++) {
                    System.out.println("Going to poll in queue "+i);
                    queue.take();
                    System.out.println("poll done "+i);
                }
            }catch(Exception w){}
        });

        producer.start();
        consumer.start();
        producer.join();
        consumer.join();
        System.out.println("all done ");
    }
}
