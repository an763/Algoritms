

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class SlidingWindowSum {
	
	
	public static void main(String args[]) throws Exception {
	/*	int[] arr = {1,2,3,4,5,6}; // (6,9,12,15);
		List<Integer> result = findSlidingWindowSum(arr,3);
		System.out.println("The elements are");
		for(int i=0; i<result.size(); i++){
			System.out.print(result.get(i) +",");
		}
		*/
		int [] arrStack = {6,2,8,3,9,5,1};
		populateStack(arrStack);
		System.out.println("The stack is ");
		for(int i=arrStack.length-1; i>=0; i--){			
			System.out.print(arrStack[i] +",");
		}
		
		System.out.println("Max in Queue now ==> "+ getMaxFromQueue());
		pollQueue();
		System.out.println("Max in Queue now ==> "+ getMaxFromQueue());
		pollQueue();
		System.out.println("Max in Queue now ==> "+ getMaxFromQueue());
		pollQueue();
		System.out.println("Max in Queue now ==> "+ getMaxFromQueue());
		pollQueue();
		System.out.println("Max in Queue now ==> "+ getMaxFromQueue());
		pollQueue();
		System.out.println("Max in Queue now ==> "+ getMaxFromQueue());
	
		
	}
	
	public static List<Integer> findSlidingWindowSum(int[] list, int size){		
		Queue<Integer> runningWindow = new java.util.LinkedList<>();
		int runningSum = 0;
		List<Integer> sumList = new ArrayList<>();
		
		for(int i=0; i<list.length; i++) {
			if(runningWindow.size() == size) {
				sumList.add(runningSum);
				runningSum = runningSum - runningWindow.remove();
			}
			runningWindow.add(list[i]);
			runningSum += list[i];
		}
		
		sumList.add(runningSum);		
		return sumList;
		
	}
	
	private static Stack<Integer> stackWithMaxInOrder = new java.util.Stack<>();
	private static Stack<Integer> simpleStack = new java.util.Stack<>();
	public static void populateStack(int arr[]) {
			for(int i=0; i<arr.length; i++) {
				addToQueue(arr[i]);
			}
	}
	
	public static void addToQueue(int num) {	
		
		if(stackWithMaxInOrder.isEmpty() || stackWithMaxInOrder.peek() <= num) {
			stackWithMaxInOrder.add(num);			
		}
		simpleStack.add(num);
	}
	
	public static int pollQueue() throws Exception{
		if(simpleStack.isEmpty()) throw new Exception();
		int pollNum = simpleStack.pop();
		if(pollNum == stackWithMaxInOrder.peek()) {
			stackWithMaxInOrder.pop();
		}
		return pollNum ;		
	}
	
	public static int getMaxFromQueue(){
		return stackWithMaxInOrder.peek();
	}
	
	
	
	

}
