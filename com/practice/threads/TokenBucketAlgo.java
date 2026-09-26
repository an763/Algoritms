package com.practice.threads;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class TokenBucketAlgo {

    private int maxTokens = 0;
    private int refillRate = 0;
    private boolean running = true;
    private BlockingQueue<Integer> tokenStore;

    public TokenBucketAlgo(int maxTokens, int refillRate){
        tokenStore = new LinkedBlockingQueue<>(maxTokens);
        this.refillRate = refillRate;
        this.maxTokens = maxTokens;
        createTokeFiller();
    }

    public boolean consumeToken(){
        if(running) {
            if (!tokenStore.isEmpty()) {
                tokenStore.poll();
                return true;
            }
        }else{
            throw new IllegalStateException("Application is not running");
        }
        return false;
    }

    public void shutDown(){
        running = false;
    }

   private void createTokeFiller() {
       Runnable filler = new Runnable() {
           long pauseTime = 1000 / refillRate;
           @Override
           public void run() {
               while (running) {
                   tokenStore.offer(1);
                   try {
                       Thread.sleep(pauseTime);
                   } catch (InterruptedException e) {
                       break;
                   }
               }
           }
       };
       Thread tokenFiller = new Thread(filler);
       tokenFiller.setDaemon(true);
       tokenFiller.start();
   }
}
