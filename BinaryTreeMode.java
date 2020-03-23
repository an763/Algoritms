import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BinaryTreeMode {
	 public int[] findMode(TreeNode root) {
	        Map<Integer, Integer> map = new HashMap<>();
	        helper(root,map);
	        List<Integer> temp = new ArrayList<Integer>();
	        int max = Integer.MIN_VALUE;
	        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
	            if(max < entry.getValue()){
	                temp.clear();
	                temp.add(entry.getKey());
	                max= entry.getValue();
	            }else if(max == entry.getValue()){
	                 temp.add(entry.getKey());
	            }         
	        }
	        int[] arr = new int[temp.size()];
	        for(int i=0; i<arr.length; i++){
	            arr[i] = temp.get(i);
	        }
	        return arr;
	    }
	    
	    void helper(TreeNode root, Map<Integer,Integer> map){
	    	List<Integer> minDepth = new ArrayList<>();
	    	
	        if(root==null) return;
	        if(map.containsKey(root.val)){
	            int value = map.get(root.val);
	            map.put(root.val,++value);
	        }else{
	             map.put(root.val,1);           
	        }
	        helper(root.left,map);
	        helper(root.right,map);
	    }   
}
