
public class MaxSumSubArr {
	
	
	public static int maxSum(int nums[]) {
		int max_sum = nums[0];
		int current_sum = max_sum;
		
		for(int i=0; i<nums.length; i++) {
			current_sum = Math.max(nums[i] + current_sum, nums[i]);
			max_sum = Math.max(max_sum, current_sum);
		}
		return max_sum;
	}
	
	public static void main(String args[]) {
		int [] test = {-2,2,5,-11,6};
		System.out.println("The max subarray sum :: "+maxSum(test));
	}
	

}
