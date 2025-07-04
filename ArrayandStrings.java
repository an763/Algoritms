import java.util.ArrayList;
import java.util.List;


public class ArrayandStrings {
	
	public static void main1(String args[]) {		
		int a[] = {1, 2, 3, 5, 6};
		
		int[] res = twoPointersTargetSum(a,6);
		
		for (int i = 0; i < res.length; i++) {
			System.out.println(res[i]);
		}
		
		long x  = reverse(12);
		System.out.println(x);
		
	}

	public static void main(String args[]) {
		/*
		 * int a[] = {1,0,4,5,8,7,9,0,10,0,0}; moveZerosTOEnd(a); for(int i = 0;
		 * i<a.length; i++) { System.out.println(a[i]); }
		 */
		int b[] = { -6, -5, -2, 0, 1, 3, 4 }; // {36,25,4,0,1,9,16}
		int c[] = new int[b.length];
		returnSortedSquaredArray(b, c);
		for (int i = 0; i < c.length; i++) {
			System.out.println(c[i]);
		}
		System.out.println("******************");
		int[] arr = {20,13,6,4,7,8,12};
		int[] result = twoSumNoSpaceOverhead(arr,2);
		for(int i=0; i<result.length; i++) {
			System.out.println(result[i]);
		}
		
		
	/*	int[] arr = {1,3,5,2,6,4,7,8,9};
		int[] find = findSubArray(arr);
		for(int i=0; i<find.length; i++) {
			System.out.println(find[i]);
		}
		
		
		
		int [] arr = {1,3,0,2,0,2,7,0,9};
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i] +" , ");

		}
		System.out.println("");
		*/
/*		moveZerosToEnd(arr);
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i] +" , ");

		}
		System.out.println("");*/
		
//		int [] arrNew = {1,3,0,2,0,2,7,0,9};
/*		moveZerosToEndNew(arrNew);
		for(int i=0; i<arrNew.length; i++) {
			System.out.print(arrNew[i] +" , ");

		}
		System.out.println("");*/
	/*	moveZerosToEnd(arr);
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i] +" , ");
		}*/
		
	/*	dutchNationalFlag(arr,2);
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i] +" , ");
		}
		System.out.println("");
		
		dutchNationalFlagNew(arrNew,2);
		for(int i=0; i<arrNew.length; i++) {
			System.out.print(arrNew[i] +" , ");
		}
		System.out.println("");
	/*	
		// Kadane's Algo
		int [] k = {-2,1,-3,4,-1,2,1,-5,4};
		int maxSum  = maxSubArray(k);
		System.out.print("The max sum :: "+maxSum);
		
		List<Integer> list = new ArrayList<>();
		list.add(0);
		list.add(0);
		list.add(1);
		list.add(1);
		list.add(1);
		list.add(2);
		list.add(2);
		removeDuplicates(list);
		*/
	/*	System.out.println("************************************");
		int[] arrSum = {1,2,6,7,15};
		int[] result = findSubArraySum(arrSum,23);
		for(int i=0; i<result.length; i++) {
			System.out.print(result[i] +" , ");
		}
		System.out.println("************************************");
		
		String palidrome1 = "Do geese see God";
		String palindrome2 = "Was it a car or a cat I saw?";
		String palindrome3 = "A brown fox jumping over";
		System.out.print(palidrome1+" is palindrome "+ isPalindrome(palidrome1));
		System.out.print(palindrome2+" is palindrome "+ isPalindrome(palindrome2));
		System.out.print(palindrome3+" is palindrome "+ isPalindrome(palindrome3));
		*/
		
	}

	// 1
	public static void moveZerosTOEnd(int[] a) {
		int tracker = 0;
		for (int i = 0; i < a.length; i++) {
			if (a[i] != 0) {
				a[tracker] = a[i];
				tracker++;
			}
		}
		for (int j = tracker; j < a.length; j++) {
			a[j] = 0;
		}
	}
	
	//2
	public static String reverseSentence(String sentence) {
		System.out.println(sentence);
		System.out.println("Length in reverseSentence :" + sentence.length());
		StringBuilder builder = new StringBuilder();
		int endIndex = sentence.length();
		for (int i = sentence.length() - 1; i > 0; i--) {
			if (sentence.charAt(i) == ' ') {
				builder.append(sentence.substring(i + 1, endIndex));
				endIndex = i;
				builder.append(' ');
			}
		}

		builder.append(sentence.substring(0, endIndex));
		return builder.toString();
	}

	//3 Two Sum - Sorted Array
	public static void findIndices(int a[], int sum) {
		int i = 0;
		int j = a.length - 1;
		while (i < j) {
			if (a[i] + a[j] == sum) {
				System.out.println("The indices for sum " + sum + " are :: " + i + " and " + j);
				break;
			} else if (a[i] + a[j] < sum) {
				i++;
			} else {
				j--;
			}
		}
		if (i == j || i > j) {
			System.out.println("No elements found with sum " + sum);
		}
	}

	//4 return an array of squares of each number, in increasing order
	// -4,-3,-1, 2 ==> 16, 9 , 1, 4 ==> 4,9,1,16 => 1,9,4,16 =>
	public static void returnSortedSquaredArray(int a[], int b[]) {

		for (int i = 0; i < a.length; i++) {
			a[i] = a[i] * a[i];
		}

		int start = 0;
		int end = a.length - 1;
		int resultIndex = a.length - 1;
		while (start <= end) {
			if (a[start] > a[end]) {
				b[resultIndex] = a[start];
				start++;
			} else {
				b[resultIndex] = a[end];
				end--;
			}
			resultIndex--;
		}
	}
	
	public static void returnSortedSquaredArrayDifferent(int a[]) {

		for (int i = 0; i < a.length; i++) {
			a[i] = a[i] * a[i];
		}

		int start = 0;
		int end = a.length - 1;
		while (start <= end) {
			if (a[start] > a[end]) {
				swap(a,start,end);
				
			} else {
				end--;
			}
		}
	}

	public static void swap(int a[], int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	// 5 merge Strings
	 public static String mergeAlternately(String word1, String word2) {
		 int length1 = 0;
		 int length2 = 0;
		 StringBuilder merged = new StringBuilder();
	        while(length1 < word1.length() || length2 < word2.length()) {
	        	merged = merged.append(word1.charAt(length1)).append(word2.charAt(length2));
	        	length1++;
	        	length2++;
	        }
	        
	        if(word1.length() != word2.length()) {
		        if(length1 == word1.length()) {
		        	merged.append(word2, length2, word2.length());
		        }else {
		        	merged.append(word1, length1, word1.length());
		        }
	        }
	        return merged.toString();
	    }
	 
	 //6 find subarray
	 public static int[] findSubArray(int a[]) {
		 // find the first dip from start
		 int firstDip = 0;
		 for(int i=0; i<a.length-1; i++) {
			 if(a[i] > a[i+1]) {
				 firstDip = i;
				 break;
			 }
		 }
		 
		 // find firstBump
		 int firstBump = 0;		 
		 for(int i=a.length-1; i> 0; i--) {
			 if(a[i-1] > a[i]) {
				 firstBump = i;
				 break;
			 }
		 }
		 
		 // find max amd min in the subarray  [firstDip, firstBump] 
		 int min = a[firstDip];
		 for(int j=firstDip; j<=firstBump; j++) {
			 if(min < a[j]) {
				 min = a[j];
			 }
		 }
		 int subArrayStart =firstDip;
		 // find from 0 to firstDib index, any number bigger than min
		 for(int i=0; i<firstDip; i++) {
			 if(min > a[i]) {
				 subArrayStart = i;
			 }
		 }
		 
		 // find max now
		 int max = a[firstBump];
		 for(int j=firstDip; j<=firstBump; j++) {
			 if(max < a[j]) {
				 max = a[j];
			 }
		 }		 
		 int subArrayEnd =firstBump;
		 // find from firstBump to a.length index, any number lesser than max
		 for(int i=firstBump; i<firstDip; i++) {
			 if(max > a[i]) {
				 subArrayEnd = i;
			 }
		 }
		 int [] indices = {subArrayStart, subArrayEnd};
		 return indices;	 
	 }
	 
	 // move zeros to begining
	 
	 public static void moveZerosToBegining(int arr[]) {
		 int boundary = -1;
		 for(int i= 0; i<arr.length; i++) {
			 if(arr[i] ==0) {
				 boundary++;
				 swap(arr,i,boundary);
			 }
		 }
	 }
	 
	 public static void moveZerosToEnd(int arr[]) {
		 int boundary = arr.length;
		 for(int i= arr.length-1; i>=0; i--) {
			 if(arr[i] ==0) {
				 boundary--;
				 swap(arr,i,boundary);
			 }
		 }
	 }
	 
	 public static void moveZerosToEndNew(int arr[]) {
		 int boundary = -1;
		 for(int i= 0; i<arr.length; i++) {
			 if(arr[i] !=0) {
				 boundary++;
				 swap(arr,i,boundary);
			 }
		 }
	 }
	 
	 public static void dutchNationalFlagNew(int arr[], int pivot) {
		 int boundary_start = -1;
		 int boundary_end = arr.length;
		 int i = 0;
		 while(i<boundary_end) {
			 if(arr[i] < pivot) {
				 boundary_start++;
				 swap(arr,i,boundary_start);
				 i++;
			 }else if(arr[i] > pivot) {
				 boundary_end--;
				 swap(arr,i,boundary_end);
			 }else {
				 i++;
			 }
		 }
		}
	 
	 
	 public static int [] twoSumNoSpaceOverhead(int a[], int target) {
		 int start =0;
		 int end = a.length-1;
		 
		 while(start < a.length-1) {
			 if(start == end) {
				 start++;
				 end= a.length-1;
			 }
			 
			 if(target - a[start] > a[end]) {
				 start++;
				 end = a.length-1;
			 }else if(target - a[start] < a[end]) {
				  end--;
			 }else {
				 return new int[] {start, end};
			 }			 
			
		 }
		 return new int[] {-1,-1};
	 }
	 
	 
	 
	 public static List<Integer> twoSumNoSpaceOverhead(List<Integer> arr, int target) {
		 int start =0;
		 int end = arr.size()-1;
		 
		 while(start < arr.size()-1) {
			 if(start == end) {
				 start++;
				 end= arr.size()-1;
			 }			 
			 if((target - arr.get(start)) > arr.get(end)) {
				 start++;
				 end = arr.size()-1;
			 }else if((target - arr.get(start)) < arr.get(end)) {
				  end--;
			 }else {
				 List<Integer> list = new ArrayList<>();
				 list.add(start);
				 list.add(end);
				 return list;
			 }			 
			
		 }
		 return new ArrayList<>();
	 }
	 
	 public static boolean isPalindrome(String s) {	
		 s = s.replaceAll("[^a-zA-Z0-9]", "");
		 String lowerCase = s.toLowerCase();
		 int start =0;
		 int end = lowerCase.length()-1;
		 while(start <= end) {
			 char a = lowerCase.charAt(start);
			 char b = lowerCase.charAt(end);
			 if(a != b) {
				 return false;
			 }
			 start++;
			 end--;
		 }
		 return true;
	 }
	 
	 
	  // dutch national flag
	 public static void dutchNationalFlag(int a[], int pivot) {
		 int low_boundary = -1;
		 int high_boundary = a.length;
		 int i = 0;
		 while(i< high_boundary ) {
			 if(a[i] < pivot) {
				 low_boundary++;
				 swap(a,low_boundary,i);
				 i++;
			 }
			 else  if(a[i] > pivot) {
				 high_boundary--;				
				 swap(a,high_boundary,i);
			 }else {
				 i++;
			 }
			 
		 
		 }
	 }
	 
	 public static int maxSubArray(int[] nums) {
		        int result = nums[0];
		        int maxTillNow = nums[0];
		        for(int i=1; i< nums.length; i++){
		        	maxTillNow = Math.max(nums[i], maxTillNow + nums[i]);
		            result = Math.max(result, maxTillNow);
		        }
		        return result;
	    }
	 
	 
	 public static int removeDuplicates(List<Integer> arr) {
	        int start = 0; int end = 0; 
	        while(start < arr.size() && end < arr.size() )
	        {
	            if(arr.get(start) == arr.get(end)){
	                if(start == end){
	                    end++;
	                }else{
	                    arr.remove(end);
	                }
	            }else{
	                start++;
	            }
	        }
	        System.out.print("The size is ::"+arr.size());
	        return arr.size();
	    }
	 
	 
	 public static int[] twoPointersTargetSum(int[] arr, int target) {
		    
		    int i = 0;
		    int j= arr.length-1;
		    while(i<j){
		      if(arr[i] + arr[j] > target){
		        j--;
		      }else if(arr[i] + arr[j] < target){
		        i++;
		      }else{		        
		        return new int[] {i,j};
		      }
		    }
		    return new int[] { -1, -1 };
		  }
	 
	 
	 public String longestPalindrome(String s) {
	        if(s==null || s.trim().length() ==0) return "";
	        String palindrome = "";
	        int length = 0;

	        for(int i=0; i<s.length();i++){
	            int l=i;
	            int r = i;
	            while(l >=0 && r <= s.length()-1 && s.charAt(l) == s.charAt(r)){
	                if(length < r-l+1){
	                    length = r-l+1;
	                    palindrome = s.substring(l,r+1);
	                }
	                l=l-1;
	                r=r+1;
	            }

	             l=i;
	             r = i+1;
	            while(l >=0 && r <= s.length()-1 && s.charAt(l) == s.charAt(r)){
	                if(length < r-l+1){
	                    length = r-l+1;
	                    palindrome = s.substring(l,r+1);
	                }
	                l=l-1;
	                r=r+1;
	            }
	        }
	        return palindrome;
	    }
	 
	 
	 
	 public static long reverse(int x){
		 long result = 0;
		 long xRemaining = Math.abs(x);
		 while (xRemaining != 0) {
		 result = result * 10 + xRemaining % 10;
		 xRemaining /= 10;
		 }
		 return x<0 ? -result:result;
	 }
	 
	 public static int[] findSubArraySum(int [] a, int target) {
		 
		 int start = 0;
		 int end = 0;
		 int current = a[0];
		 
		 while(start < a.length) {
			 	if(start > end) {
			 		end = start;
			 		current = a[start];
			 	}
			 
			 if(current < target) {
				 if(end == a.length-1) break;
				 end++;
				 current = current + a[end];
			 }else if(current > target) {
				 current = current -a[start];
				 start++;				  
			 }else {
				 return new int [] {start, end};
			 }
			 
		 }
		 
		 
		 
		 return new int[]{-1,-1};
	 }
		 
	 
	

	 
	
	

}
