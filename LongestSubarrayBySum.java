
public class LongestSubarrayBySum {
	public static int[] getLongestArr(int [] num, int target) {		
			int left=0;
			int right=0;
			int sum=0;
			int[] returnArr = new int[] {-1};
			
			while(left <= right && right<num.length) {			
				sum = sum + num[right];
				while(left<right && sum > target) {
					sum = sum - num[left++];
				}				
				if(sum==target && (returnArr.length ==1 || returnArr[1]-returnArr[0] < right-left)) {
					returnArr = new int[] {left+1,right+1};
				}			
				
				right++;
		}
		return returnArr;
	}
	
	public static void main(String args[]) {
		int [] inputArr = {4,2,3,4,5,0,0,0,6,7,8,9,10};
		int [] returnArr = getLongestArr(inputArr, 15);
		System.out.println("The returned Arr :: "+returnArr[0] +"   "+ returnArr[1]);
	}
}
