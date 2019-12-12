
public class QueueLinkedList {
	Node first = null;
	Node last = null;
	
	private class Node{
		int val;
		Node next;
	}
	
	public boolean isEmpty() {
		return first == null;
	}	
		
	public void enQueue(int val) {
		Node oldLast = last;
		last = new Node();
		last.val = val;
		last.next = null;
		if(isEmpty()) {
			first = last;
		}else {
			oldLast.next = last;
		}
	}
	
	public void deQueue() {
		if(isEmpty()) {
			System.out.println("Queue is empty");
			return;
		}
		System.out.println("Element "+first.val +" removed" );		
		first = first.next;
	}
	
	public static void main(String args[]) {
		QueueLinkedList qImpl = new QueueLinkedList();
		qImpl.deQueue();
		qImpl.enQueue(1);
		qImpl.enQueue(2);
		qImpl.enQueue(3);
		qImpl.enQueue(4);
		qImpl.enQueue(5);
		qImpl.enQueue(6);
		qImpl.deQueue();
		qImpl.deQueue();
		qImpl.deQueue();
		qImpl.deQueue();
		qImpl.deQueue();
		
		qImpl.enQueue(3);
		qImpl.enQueue(4);
		qImpl.enQueue(5);
		qImpl.enQueue(1);
		qImpl.enQueue(2);
		qImpl.enQueue(3);
		
		
		qImpl.deQueue();
		qImpl.deQueue();
		qImpl.deQueue();
		qImpl.deQueue();
		System.out.println("Queue is Empty :: "+qImpl.isEmpty() );
		qImpl.deQueue();
		qImpl.deQueue();
		qImpl.deQueue();
		System.out.println("Queue is Empty :: "+qImpl.isEmpty() );
	
	}
	
	
}
