
public class SortedSquaredArray {
	
	static int[] getSquaredSortedArray(int [] arr) {
		int N = arr.length;
		int right= N-1;
		int left = 0;
		int[] sortedSq = new int[N];
		int sortedIndex = N-1;
		while(left <=right) {
			if(Math.abs(arr[left]) > Math.abs(arr[right])) {
				sortedSq[sortedIndex] = arr[left] * arr[left];
				left++;
			}else {
				sortedSq[sortedIndex] = arr[right] * arr[right];
				right--;
			}
			sortedIndex--;
			
		}
		
		return sortedSq;
	}
	
	public static void main(String args[]) {
		int [] arr ={-6,-3,-2,1,3,4,5};// {1,2,3,4,5,6};// 
		arr = getSquaredSortedArray(arr);
		System.out.println("The square sorted arr :");
		for(int i=0; i< arr.length; i++)
			System.out.print(arr[i] + " ");
	}

}
