package com.practice.threads;

public class BasicThreadExample {

    /*
    Problem 1: Basic Thread Creation
Create a program that spawns 5 threads.
Each thread should print its thread ID and a
message "Hello from Thread X" where X is the thread number (0-4).
 Use both approaches: extending Thread class and implementing Runnable interface.
     */
    public static void main(String args[]){
        for(int i = 0; i<5; i++){
            SimpleThread thread = new SimpleThread(""+i);
            thread.setCounter(i);
            thread.start();
        }

        for(int i = 0; i<5; i++){
            RunnableThread runnableThread = new RunnableThread(""+i);
            runnableThread.setCounter(i);
            Thread thread = new Thread(runnableThread);
            thread.start();
        }

        for(int i=0; i<5; i++){
            final int threadNum = i;
            Thread thread = new Thread(() -> {
                System.out.println("Hello from lambda Thread "+threadNum+ " ID "+Thread.currentThread().getId()) ;
            });
            thread.start();
        }
    }

}

class SimpleThread extends Thread
{
    public SimpleThread(String name){
        super(name);
    }
    private int counter ;
    public void setCounter(int i){
        counter = i;
    }

    @Override
    public void run(){
        System.out.println("Hello from Thread "+Thread.currentThread().getName() + " ID "+Thread.currentThread().getId());
    }
}

class RunnableThread implements Runnable
{
    private String name;
    public RunnableThread(String name){
        this.name = name;
    }
    private int counter ;
    public void setCounter(int i){
        counter = i;
    }

    @Override
    public void run(){
        System.out.println("Hello from "+Thread.currentThread().getName() + " ID "+Thread.currentThread().getId());
    }
}
