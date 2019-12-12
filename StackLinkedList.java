
public class StackLinkedList {
	// constant time access O(1)
	// Total space for a stack node = 36 bytes
	// 16 bytes of object overhead
	private Node first = null;  // 8 bytes
	private class Node{     // 8 bytes overhead for inner class
		int val =0;        // 4 bytes 
		Node next;
	}
	
	public boolean isEmpty() {
		if(first == null) {
			return true;
		}
		return false;
	}
	
	public void push(int value) {
		Node oldfirst = first;
		first = new Node();
		first.val = value;
		first.next = oldfirst;
	}
	
	public int pop() {
		int value = first.val;
		first = first.next;
		return value;		
	}
	
	public static void main(String...strings) {
		StackLinkedList stack = new StackLinkedList();
		System.out.println("Check if Stack is empty :: "+stack.isEmpty());
		
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		stack.push(6);
		
		
		System.out.println("Pop one by one  :: "+stack.pop());
		System.out.println("Pop one by one  :: "+stack.pop());
		System.out.println("Pop one by one  :: "+stack.pop());
		stack.push(10);
		System.out.println("Pop one by one  :: "+stack.pop());
		System.out.println("Pop one by one  :: "+stack.pop());
		System.out.println("Pop one by one  :: "+stack.pop());
		System.out.println("Pop one by one  :: "+stack.pop());
		
		System.out.println("Check if Stack is empty :: "+stack.isEmpty());
	}
	
	
	
	
	
}
