
public class QuickSort {
	
	
	
	public static void main(String args[]) {
		int [] unsortedArr = {6,5,4,3,2,1};
		QuickSort q = new QuickSort();
		q.quickSort(unsortedArr, 0, unsortedArr.length-1);		
		for(int i=0; i<unsortedArr.length; i++) {
			System.out.println("The elem is ::"+unsortedArr[i]);
		}
	}
	
		
	public void quickSort(int [] arr, int low, int high) {	
		if(low<high) {
			//int partInd = findPivotPosition(arr,low,high);
			int partInd = ascendMethod(arr,low,high);
			quickSort(arr,low,partInd-1);
			quickSort(arr,partInd+1,high);
		}
	}
	
	
	
	public int findPivotPosition(int[] arr,int begin, int end) {
		int pivot = arr[end];
		int i=begin-1;
		for (int j = begin; j < end; j++) {
	        if (arr[j] <= pivot) {
	            i++;	 
	            int swapTemp = arr[i];
	            arr[i] = arr[j];
	            arr[j] = swapTemp;
	        }
	    }
	 
	    int swapTemp = arr[i+1];
	    arr[i+1] = arr[end];
	    arr[end] = swapTemp;
	 
	    return i+1;
	}
	
	public int ascendMethod(int[] arr,int begin, int end) {
		int pivot = arr[begin];
		int i= begin;
		int j= end;
		
		while(i<j) {
			while(i < end && arr[i] <= pivot) {
				i++;
			}			
			while(j > begin && arr[j] >= pivot) {
				j--;
			}
			
			if(i<j) {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
		
		arr[begin] = arr[j];
		arr[j] = pivot;
		
		return j;
	}
	
	public int descendMethod(int[] arr,int begin, int end) {
		int pivot = arr[begin];
		int i= begin;
		int j= end;
		
		while(i<j) {
			while(i < end && arr[i] >= pivot) {
				i++;
			}			
			while(j > begin && arr[j] <= pivot) {
				j--;
			}
			
			if(i<j) {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
		
		arr[begin] = arr[j];
		arr[j] = pivot;
		
		return j;
	}
	
	
	
	
	
	

}
