package com.practice.threads;

public class MyReadWriteLock {

    private int writers = 0;
    private int readers = 0;
    private int writeRequests =0;
    Object lock = new Object();

    public void readLock() throws InterruptedException {
        synchronized (lock){
            while(writers > 0 || writeRequests >0){
                    lock.wait();
            }
            readers++;
        }

    }
    public void writeLock() throws InterruptedException {
        synchronized (lock){
        writeRequests++;
            while(writers > 0 || readers > 0 ){
               lock.wait();
            }
            writeRequests--;
            writers++;
        }
    }

    public void readUnLock() throws InterruptedException {
        synchronized (lock){
            readers--;
            lock.notifyAll();
        }
    }

    public void writeUnlock(){
        synchronized (lock){
            writers--;
           lock.notifyAll();
        }
    }





}
