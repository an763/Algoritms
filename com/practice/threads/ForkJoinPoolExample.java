package com.practice.threads;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ForkJoinPoolExample {
        public static void main(String args[]){
            long data[] = new long[2500];
            for(int i = 0; i< 2500; i++){
                data[i] = i;
            }

            FindSum sum = new FindSum(data, 0, 2500);
            ForkJoinPool fj = new ForkJoinPool();
            long result = fj.invoke(sum);

            System.out.println("The sum is "+result);
        }
}



class FindSum extends RecursiveTask<Long>{

    int start = 0;
    int end = 0;
    long [] data = null;

    public FindSum(long [] data, int start, int end){
        this.start = start;
        this.end = end;
        this.data = data;
    }

    @Override
    protected Long compute() {

        int mid = start + (end - start)/2;
        long sum = 0;
        if(end - start < 1000){
            for(int i = start; i < end; i++){
                sum += data[i];
            }
            return sum;
        }

        FindSum leftsum = new FindSum(data,start, mid);
        FindSum rightsum = new FindSum(data, mid,end);

        leftsum.fork();
        long rightResult = rightsum.compute();
        long leftResult = leftsum.join();

        return  rightResult + leftResult;
    }


}
