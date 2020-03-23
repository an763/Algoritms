// Sliding Window Problem
public class LgstSubarrySum {
	
	
	public static int [] findLgstSubArry(int [] input, int target) {
		 int sum = 0;
		 int right = 0;
		 int left = 0;		
		 int[] arr = new int[] {-1};
		
		while(right <input.length) {
			sum += input[right];
			while(left<right && sum>target) {
				sum -= input[left++];
			}
			
			if(sum == target) {
				if(arr.length == 1 || (arr[1] - arr[0] < right - left))
				arr = new int[] {left+1,right+1};
			}
			right++;
		}
		
		return arr;
	}
	
	
	public static void main(String args[]) {
		int[] arr = {1,2,3,4,5,0,0,0,6,7,8,9,10};
		int[] res =findLgstSubArry(arr,15);
		if(res.length == 1) {
			System.out.println("No Arry is found");
		}else {
			System.out.println("The arr is ::: "+res[1] +"," +res[0]);
		}
				
		
	}

}
