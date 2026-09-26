package com.practice.threads;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class BoundedBlockingQueue<T> {

    private final ReentrantLock myLock = new ReentrantLock();
    private final Condition enqueue = myLock.newCondition();
    private final Condition dequeue = myLock.newCondition();

    private int head = 0, tail = 0, count = 0, capacity;
    private final T[] myQueue;

    @SuppressWarnings("unchecked")
    public BoundedBlockingQueue(int capacity){
        if (capacity <= 0) throw new IllegalStateException("Capacity must be greater than zero");
        this.capacity = capacity;
        this.myQueue = (T[]) new Object[capacity];
    }

    public void enqueue(T myObject) throws InterruptedException {
        if (myObject == null) throw new NullPointerException("Item added cannot be null");
        myLock.lock();
        try {
            while (count == capacity) {
                enqueue.await();
            }
            myQueue[tail] = myObject;
            tail = (tail + 1) % capacity;
            count++;
            dequeue.signal();
        } finally {
            myLock.unlock();
        }
    }

    public T dequeue() throws InterruptedException {
        myLock.lock();
        try {
            while (count == 0) {
                dequeue.await();
            }
            T myObj = myQueue[head];
            myQueue[head] = null;
            head = (head + 1) % capacity;
            count--;
            enqueue.signal();
            return myObj;
        } finally {
            myLock.unlock();
        }
    }

    // Test with threads
    public static void main(String[] args) throws InterruptedException {
        BoundedBlockingQueue<TestWorker> queue = new BoundedBlockingQueue<>(2);
        Arrays.asList(1, 2, 3);
        Thread producer = new Thread(() -> {
            try {
                for(int i=0; i< 5; i++) {
                    queue.enqueue(new TestWorker("Anurag", "77 Franklin Dr, Voorhees"));
                    System.out.println("Produced: Anurag");
                    Thread.sleep(1000);

                    queue.enqueue(new TestWorker("Arnav", "77 Franklin Dr, Voorhees"));
                    System.out.println("Produced: Arnav");
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        Thread consumer = new Thread(() -> {
            try {
                while(true) {
                    Thread.sleep(500);
                    TestWorker w1 = queue.dequeue();
                    System.out.println("Consumed: ");
                    w1.print();

                    TestWorker w2 = queue.dequeue();
                    System.out.println("Consumed: ");
                    w2.print();
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        producer.start();
        consumer.start();
        producer.join();
        consumer.join();
        System.out.println("done *****************************************************************");

        Thread newProd = new Thread(
                ()->{
                    try {
                        Thread.sleep(1000);
                    }catch(Exception e){}
                    for(int i=0; i< 10; i++) {
                        System.out.println("test thread");
                    }

                }
        );
        newProd.start();

    }
}

class TestWorker implements Runnable {
    private final String name;
    private final String address;

    public TestWorker(String name, String address){
        this.name = name;
        this.address = address;
    }

    public void print(){
        System.out.println("name and address: " + name + " - " + address);
    }

    @Override
    public void run() {
        print();
    }
}
