class ListNodee {
	 int val;
	 ListNodee next;
	 ListNodee(int x) { val = x; }
}

public class LinkListSwap {
	
	
	public static void main(String args[]) {
		ListNodee head = new ListNodee(1);		
		ListNodee sec = new ListNodee(2);		
		ListNodee third = new ListNodee(3);
		ListNodee fourth = new ListNodee(4);
		ListNodee fifth = new ListNodee(5);
		ListNodee sixth = new ListNodee(6);
		
		head.next = sec;
		sec.next = third;		
		third.next = fourth; 
		fourth.next = fifth;
		fifth.next = sixth;
		sixth.next = null;
		 
		
		LinkListSwap s = new LinkListSwap();
		ListNodee swapped = s.swapPairs(head);
		
		while(swapped != null) {
			System.out.println("The val node is :: "+swapped.val);
			swapped = swapped.next;
			
		}
		
		
	}
    public ListNodee swapPairs(ListNodee head) {
       return helper(head);
    }
    
    ListNodee helper(ListNodee node){
        if(node==null || node.next == null) return node;
        // first store head of list after two nodes , it will be passed to swap function 
        ListNodee temp  = node.next.next; 
        // now move the head to second node (part of swap process)
        ListNodee newhead = node.next; 
        // now move the 2nd node point to first node
        node.next.next = node;
        // now recurse for next pairs
        node.next = helper(temp);
        return newhead;
    }
}
