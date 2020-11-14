import java.util.UUID;

public class BinarySearch {
	
	public static void main(String args[]) {
		
		 UUID uuid = UUID.randomUUID();
		 System.out.println("uuid.toString() ===>>> "+ uuid.toString());
		 uuid = UUID.randomUUID();
		 System.out.println("uuid.toString() ===>>> "+ uuid.toString());
		int [] sortedArr = {1,2,3,4,5,6,7,8,9,10};
		
		int quo = searchNumber(sortedArr, 0, 9, 6);
		System.out.println("The number  is present at :: "+quo);		
		quo = searchNumber(sortedArr, 0, 9, 0);
		System.out.println("The number  is present at :: "+quo);		
		quo = searchNumber(sortedArr, 0, 9, 1);
		System.out.println("The number  is present at :: "+quo);
		quo = searchNumber(sortedArr, 0, 9, 10);
		System.out.println("The number  is present at :: "+quo);
		
		
		quo = searchNumberItr(sortedArr, 0, 9, 6);
		System.out.println("The searchNumberItr  is present at :: "+quo);		
		quo = searchNumberItr(sortedArr, 0, 9, 0);
		System.out.println("The searchNumberItr  is present at :: "+quo);		
		quo = searchNumberItr(sortedArr, 0, 9, 1);
		System.out.println("The searchNumberItr  is present at :: "+quo);
		quo = searchNumberItr(sortedArr, 0, 9, 10);
		System.out.println("The searchNumberItr  is present at :: "+quo);
	}
	
	
	public static int searchNumber(int sortedArr[], int low, int high, int target){
		if(low > high) return -1;
		int mid = ((low+high)/2);
		if(sortedArr[mid] == target) {
			return mid;
		}else if(sortedArr[mid] > target) {			
			high = mid -1;
			return searchNumber(sortedArr,low,high,target);
		}else if(sortedArr[mid] < target) {
			low = mid +1;
			return searchNumber(sortedArr,low,high,target);
		}			
		return -1;
	}
	
	public static int searchNumberItr(int sortedArr[], int low, int high, int target){
		if(low > high) return -1;
		int mid = 0;
		
		while(low <= high) {
			mid = ((low+high)/2);
			if(sortedArr[mid] == target) {
				return mid;
			}else if(sortedArr[mid] > target) {
				high = mid-1;
			}else {
				low = mid +1;
			}			
		}
			
		return -1;
	}
	
	

}
