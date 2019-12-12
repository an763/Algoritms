import java.util.ArrayList;
import java.util.List;

public class QueueArrayListImpl {
	List<Integer> myQueue =null;
	
	public QueueArrayListImpl() {
		myQueue = new ArrayList<Integer>();
	}
	
	public void enQueue(int val) {
		myQueue.add(val);
	}
	
	public int getFrontItem() {
		if(myQueue.isEmpty()) {
			throw new IllegalStateException("Queue is empty now");
		}		
		return myQueue.get(0).intValue();
		
	}
	
	public void deQueue() {
		if(myQueue.isEmpty()) {
			System.out.println("Queue is empty");
			return;
		}
		System.out.println("Element "+myQueue.get(0) +" removed" );		
		myQueue.remove(0);
	}
	
	public static void main(String args[]) {
		QueueArrayListImpl qImpl = new QueueArrayListImpl();
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
		qImpl.deQueue();
		
		System.out.println("The item front .."+qImpl.getFrontItem());
		qImpl.deQueue();
		qImpl.deQueue();
		System.out.println("The item front .."+qImpl.getFrontItem());
		qImpl.deQueue();
		System.out.println("The item front .."+qImpl.getFrontItem());
	}
	
	
}
