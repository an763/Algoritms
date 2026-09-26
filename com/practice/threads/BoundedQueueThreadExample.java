package com.practice.threads;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class BoundedQueueThreadExample<T> {

    T myItem [];

    int CAPACITY = 0;
    int head = 0;
    int tail = 0;
    int count = 0;
    ReentrantLock myLock = new ReentrantLock(true);

    Condition full = myLock.newCondition();
    Condition empty = myLock.newCondition();
    public BoundedQueueThreadExample(int capacity){
        CAPACITY = capacity;
         myItem = (T[]) new Object [CAPACITY];
        int arr[] = new int [capacity];
    }


    public void produceItem(T object) throws InterruptedException {
        try {
            myLock.lock();
            while (count == CAPACITY) {
                full.await();
            }
            count++;
            myItem[tail] = object;
            tail = (tail + 1)% CAPACITY;
            empty.signal();
        }finally {
            myLock.unlock();
        }

    }

    public T consumeItem() throws InterruptedException {
        T obj = null;
        try{
        myLock.lock();
        while(count == 0){
            empty.await();
        }
        count--;
        obj = myItem[head];
        head = (head +1)% CAPACITY;
        full.signal();
     }finally {
            myLock.unlock();
        }
        return obj;
    }

    public static void main(String args[]){
        BoundedQueueThreadExample<Integer> boundedQ = new BoundedQueueThreadExample(3);

        Thread producer = new Thread(() -> {
            for(int i = 0; i< 50; i++){
                try {
                    System.out.println("Item produced "+ i);
                    boundedQ.produceItem(i);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }
        });

        Thread consumer = new Thread(()->{
            for(int i=0; i<50; i++){
                try {
                    System.out.println("Item consumed "+ boundedQ.consumeItem());
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }
        });

        producer.start();
        consumer.start();
    }


}
