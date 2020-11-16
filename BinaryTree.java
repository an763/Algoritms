import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BinaryTree {   
	
	Node rootNode = null;
	Node nodeToadd = null;
	List<Integer> st = new ArrayList<Integer>();
	int height;
	
	
	
	public void swapBTree(Node node) {
		if(node == null) return;
		Node temp = node.left;
		node.left = node.right;
		node.right = temp;
		swapBinaryTree(node.left);
		swapBinaryTree(node.right);
	}
	
	  public boolean helper(TreeNode node, Integer lower, Integer upper) {
		    if (node == null) return true;

		    int val = node.val;
		    if (lower != null && val <= lower) return false;
		    if (upper != null && val >= upper) return false;

		    if (! helper(node.right, val, upper)) return false;
		    if (! helper(node.left, lower, val)) return false;
		    return true;
		  }

		  public boolean isValidBST(TreeNode root) {
		    return helper(root, null, null);
		  }
	
	
	
	public void addNode(int nodeVal)
	{

		if(rootNode == null)
		{
			rootNode= new Node(null,null,nodeVal);
		}
		else
		{
			Node tempNode = rootNode;
			
			while(tempNode != null)
			{
				nodeToadd = tempNode;
				if(tempNode.value > nodeVal)
				{
					tempNode = tempNode.left;
				}
				else
				{
					tempNode = tempNode.right;
				}
				
			}
			// now the pointer is at nodeToadd
			if(nodeToadd.value > nodeVal)
			{
				nodeToadd.left = new Node(null,null,nodeVal);
			}
			else
			{
				nodeToadd.right = new Node(null,null,nodeVal);
			}
			
		}		
		
	}
	
	public void preOrderTraversal(Node node)
	{
		if (node == null) return;
		
		System.out.println("The node value is "+node.value);
		preOrderTraversal(node.left);
		preOrderTraversal(node.right);
	}
	
	public void inOrderTraversal(Node node)
	{
		if (node == null) return;
		inOrderTraversal(node.left);
		System.out.println("The node value is "+node.value);		
		inOrderTraversal(node.right);
	}
	
	public void postOrderTraversal(Node node)
	{
		
		
		if (node == null) return;
		
		
		postOrderTraversal(node.left);
		postOrderTraversal(node.right);
		System.out.println("The node value is "+node.value);
	}
	
	
	public static void main(String [] args)
	{
		
	/*	Scanner in = new Scanner(System.in);
		String first = in.nextLine();
		System.out.println("The first line :: "+first);
		
		
		int[] crossword [] = new int[10][20];
		  for (int i = 0; i < crossword.length; i++)
		     for (int j = 0; j < crossword.length; j++)
		        crossword[i][j] = 'x';	
		//  System.out.println(crossword.length);
		  
		  Stream<Integer> numStream = Stream.of(10, 20, 30);
		  numStream.map(n -> n + 10).peek(s -> System.out.print(s));
	//	  numStream.forEach(s -> System.out.println(s));
		  byte b = 5;
		  
		  String lol = "lol";
		           System.out.println(lol.toUpperCase() == lol);
		           System.out.println(lol.toUpperCase() == lol.toUpperCase());
		           System.out.println(lol.toUpperCase().equals(lol));
		           System.out.println(lol.toUpperCase().equals(lol.toUpperCase()));
		           System.out.println(lol.toUpperCase().equalsIgnoreCase(lol));
		          System.out.println(lol.toUpperCase()
		             .equalsIgnoreCase(lol.toUpperCase()));
		
		  StringBuilder builder = new StringBuilder("Leaves growing");
		  do {
		     builder.delete(0, 5);
		  } while (builder.length() > 5);
		  System.out.println(builder);
		  
		  
		int sum = Arrays.stream(new int[]{1, 2, 3})
				  .filter(i -> i >= 2)
				  .map(i -> i * 3)
				  .sum();
		
		System.out.println("The sum is ::: "+sum);
		
		
		Map<String, List<String>> people = new HashMap<>();
		people.put("John", Arrays.asList("555-1123", "555-3389"));
		people.put("Mary", Arrays.asList("555-2243", "555-5264"));
		people.put("Steve", Arrays.asList("555-6654", "555-3242"));
		 
		List<String> phones = people.values().stream()
		  .flatMap(Collection::stream)
		    .collect(Collectors.toList());
		
		System.out.println("The phones list is ::: "+phones.toString());
		
		int x = 0; int y =1;
		
	//	int c = y/=x;
		
		int a[] = {1,2,04};
		
		
		System.out.println(a instanceof Object);
		*/
		BinaryTree bt = new BinaryTree();
		bt.addNode(9);
		bt.addNode(11);
	
		bt.addNode(3);
		/*bt.addNode(2);
		bt.addNode(5);
		bt.addNode(17);
		bt.addNode(12);
		bt.addNode(19);
		bt.addNode(20);
		bt.addNode(13);
		bt.addNode(10);
		bt.addNode(18);
		bt.addNode(8);
		bt.addNode(4);
		bt.addNode(6);
		*/
		int height = bt.heightOfBTree(bt.rootNode);
		System.out.println("height "+height);
		System.out.println("postOrderTraversal ");
		bt.postOrderTraversal(bt.rootNode);
		
		
	/*	int height = bt.heightOfBTree(bt.rootNode);
		
		System.out.println("The height :: "+height);
		
		bt.preOrderTraversal(bt.rootNode);
	/*	bt.kthSmallestElement(bt.rootNode,8);
		
		System.out.println("The size of list is "+bt.st.size());
		System.out.println("The 8th smallest is "+bt.st.get(7));
		
		bt.st = new ArrayList<Integer>();
		bt.kthLargestElement(bt.rootNode,2);
		System.out.println("The size of list is "+bt.st.size());
		System.out.println("The 2nd largest is "+bt.st.get(1));
		
		for(int i=0; i<bt.st.size(); i++)
		{
			System.out.println("The all elements in list are "+bt.st.get(i));
		}	*/		
		
	//	bt.swapBinaryTree(bt.rootNode);
		System.out.println("preOrderTraversal**** ");
		bt.preOrderTraversal(bt.rootNode);
		
//		bt.height = bt.heightOfBTree(bt.rootNode);
		
	/*	System.out.println("Going to delete node 19 ******" );
		
		bt.deleteNode(9);
		bt.preOrderTraversal(bt.rootNode);*/
		
	}
	 
	public void kthSmallestElement(Node node, int k)
	{	
		if((node == null) || (st.size()>=k)) return;		
		kthSmallestElement(node.left,k);		
		if(st.size()<k) st.add(node.value);	
		kthSmallestElement(node.right,k);
	}     
	
	public void kthLargestElement(Node node, int k)
	{	
		if((node == null) || (st.size()>=k)) return;		
		kthLargestElement(node.right,k);		
		if(st.size()<k) st.add(node.value);	
		kthLargestElement(node.left,k);
	}
	
	public void swapBinaryTree(Node node)
	{
		if(node== null) return;
		Node temp = node.left;
		node.left = node.right;
		node.right = temp;
		swapBinaryTree(node.left);
		swapBinaryTree(node.right);		
	}
	
	public int heightOfBTree(Node node)
	{
		if(node==null || (node.left ==null && node.right == null)) {
			return 0;
		}else {
			return 1 + Math.max(heightOfBTree(node.left), heightOfBTree(node.right));
		}		
	}
	
	/*
	 public int heightOfBTree(Node node)
	{
		if(node==null) return 0;
		
		int left = heightOfBTree(node.left);
		int right = heightOfBTree(node.right);
		
		if(left>right)
		{
			height = left +1;
		}
		else
		{
			height = right +1;
		}
		
		return height;
		
	}
	 */
	
	public void deleteNode(int value)
	{
		Node node = rootNode;
		Node temp=null;
		Node tempR = null;
		boolean left = false, right = false;
		
		while((node != null) )
		{
			if(node.value == value)
			{
				break;
			}
			if(node.value > value)
			{
				left = true;
				right = false;
				temp=node;
				node = node.left;
			}
			else
			{
				left = false;
				right = true;
				temp=node;
				node = node.right;
			}
			
			
		}
		
		if(node == null) {
			
			System.out.println("Node does not exist");
			return;
		}
		else{
			if(node.left == null && node.right==null)
			{
				node = null;
			}
			else if(node.left == null && node.right!=null)
			{
				if(left)
				{
					temp.left = node.right;
					node=null;
				}
				else if(right)
				{
					temp.right = node.right;
					node = null;
				}
			}
			else if(node.left != null && node.right==null)
			{
				if(left)
				{
					temp.left = node.left;
					node=null;
				}
				else if(right)
				{
					temp.right = node.left;
					node = null;
				}
			}
			else if(node.left != null && node.right!=null)
			{
				if(left)
				{
					temp.left = node.left;
					Node traverse = node.left;
					while (traverse !=null)
					{
						tempR = traverse;
						traverse = traverse.right;
					}
					tempR.right = node.right;
					node = null;
				}
				else if(right)
				{
					temp.right = node.right;
					Node traverse = node.right;
					
					while (traverse !=null)
					{
						tempR = traverse;
						traverse = traverse.left;
					}
					tempR.left = node.left;
					node = null;
				}
			}			
				
		}
		
		return;
		
	}
	
	public void levelOrder(Node node) {
		if(node==null) return;		
		Queue<Node> nodeHolder = new LinkedList<Node>();
		nodeHolder.add(node);		
		while(!nodeHolder.isEmpty()) {
			Node current = nodeHolder.poll();
			System.out.println("The value of node :: "+current.value);
			if(current.left!=null) {
				nodeHolder.add(current.left);
			}
			if(current.right!=null) {
				nodeHolder.add(current.right);
			}			
			 
		}		
	}
	
	
	  public TreeNode searchBST(TreeNode root, int val) {  
	        if(root == null) return null;
	        Queue<TreeNode> children = new LinkedList<TreeNode>();
	        children.add(root);
	        while(!children.isEmpty()){
	            TreeNode current = children.poll();
	            if(current.val == val){
	                return current;
	            }else{
	                if(current.left != null) children.add(current.left);
	                if(current.right != null) children.add(current.right);
	            }
	        }
	        return null;       
	        
	        /*
	         TreeNode temp = null;
        if (root == null || root.val == val) {
        return root;
        }
        if (val < root.val) {
             temp = searchBST(root.left, val);         
        }else{
             temp = searchBST(root.right, val);            
        }
        return temp;
	         */
	    }
	

	
	
	

}

class Node{
	Node left;
	Node right;
	int value;
	
	Node(Node left,Node right,int val){
		this.left = left;
		this.right = right;
		this.value = val;
	}
	
}