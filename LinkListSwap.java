class ListNode {
	 int val;
	 ListNode next;
	 ListNode(int x) { val = x; }
}

public class LinkListSwap {
	
	
	public static void main(String args[]) {
		ListNode head = new ListNode(1);		
		ListNode sec = new ListNode(2);		
		ListNode third = new ListNode(3);
		ListNode fourth = new ListNode(4);
		ListNode fifth = new ListNode(5);
		ListNode sixth = new ListNode(6);
		
		head.next = sec;
		sec.next = third;		
		third.next = fourth; 
		fourth.next = fifth;
		fifth.next = sixth;
		sixth.next = null;
		 
		
		LinkListSwap s = new LinkListSwap();
		ListNode swapped = s.swapPairs(head);
		
		while(swapped != null) {
			System.out.println("The val node is :: "+swapped.val);
			swapped = swapped.next;
			
		}
		
		
	}
    public ListNode swapPairs(ListNode head) {
       return helper(head);
    }
    
    ListNode helper(ListNode node){
        if(node==null || node.next == null) return node;
        // first store head of list after two nodes , it will be passed to swap function 
        ListNode temp  = node.next.next; 
        // now move the head to second node (part of swap process)
        ListNode newhead = node.next; 
        // now move the 2nd node point to first node
        node.next.next = node;
        // now recurse for next pairs
        node.next = helper(temp);
        return newhead;
    }
}
