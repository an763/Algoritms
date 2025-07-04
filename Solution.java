

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> [] list = new List[nums.length];
        for(int i=0; i<list.length; i++){
            list[i] = new ArrayList<>();
        }
        for(int i=0; i<nums.length; i++){
            if(map.get(nums[i]) == null){
                map.put(nums[i],1 );
            }else{
                int c = map.get(nums[i])+1;
                map.put(nums[i],c);
            }
        }    
    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
        int key = entry.getKey();
        int value = entry.getValue(); 
        list[value-1].add(key);    
    }
    int[] ans = new int[k];
    int index = 0;
    for(int i=list.length-1; i>=0; i--){
        if(list[i].size() > 0){ 
        	if(list[i].size() > 1) {
        		for(int j=0; j<list[i].size(); j++) {
        			if(index >= k) break;          
                	ans[index++] = list[i].get(j);
        		}
        	}else {
        		if(index >= k) break;          
            	ans[index++] = list[i].get(0);
        	}

        }
        	
    }
    return ans;
 }
    
    public int[] topKElements(int[] nums, int k) {
    	
    	Map<Integer, Integer> map = new HashMap<>();
    	
    	for(int num : nums) {
    		if(map.containsKey(num)) {
    			map.put(num, map.get(num) +1);
    		}else {
    			map.put(num,1);
    		}
    	}
    	List<Pair> pairList = new ArrayList<>();
    	for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
    		Pair pair = new Pair();
    		pair.setKey(entry.getKey());
    		pair.setValue(entry.getValue());
    		pairList.add(pair);
    	}
    	
    	PriorityQueue<Pair> pq = new PriorityQueue<>(new MyCustomObjectComparator());
    	for(Pair pair : pairList) {
    		
    	}
    	
    	return null;
    }
    
    public static void main(String args[]) {
    	int [] num = {2,2,3,4,5,6,4,4,4,4,6,6,6};
    	int k=5;
    	Solution s = new Solution();
    	int[] ans = s.topKFrequent(num, k);
    	System.out.println("ans ");
    }
    
    public class Pair{
    	private int key;
    	private int value;
    	
    	public int getKey() {
    		return key;
    	}
    	
    	public void setKey(int key) {
    		this.key = key;
    	}
    	
    	public void setValue(int value) {
    		this.value = value;
    	}
    	
    	public int getValue() {
    		return value;
    	}
    	
    	
    }
    
    public class MyCustomObjectComparator implements Comparator<Pair> {
        @Override
        public int compare(Pair o1, Pair o2) {
            return Integer.compare(o1.getValue(), o2.getValue());
        }
    }
}
