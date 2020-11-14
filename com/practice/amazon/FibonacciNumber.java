package com.practice.amazon;
import java.util.HashMap;
import java.util.Map;

public class FibonacciNumber {
	
	static Map<Integer, Integer> cache = new HashMap<>();
	
	public static void main(String args[]) {
		
		System.out.println("The value of Fib 3 :: "+fib(3));
		System.out.println("The value of Fib 4 :: "+fib(4));
		System.out.println("The value of Fib 5 :: "+fib(5));
		
		int fibNum=0;
		int fibSum=0;
		int num =1;
		while (fibNum < 4000000) {	
			fibNum = fib(num);
			if(fibNum % 2 ==0) {					
				fibSum = fibSum + fibNum;
			}
			num++;
		}
		System.out.println("The fibsum is "+fibSum);
		
	}
	
	public static int fib(int N) {
		if(cache.containsKey(N)) {
			return cache.get(N);
		}
		if(N < 2) {
			cache.put(N, N);
			return N;
		}else {
			int fibVal = fib(N-1) + fib(N-2);
			cache.put(N, fibVal);
			return fibVal;
		}
	}

}
