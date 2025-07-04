import java.util.ArrayList;
import java.util.List;

public class DynamicSteps {
	
	public static void main(String args[]) {
		int ways = waysToClimb(5);
		System.out.println("The steps are = "+ways);
		
		
		ways = newWaysToClimb(5);
		System.out.println("The new steps are = "+ways);
		
		int arr[] = {1,2,11,12,-3,-2,-8,-7,-6,-5,-10,3,4,5,6,7,8};
		System.out.println("The longest increasing subsequence = "+longestIncreasingSubsequence(arr));
	//	System.out.println("The longest increasing subsequence = "+longestIncreasingSubsequence(arr));
	}

	public static int waysToClimb(int n) {
		int[] a = new int[n + 1];
		a[0] = 1;
		for (int i = 0; i < a.length; i++) {
			if (i + 1 < a.length)
				a[i + 1] += a[i];
			if (i + 3 < a.length)
				a[i + 3] += a[i];
			if (i + 5 < a.length)
				a[i + 5] += a[i];
		}
		return a[n];
	}
	
	public static int newWaysToClimb(int n) {
		
		if(n < 0) return 0;
		if(n==0) return 1;
				
		
		int oneStep = newWaysToClimb(n-1);
		
		int threeSteps = newWaysToClimb(n-3);
		
		int fiveSteps = newWaysToClimb(n-5);
		
		return oneStep + threeSteps + fiveSteps;
		
	}
	
	
	public static int longestIncreasingSubsequence(int[] arr) {
		
		// 1 . Start iterating through array and populate the array
		//2. check if current element is less than last element.
		// if it is , search the place of this element in the existing array and replace it
		// keep repeating this process and return the length of resultant sequence.
		
		List<Integer> holder = new ArrayList<>();
		holder.add(arr[0]);
		for(int i=1; i<arr.length;i++) {
			if(holder.get(holder.size()-1) > arr[i]) {
				replace(holder, arr[i]);
			}else {
				holder.add(arr[i]);
			}
		}
		return holder.size();
	}
	
	public static void replace(List<Integer> holder, int current) {
		int low = 0; int high = holder.size()-1;
		int result = 0;
		while(low <= high) {
			int mid = low + (high-low)/2;			
			if(holder.get(mid) >= current) {	
					result = mid;
					high = mid-1;				
			}else {				
					low = mid+1;				
			}
		}
		holder.set(result, current);
	}
	
	
	 
}
