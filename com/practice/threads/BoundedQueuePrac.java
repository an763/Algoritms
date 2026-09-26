package com.practice.threads;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class BoundedQueuePrac<T> {

    private T[] obj = null;
    private int head, tail, capacity, count = 0;

    private ReentrantLock myLock = null;
    private Condition enqueueCond = null;
    private Condition dequeueCond = null;


    public BoundedQueuePrac(int cap) {
        capacity = cap;
        obj = (T[]) new Object[cap];
        myLock = new ReentrantLock();
        enqueueCond = myLock.newCondition();
        dequeueCond = myLock.newCondition();
    }

    public void enqueue(T object) {
        myLock.lock();
        try {
            while (count == capacity) {
                enqueueCond.await();
            }
            obj[head] = object;
            head = (head + 1) % capacity;
            count++;
            dequeueCond.signal();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            myLock.unlock();
        }
    }

    public T dequeue() {
        myLock.lock();
        T objRet = null;
        try {
            while (count == 0) {
                dequeueCond.await();
            }
            objRet = obj[tail];
            obj[tail] = null;
            tail = (tail + 1) % capacity;
            enqueueCond.signal();
            count--;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            myLock.unlock();
        }
        return objRet;
    }

    public static void main(String args[]) {
        BoundedQueuePrac<Person> queue = new BoundedQueuePrac<>(5);

        Thread producer = new Thread(() -> {
            int count = 0;
            while (count < 10) {
                queue.enqueue(new Person("misra" + count, 10 + count));
                count++;
            }
        });

        Thread consumer = new Thread(() -> {
            int count = 0;
            while (count < 10) {
                Person person = queue.dequeue();
                System.out.println("Person age " + person.age + " == name " + person.name);
                count++;
            }
        });
        producer.start();
        consumer.start();

        try {
            producer.join();  // Wait for producer to finish enqueuing 10 items
            consumer.join();  // Wait for consumer to finish dequeuing 10 items
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

    }
}

class Person{
    String name;
    int age;
    public Person(String n, int a){
        name = n;
        age =a;
    }
}
