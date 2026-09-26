package com.practice.threads;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class MhyReadWriteLockRT {

    private int readers = 0;
    private int writers = 0;
    private int writeRequest = 0;
    private ReentrantLock lock = new ReentrantLock();
    private Condition canWrite = lock.newCondition();
    private Condition canRead = lock.newCondition();

    public void readLock(){
        lock.lock();
        while (writeRequest > 0 || writers >0){
            try {
                canRead.await();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        lock.unlock();
        readers++;
    }

    public void readUnlock(){
        lock.lock();
        readers--;
        if(readers == 0) canWrite.signal();
        lock.unlock();
    }

    public void writeLock(){
        lock.lock();
        writeRequest++;
        while (readers > 0 || writers > 0){
            try {
                canWrite.await();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        writeRequest--;
        writers++;
        lock.unlock();
    }

    public void writeUnlock(){
        lock.lock();
        writers--;
        if(writeRequest > 0){
            canWrite.signal();
        }else {
            canRead.signalAll();
        }
        lock.unlock();
    }
}
