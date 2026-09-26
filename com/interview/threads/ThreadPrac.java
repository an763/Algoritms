package com.interview.threads;

public class ThreadPrac {

    public static void task(){
        System.out.println("This s a therad prac "+Thread.currentThread());
    }

    public static void main(String args[]) throws Exception{
        Runnable r = ()-> task();
        Thread vt1 = Thread.ofVirtual().unstarted(r);
        vt1.start();
        vt1.join();
    }
}
