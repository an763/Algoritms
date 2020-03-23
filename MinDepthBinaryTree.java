import java.util.ArrayList;
import java.util.List;

class Node2 
{ 
    int data; 
    Node2 left, right; 
    public Node2(int item) 
    { 
        data = item; 
        left = right = null; 
    } 
} 

public class MinDepthBinaryTree {
	
	
	
	 Node2 root; 
	  
	    int minimumDepth() 
	    { 
	        return minimumDepth(root); 
	    } 
	  
	    /* Function to calculate the minimum depth of the tree */
	    int minimumDepth(Node2 root) 
	    { 
	        // Corner case. Should never be hit unless the code is 
	        // called on root = NULL 
	        if (root == null) 
	            return 0; 
	  
	        // Base case : Leaf Node2. This accounts for height = 1. 
	        if (root.left == null && root.right == null) 
	            return 1; 
	  
	        // If left subtree is NULL, recur for right subtree 
	        if (root.left == null) 
	            return minimumDepth(root.right) + 1; 
	  
	        // If right subtree is NULL, recur for left subtree 
	        if (root.right == null) 
	            return minimumDepth(root.left) + 1; 
	  
	        return Math.min(minimumDepth(root.left), 
	                        minimumDepth(root.right)) + 1; 
	    } 
	  
	    /* Driver program to test above functions */
	    public static void main(String args[]) 
	    { 
	    	
	    	int x = -1234;
	    	System.out.println("The division :"+x%10);
	    	MinDepthBinaryTree tree = new MinDepthBinaryTree(); 
	        tree.root = new Node2(1); 
	        tree.root.left = new Node2(2); 
	        tree.root.right = null;
	        tree.root.left.left = null;
	        tree.root.left.right = null;
	       /* tree.root.right = new Node2(3); 
	        tree.root.left.left = new Node2(4); 
	        tree.root.left.right = new Node2(5); */
	  
	        System.out.println("The minimum depth of "+ 
	          "binary tree is : " + tree.minimumDepth()); 
	    } 
	
/*	 public static int minDepth(TreeNode2 root) {
		 if(root == null) return 0;
		 if(root.left == null && root.right == null) return 1;
        List<Integer> minDepth = new ArrayList<>();
        minDepth.add(Integer.MAX_VALUE);
        helper(root,0,minDepth);
        return minDepth.get(0);
	        
	    }
	    
	    static void helper(TreeNode2 root, int depth, List<Integer> minDepth){
	    	 if(root == null){
	    		 if(depth == 1) return;
	             if(depth < minDepth.get(0)){
	                 minDepth.remove(0);
	                 minDepth.add(depth);
	             }
	             return;
	         }
	         helper(root.left, depth+1,minDepth);
	         helper(root.right,depth+1,minDepth);
	     
	    }
	    
	    public static void main(String args[]) {
	    	TreeNode2 root = new TreeNode2(1);
	    	TreeNode2 first = new TreeNode2(2);
	    	TreeNode2 sec = new TreeNode2(3);
	    	TreeNode2 third = new TreeNode2(4);
	    	TreeNode2 fourth = new TreeNode2(5);
	    	root.left = first;
	    	root.right = sec;
	    	
	    	root.left = null;
	    	root.right = first;
	    	first.right = null;
	    	first.left = null;
	    	int depth = minDepth(root);
	    	System.out.println("The min deph :: "+depth);
	    	
	    }
*/
}
