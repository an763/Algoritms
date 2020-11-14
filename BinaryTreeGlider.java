import java.util.*;


class BinaryTreeGlider {

	class Node {
		int key;
		Node left, right;

		public Node(int item) {
			key = item;
			left = right = null;
		}
	}
	Node root;

	BinaryTreeGlider() {
		root = null;
	}
	
	void insert(int key) {
		root = insertRec(root, key);
	}

	Node insertRec(Node root, int key) {
		Node prior = null;
	    if(root == null){
	        root = new Node(key);
	    }else{
	    	Node temp = root;
	    	while(temp != null){
	    		prior = temp;
	            if(key < temp.key) {
	            	temp = temp.left;
	            }else {
	            	temp = temp.right;
	            }
	        }
	    	if(prior.key > key) {
	    		prior.left = new Node(key);
	    	}else {
	    		prior.right = new Node(key);
	    	}
	    }
		return root;
	}
	
  
    int getLeafCount(Node node) {
        if(node == null) {
            return 0;
        }
        if(node.left == null && node.right == null) {
            return 1;
        }
        return getLeafCount(node.left) + getLeafCount(node.right);
    }
    
    private static int solve(int[] arr, int n) {
		int result = 0;
		BinaryTreeGlider bst = new BinaryTreeGlider();
		for(int i = 0; i < n; i++) {
			bst.insert(arr[i]);
		}
		result = bst.getLeafCount(bst.root);
		return result;
	}

    public static void main(String[] args) { 
    //   Scanner in = new Scanner(System.in); 
       // Click HELP above to see examples of handling input/debug/output 
       // INPUT: int n = in.nextInt(); 
       // DEBUG: System.out.println(n); 
       // OUTPUT: System.out.println(result); 

       // Write the code to solve the problem below, 
       // format the "result" as specified in the problem statement 
       // and finally, write the result to stdout 
       // IMPORTANT: Remove all debug statements for final submission
		int n = 3;
		int[] arr = new int[n];
		arr[0]=3;
		arr[1]=2;	
		arr[2]=4;
		System.out.println(solve(arr, n));
		//in.close();
    } 

}


    
	

