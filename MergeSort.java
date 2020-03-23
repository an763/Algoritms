import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class MergeSort {

	// Divide and Conquer strategy!
	// Divide the list into single elements..its sorted automatically
	// start merging the sorted list
	// 
	
	public static void main(String args[]) {
		int[] lst = {5,4,3,2,4,1,-1};
		mergesort(lst);
		for(int i=0; i< lst.length; i++) {
			System.out.println("The elem is :: "+lst[i]);
		}
	}
public List<Integer> sortArray(int[] nums) {
	mergesort(nums);
	List<Integer> lst = Arrays.stream(nums)
							  .boxed().collect(Collectors.toList());
	return lst;
    }
	
	 static void mergesort(int[] arr){
	        if(arr.length == 1) return;
	        int mid = (arr.length)/2;
	        int[] left = new int[mid];
	        for(int i=0; i<mid;i++){
	            left[i] = arr[i];
	        }
	        int[] right = new int[arr.length-mid];
	        for(int i=mid; i<arr.length;i++){
	            right[i-mid] = arr[i];
	        }
	        mergesort(left);
	        mergesort(right);
	        merge(arr,left,right);        
	    }
	    
	    static void merge(int[] arr, int[] left, int[] right){
	        int i = 0;
	        int j = 0;
	        int k =0;
	        while(i<left.length && j< right.length){
	            if(left[i] < right[j]){
	                arr[k++] =left[i++];
	            }else{
	                arr[k++] = right[j++];
	            }
	        }
	        if(i<j){
	            while(i<left.length){
	                arr[k++] =left[i++];
	            }
	        }else{
	             while(j<right.length){
	                arr[k++] =right[j++];
	            }
	        }
	    }
			/*
	public static void mergeSort(int [] unsorted) {		
		if(unsorted.length < 2) return;		
		int mid = (unsorted.length)/2;
		
		// copy the two halves into separate arrays!
		int [] left = new int[mid];
		int [] right = new int[unsorted.length-mid];
		
		for(int i=0; i<mid;i++) {
			left[i] = unsorted[i];
		}
		for(int i=mid; i<unsorted.length;i++) {
			right[i-mid] = unsorted[i];
		}
		mergeSort(left);
		mergeSort(right);
		merge(unsorted,left,right);
	}
	
	public static int[] merge(int[] sorted, int [] iList , int [] jList) {
		int i = 0; int j =0; int k=0;
		
		while(i< iList.length && j<jList.length) {
			if(iList[i] < jList[j]) {
				sorted[k] = iList[i];
				i++;k++;
			}else {
				sorted[k] = jList[j];
				j++;k++;
			}
		}
		
		if(i<iList.length) {
			for(int r=i; r<iList.length; r++) {
				sorted[k++] = iList[r];
			}
		}
		if(j<jList.length) {
			for(int r=j; r<jList.length; r++) {
				sorted[k++] = jList[r];
			}
		}
		
		return sorted;
	}
	*/
}
