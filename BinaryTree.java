import java.util.ArrayList;
import java.util.List;

public class BinaryTree {
	
	Node rootNode = null;
	Node nodeToadd = null;
	List<Integer> st = new ArrayList<Integer>();
	int height;
	
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
	
	
	public static void main(String [] args)
	{
		BinaryTree bt = new BinaryTree();
		bt.addNode(9);
		bt.addNode(7);
	
		bt.addNode(3);
		bt.addNode(2);
		bt.addNode(5);
		bt.addNode(17);
		bt.addNode(12);
		bt.addNode(19);
		bt.addNode(20);
		bt.addNode(13);
		bt.addNode(10);
		bt.addNode(18);
		bt.addNode(8);
		
		int height = bt.heightOfBTree(bt.rootNode);
		
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
		System.out.println("After swap**** ");
		bt.preOrderTraversal(bt.rootNode);
		
//		bt.height = bt.heightOfBTree(bt.rootNode);
		
		System.out.println("Going to delete node 19 ******" );
		
		bt.deleteNode(9);
		bt.preOrderTraversal(bt.rootNode);
		
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