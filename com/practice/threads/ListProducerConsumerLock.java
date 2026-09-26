package com.practice.threads;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ListProducerConsumerLock {

    Queue<Integer> queue = new LinkedList<>();
    int CAPACITY = 5;

    ReentrantLock myLock = new ReentrantLock(true);
    Condition waitBecauseItsFull = myLock.newCondition();
    Condition waitBecauseItsEmpty = myLock.newCondition();

    public void producer() throws InterruptedException {
        int item = 0;
        while(true){
            try {

                myLock.lock();
                while (queue.size() == CAPACITY) {
                    waitBecauseItsFull.await();
                }
                queue.offer(item++);
                System.out.println("producing now "+ item);
                waitBecauseItsEmpty.signal();

            }finally {
                myLock.unlock();
            }
            Thread.sleep(2000);
        }
    }

    public void consumer() throws InterruptedException {
        while(true){
            try {
                myLock.lock();
                while (queue.isEmpty()) {
                    waitBecauseItsEmpty.await();
                }
                System.out.println("Consuming now "+ queue.poll());
                waitBecauseItsFull.signal();

            }finally {
                myLock.unlock();
            }
            Thread.sleep(2000);
        }
    }
}

class ListProducerConsumerLockDemo{

    public static void main(String args[]){
        ListProducerConsumerLock demoObj = new ListProducerConsumerLock();
        Thread producerThread = new Thread(()->{
                try {
                    demoObj.producer();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        );

        Thread consumerThread = new Thread(() -> {
            try {
                demoObj.consumer();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        producerThread.start();
        consumerThread.start();
    }
}
