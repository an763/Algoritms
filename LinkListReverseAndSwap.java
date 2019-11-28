
class ListNode {
	 int val;
	 ListNode next;
	 ListNode(int x) { val = x; }
}

public class LinkListReverseAndSwap {
	
	ListNode head1 = null;
	public static void main(String args[]) {
		ListNode head = new ListNode(1);		
		ListNode sec = new ListNode(2);		
		ListNode third = new ListNode(3);
		ListNode fourth = new ListNode(4);
		ListNode fifth = new ListNode(5);
		ListNode sixth = new ListNode(6);
		ListNode seventh = new ListNode(7);
		ListNode eight = new ListNode(8);
		
		head.next = sec;
		sec.next = third;		
		third.next = fourth; 
		fourth.next = fifth;
		fifth.next = sixth;
		sixth.next = seventh;
		seventh.next = eight;
		eight.next = null;
		 
		LinkListReverseAndSwap s = new LinkListReverseAndSwap();
		
		
		// Reverse using Non Tail Recursion
		ListNode revr = s.reverseLLNonTailRecursion(head);
		ListNode forTailrecurse = revr;
		
		while(revr != null) {
			System.out.print(revr.val+"-->" );
			revr = revr.next;			
		}
		System.out.println("----------------------");
		// Reverse using Non Tail Recursion
		ListNode res = s.reverseLLTailRecursion(forTailrecurse,null);		
		while(res != null) {
			System.out.print(res.val+"-->" );
			res = res.next;			
		}		
	
	}

    
    ListNode swapPairsByRecursion(ListNode node){
        if(node==null || node.next == null) return node;
       
        
        /*
         * 
         * Node  _______  Node.Next  _______  Node.Next.Next
	      -->	|_______|   --> 	|_______| -->                 
	 
         * 
         * 
         * 
         */
        // node and node.next will be swapped with each other 
        // node.next.next should point to node and node.next will be the new head
       
        // first store head of list after two nodes , it will be passed to swap function 
        ListNode temp  = node.next.next;  
        
        // start swapping ...
        //  move the 2nd node point to first node
        node.next.next = node;     
        // now change the head to next node.. 
        ListNode newhead = node.next; 
        // swapping for these two complete
        
        // now recurse for next pairs
        node.next = swapPairsByRecursion(temp);
    
        return  newhead;
    }
    
    
    
    public ListNode revereseLLByIterating(ListNode node) {    	
    	
    	ListNode prev = null;    
    	
    	  /*
         * 
         * prev  _______  Node   _______  Node.Next
	      -->	|_______|   --> |_______| -->                 
	 
         * 
         * 
         * 
         */
    	
    	while(node != null) {
    		// first have the reference of node.next in temp
	    	ListNode temp = node.next;	
	    	// now node.next should point to prev	    	
	    	node.next = prev;	    	
	    	// prev should point to current node
	    	prev = node;	    	
	    	// node should now point to next node i.e. temp;
	    	node = temp;    	
    	}
    	
    	return prev;
    }
    
    
    
 // reverse linked list using recursion (non tail)
 private ListNode reverseLLNonTailRecursion(ListNode current) {
	 if(current==null || current.next == null) return current;
	 
	 // this will move the new Head , once it reaches terminating condition, it
	 // returns back and then actual reversal happens for each stack frame.
	 ListNode newHead = reverseLLNonTailRecursion(current.next);
	 current.next.next = current;
	 current.next = null;
	 return newHead;
 }
 
 // Reverse linked list using tail recursion
 
 private ListNode reverseLLTailRecursion(ListNode current, ListNode prev) {
	 // return the prev node because current node is null and prev node will be new head of linked list
	 if(current == null) return prev;
	 // reversal is happening in each recursive call and once it recahes terminating condition,
	 // it returns the new head terminates.
	 ListNode temp = current.next;
	 current.next = prev;
	 prev = current;
	 return reverseLLTailRecursion(temp, prev);
 }

 private ListNode swapByIterating(ListNode node) {
	 if(node == null || node.next == null) return node;
	 
	 ListNode newHead = node.next;
	 ListNode temp = null;
	 while(node!=null && node.next != null ) {		 
		 if(node.next.next ==null) {
			 node.next.next = node;
			 node.next = null;
		 }else {
			 temp = node.next.next;
			 node.next.next = node;
			 if(temp.next == null ) {
				 node.next = temp;
			 }else {
				 node.next = temp.next;	
			 }
			 node = temp;
		 }
	 }
	 return newHead;
 }


}
