

public class QueueArrayImpl {
	int[] myQueue;
	int start =0;
	int end= 0;
	int n=0; // number of elements in queue 
	public QueueArrayImpl() {
		myQueue = new int[1];
	}
	
	public boolean isEmpty() {
		return (n==0);
	}
	
	public void enQueue(int val){	
		
		// if queue is full it needs to be resized..
		if(n==myQueue.length) {
			resize();
		}
		
		// normal case 
		if((start >= 0 && end >= start && end < myQueue.length) || (start > end)) {
			myQueue[end++] = val;
			return;
		}else if(start == end && start == myQueue.length) {// Boundary case when both pointers reached at the end of queue, then reset the queue.. 
			end = 0;
			myQueue[end] = val;
		}else if(end == myQueue.length && start !=0 ) { // End pointer is at end and start pointer is not zero
			end =0;
			myQueue[end++] = val;
		}else if(start==0 && end==myQueue.length) {// start pointer is at the 0 and end pointer has reached end
			resize();
			myQueue[end++] = val;
		}	
		
	}
	
	public int deQueue() {		
		int temp =0;		
		if(isEmpty()) {
			throw new IllegalStateException("Queue is empty");
		}else if((start >= 0 && end >= start && end <= myQueue.length) || (start > end)) { // normal case 
			if(start == myQueue.length) {
				start = 0;
			}
			temp= myQueue[start];
			myQueue[start] = -1;
			start++;
		}else if(start == end && start == myQueue.length) { // Boundary case when both pointers reached at the end of queue, queue will be empty after this deQueue
			temp = myQueue[start];	
			myQueue[start] = -1;
			start = 0;
			end =0;					
		}else if(end == myQueue.length && start !=0 ) { // End pointer is at end and start pointer is not zero
			temp= myQueue[start];
			myQueue[start] = -1;
			start++;
		}		
		return temp;
	}
	
	private void resize() {
		int[] copyArr = new int[2* myQueue.length];
		for(int i=start; i<end; i++) {
			copyArr[i] = myQueue[i];
		}
		myQueue = copyArr;
		
	}

	public static void main(String args[]) {
		QueueArrayImpl qImpl = new QueueArrayImpl();
		qImpl.enQueue(1);
		qImpl.enQueue(2);
		qImpl.enQueue(3);
		qImpl.enQueue(4);
		qImpl.enQueue(5);
		qImpl.enQueue(6);
		System.out.println("Dequeue this :: "+qImpl.deQueue());
		System.out.println("Dequeue this :: "+qImpl.deQueue());
		System.out.println("Dequeue this :: "+qImpl.deQueue());
		System.out.println("Dequeue this :: "+qImpl.deQueue());
		
		qImpl.enQueue(3);
		qImpl.enQueue(4);
		qImpl.enQueue(5);
		qImpl.enQueue(1);
		qImpl.enQueue(2);
		qImpl.enQueue(3);
		
		
		System.out.println("Dequeue this :: "+qImpl.deQueue());
		System.out.println("Dequeue this :: "+qImpl.deQueue());
		System.out.println("Dequeue this :: "+qImpl.deQueue());
		System.out.println("Dequeue this :: "+qImpl.deQueue());
		
		System.out.println("Dequeue this :: "+qImpl.deQueue());
		System.out.println("Dequeue this :: "+qImpl.deQueue());
		System.out.println("Dequeue this :: "+qImpl.deQueue());
		System.out.println("Dequeue this :: "+qImpl.deQueue());
		System.out.println("Dequeue this :: "+qImpl.deQueue());
	}
	
	
}
