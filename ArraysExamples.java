import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class ArraysExamples {
	
	
	public int[] topKFrequent(int[] nums, int k) {
		Map<Integer, Integer> map  = new HashMap<>();
        for(int i=0; i < nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) +1);           
        }
        PriorityQueue<Map.Entry<Integer,Integer>> pq = new PriorityQueue<>((a,b) -> a.getValue() - b.getValue());
        for(Map.Entry<Integer,Integer> entrySet : map.entrySet()){
            pq.add(entrySet);
            if(pq.size() > k) pq.poll();
        }
        int [] keys = new int[k];
        int i = 0;
        while(!pq.isEmpty()){
            keys[i++] = pq.poll().getKey();
        }
        return keys;       
    }
	
	 public boolean containsDuplicate(int[] nums) {
	        Set<Integer> unique = new HashSet<>();
	        for(int i=0; i< nums.length; i++){
	            if(unique.contains(nums[i])){
	                return true;
	            }
	            unique.add(nums[i]);
	        }
	        return false;
	    }
	 
	 public boolean isAnagram(String s, String t) {
	        if(s.length() != t.length()) return false;

	        int [] freq = new int [26];

	        for(int i= 0 ; i< s.length(); i++){
	            freq[s.charAt(i) - 'a']++;
	            freq[t.charAt(i) - 'a']--;
	        }

	        for(int i=0; i< freq.length; i++){
	            if(freq[i] != 0) return false;
	        }
	        return true;
	    }
	 
	 public int[] twoSum(int[] nums, int target) {
	        Map<Integer, Integer> store = new HashMap<>();
	        for(int i =0; i< nums.length; i++){
	            if(store.get(target - nums[i]) != null){
	                return new int[]{store.get(target - nums[i]) , i};
	            }else{
	                store.put(nums[i], i);
	            }
	        }
	        return new int []{-1,-1};
	    }
	 
	 public List<List<String>> groupAnagrams(String[] strs) {
	        Map<String, List<String>> anagramMap = new HashMap<>();
	        List<List<String>> group = new ArrayList<>();
	        for(String current : strs){
	            char[] charArray = current.toCharArray();
	            Arrays.sort(charArray);
	            String sorted = String.valueOf(charArray);
	            if(!anagramMap.containsKey(sorted)){
	                anagramMap.put(sorted, new ArrayList<>());
	            }
	            anagramMap.get(sorted).add(current);
	        }
	        group.addAll(anagramMap.values());
	        return group;
	    }
	 
	 public int[] productExceptSelf(int[] nums) {
	        int [] pre = new int[nums.length];
	        int [] suf = new int[nums.length];

	        pre[0] = 1;
	        suf[nums.length-1] = 1;

	        for(int i=1; i< nums.length; i++){
	            pre[i] = pre[i-1] * nums[i-1];
	        }

	        for(int j=nums.length-2; j>=0; j--){
	            suf[j] = suf[j+1] * nums[j+1];
	        }

	        int[] ans = new int[nums.length];

	        for(int i=0; i<nums.length; i++){
	            ans[i] = pre[i] * suf[i];
	        }
	        return ans;
	    }
	 
	 public static void main(String args[]) {
		 int [] arr = {100,4,200,1,3,2};
		 int res = longestConsecutive(arr);
		 System.out.println("The res :"+res);
	 }
	 
	 public static int longestConsecutive(int[] nums) {
	        Set<Integer> unique = new HashSet<>();
	        int longest_seq = 0;
	        for(int i=0; i<nums.length; i++){
	            if(!unique.contains(nums[i])){
	                if(unique.contains(nums[i] +1)){
	                    longest_seq++;
	                }
	                if(unique.contains(nums[i] -1)){
	                    longest_seq++;
	                }
	                unique.add(nums[i]);
	            }
	        }
	        longest_seq++;
	        return longest_seq;
	    }

}
