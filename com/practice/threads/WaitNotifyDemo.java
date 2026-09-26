package com.practice.threads;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

class SharedBuffer {
    private int data;
    private boolean available = false; // Buffer empty at first
    private ReentrantLock myLock = new ReentrantLock();
    private Condition myCond = myLock.newCondition();

    // Producer puts data
    public synchronized void produce(int value) {


        while (available) { // Buffer is full
            try {
                wait(); // Wait until consumer consumes
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        data = value;
        available = true;
        System.out.println("Produced: " + data);
        notifyAll(); // Wake up waiting threads
    }

    // Consumer gets data
    public synchronized int consume() {
        while (!available) { // Buffer is empty
            try {
                wait(); // Wait until producer produces
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        available = false;
        System.out.println("Consumed: " + data);
        notifyAll(); // Wake up producer
        return data;
    }
}

public class WaitNotifyDemo {
    public static void main(String[] args) throws InterruptedException {
        SharedBuffer buffer = new SharedBuffer();

        // Producer thread
        Thread producer = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                buffer.produce(i);
            }
        });

        // Consumer thread
        Thread consumer = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                buffer.consume();
            }
        });

        producer.start();
        consumer.start();
//        producer.join();
//        consumer.join();
    }
}