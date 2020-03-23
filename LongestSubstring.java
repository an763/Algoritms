import java.util.HashMap;
import java.util.Map;

public class LongestSubstring {
	 public static int lengthOfLongestSubstring(String s) {
	        Map<Character, Integer> holder = new HashMap<>();
	        int maxLength =0;
	        int currentLength =0;
	        int currentStart = 0;
	        char[] arr = s.toCharArray();
	        for(int i=0; i<arr.length; i++){
	            if(holder.containsKey(arr[i])){
	                if(currentStart < holder.get(arr[i]) +1)
	                currentStart = holder.get(arr[i]) +1;             
	                if(currentLength > maxLength){
	                    maxLength = currentLength;                   
	                }
	                 holder.put(arr[i],i);
	                 currentLength = i - currentStart+1;
	            }else{
	                holder.put(arr[i],i);
	                currentLength++;
	            }
	        }
	        
	        return Math.max(currentLength,maxLength);
	    }
	 
	 public static void main(String args[]) {
		 int len = lengthOfLongestSubstring("abcabcbb");
		 System.out.println("The length : "+len);
	 }
}
