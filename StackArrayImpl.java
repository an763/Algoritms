
public class StackArrayImpl {
	private int [] stackArrayStore;
	private int index=0;
	
	public StackArrayImpl(int capacity) {
		stackArrayStore = new int[capacity];
	}
	public boolean isEmpty() {
		return index==0;
	}
	
	public void push(int value) {
		if(index == stackArrayStore.length) {
			return;
		}
		stackArrayStore[index++] = value;
	}
	
	public int pop() {
		if(index==0) throw new IllegalStateException("Stack is Empty!!");
		return stackArrayStore[--index];		
	}
	
	public static void main(String...strings) {
		StackArrayImpl stack = new StackArrayImpl(5);
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
