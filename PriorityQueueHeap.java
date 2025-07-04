import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class PriorityQueueHeap {
	
	
	public static void main(String args[]) {
		int [][] arr = {{1,3},{2,6},{8,10},{15,18}};
		
		int [][] merged = merge(arr);
		
		System.out.println("The size is "+merged.length);
		System.out.println("The size is "+merged.toString());
	}

	public int findKthLargest(int[] nums, int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int ele : nums) {
			if (pq.peek() != null) {
				if (pq.size() < k) {
					pq.add(ele);
				} else if (pq.size() == k && pq.peek() < ele) {
					pq.poll();
					pq.add(ele);
				}
			} else {
				pq.add(ele);
			}
		}
		int result = pq.poll();
		return result;
	}
	
	
	public static int[][] merge(int[][] intervals) {
		
		List<String> synchronizedList = Collections.synchronizedList(new ArrayList<>());
		synchronized (synchronizedList) { // Explicit synchronization required for iteration
		    for (String s : synchronizedList) {
		        System.out.println(s);
		    }
		}
		
		 PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] - b[0]);
	        
	        for(int i=0; i<intervals.length ; i++) {
	        	pq.add(intervals[i]);
	        }
	        
	        List<int[]> lst = new ArrayList<>();
	        lst.add(pq.poll());
	        
	        while(!pq.isEmpty()) {
	        	int [] current = pq.poll();
	        	if(lst.get(lst.size()-1)[1] >= current[0]) {              
	        		lst.get(lst.size()-1)[1] = lst.get(lst.size()-1)[1] > current[1] ? lst.get(lst.size()-1)[1] : current[1]; 
	        	}else {
	        		lst.add(current);
	        	}
	        }    
	        return lst.toArray(new int[lst.size()][2]);
    }

}
