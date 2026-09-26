package com.practice.threads;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ListProducerConsumerWaitNotify  {

    Queue<Integer> queue = new LinkedList<>();
    int CAPACITY = 5;
    Object myLock = new Object();

    public void produce() throws InterruptedException{
        int item =0;
        while(true){
            synchronized (myLock) {
                while (queue.size() == CAPACITY) {
                    myLock.wait();
                }
                queue.add(item++);
                myLock.notifyAll();
            }
        }
    }

    public void consume() throws InterruptedException{
        while(true) {
            synchronized (myLock) {

                while (queue.isEmpty()) {
                    myLock.wait();
                }
                System.out.println("consumed == " + queue.poll());
                myLock.notifyAll();
            }
        }
        }
    }



class ListProducerConsumerWaitNotifyDemo {
    public static void main(String args[]){
        ListProducerConsumerWaitNotify demoObj = new ListProducerConsumerWaitNotify();
        Runnable producerThread = new Runnable() {
            @Override
            public void run() {
                try {
                    demoObj.produce();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };

        Runnable consumerThread = new Runnable() {
            @Override
            public void run() {
                try {
                    demoObj.consume();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };

        Thread producerObj = new Thread(producerThread);
        Thread consumerObj = new Thread(consumerThread);
        producerObj.start();
        consumerObj.start();
    }
}
