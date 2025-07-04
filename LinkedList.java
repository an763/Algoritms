
public class LinkedList {

	private NodeNew head;
	private NodeNew tail;

	public NodeNew getHead() {
		return head;
	}

	public void setHead(NodeNew head) {
		this.head = head;
	}

	public NodeNew getTail() {
		return tail;
	}

	public void setTail(NodeNew tail) {
		this.tail = tail;
	}

	public void appendNode(NodeNew node) {
		if (head == null) {
			head = node;
		} else {
			tail.setNext(node);
		}
		tail = node;
	}

	public static void main(String args[]) {
		sortTest();
		cycleTest();
		findStartOfCycle();
		reverseList();
		char ch0 = '0';
		char ch9 = '9';
		char chstar = '*';
		
		String exp = "3*2+1";
		char[] arr = exp.toCharArray();
		int num1 = arr[0] - ch0;
		int num2 = arr[2] - ch0;
		int num3 = arr[4] - ch0;
		
		int res = num1 * num2;
		res = res + num3;
		
		System.out.println("The ch0 "+(int)ch0);
		System.out.println("The num1 "+num1 +" and org arr[0] "+(int)arr[0]);
		System.out.println("The num2 "+num2 +" and org arr[2] "+(int)arr[2]);
		System.out.println("The num3 "+num2 +" and org arr[4] "+(int)arr[4]);
		
 		System.out.println("The result "+res);
		
	}
	
	public static void reverseList() {
		LinkedList listToReverese = new LinkedList();
		NodeNew one = new NodeNew();
		one.setData(1);		
		NodeNew two = new NodeNew();
		two.setData(2);		
		NodeNew three = new NodeNew();
		three.setData(3);		
		NodeNew four = new NodeNew();
		four.setData(4);		
		NodeNew five = new NodeNew();
		five.setData(5);		
		NodeNew six = new NodeNew();
		six.setData(6);		
		NodeNew seven = new NodeNew();
		seven.setData(7);
		NodeNew eight = new NodeNew();
		eight.setData(8);
		
		listToReverese.appendNode(one);
		listToReverese.appendNode(two);
		listToReverese.appendNode(three);
		listToReverese.appendNode(four);
		listToReverese.appendNode(five);
		listToReverese.appendNode(six);
		listToReverese.appendNode(seven);
		listToReverese.appendNode(eight);	
		NodeNew current = listToReverese.getHead();
		System.out.println("Before Reversal Nodes :: ");
		System.out.println("head "+listToReverese.getHead().getData() +", Tail " + listToReverese.getTail().getData());
		while(current!= null) {			
			System.out.print(current.getData() +"-->");
			current = current.getNext();
		}
		
		listToReverese.reverseLinkedList(listToReverese.getHead());
		NodeNew tail = listToReverese.getHead();
		listToReverese.setHead(listToReverese.getTail());
		listToReverese.setTail(tail);
		current = listToReverese.getHead();
		System.out.println();
		System.out.println("After Reversal Nodes :: ");
		System.out.println("head "+listToReverese.getHead().getData() +", Tail " + listToReverese.getTail().getData());
		while(current!= null) {			
			System.out.print(current.getData() +"-->");
			current = current.getNext();
		}
		
	
	}
	
	public static void findStartOfCycle() {
		LinkedList listWithCycle = new LinkedList();
		NodeNew one = new NodeNew();
		one.setData(1);		
		NodeNew two = new NodeNew();
		two.setData(2);		
		NodeNew three = new NodeNew();
		three.setData(3);		
		NodeNew four = new NodeNew();
		four.setData(4);		
		NodeNew five = new NodeNew();
		five.setData(5);		
		NodeNew six = new NodeNew();
		six.setData(6);		
		NodeNew seven = new NodeNew();
		seven.setData(7);
		NodeNew eight = new NodeNew();
		eight.setData(8);
		
		listWithCycle.appendNode(one);
		listWithCycle.appendNode(two);
		listWithCycle.appendNode(three);
		listWithCycle.appendNode(four);
		listWithCycle.appendNode(five);
		listWithCycle.appendNode(six);
		listWithCycle.appendNode(seven);
		listWithCycle.appendNode(eight);		
		eight.setNext(seven);
		NodeNew startOfCycle = listWithCycle.findStartOfCycle(listWithCycle);
		System.out.println("startOfCycle NodeNew :: "+startOfCycle.getData());
	}
	
	public static void cycleTest() {
		
		LinkedList listWithCycle = new LinkedList();
		NodeNew one = new NodeNew();
		one.setData(1);		
		NodeNew two = new NodeNew();
		two.setData(2);		
		NodeNew three = new NodeNew();
		three.setData(3);		
		NodeNew four = new NodeNew();
		four.setData(4);		
		NodeNew five = new NodeNew();
		five.setData(5);		
		NodeNew six = new NodeNew();
		six.setData(6);		
		NodeNew seven = new NodeNew();
		seven.setData(7);
		NodeNew eight = new NodeNew();
		eight.setData(8);
		
		listWithCycle.appendNode(one);
		listWithCycle.appendNode(two);
		listWithCycle.appendNode(three);
		listWithCycle.appendNode(four);
		listWithCycle.appendNode(five);
		listWithCycle.appendNode(six);
		listWithCycle.appendNode(seven);
		listWithCycle.appendNode(eight);		
		eight.setNext(seven);
		
		boolean cycle = listWithCycle.findIfCycle(listWithCycle);
		System.out.println("There is cycle :: "+cycle);
		if(cycle) {
			int length = listWithCycle.findCycleLength(listWithCycle);
			System.out.println("length of cycle :: "+length);
		}
		
	}
	
	public static void sortTest() {

		LinkedList unsorted = new LinkedList();
		NodeNew node0 = new NodeNew();
		node0.setData(0);
		NodeNew node01 = new NodeNew();
		node01.setData(0);
		NodeNew node02 = new NodeNew();
		node02.setData(0);

		NodeNew node1 = new NodeNew();
		node1.setData(1);
		NodeNew node11 = new NodeNew();
		node11.setData(1);
		NodeNew node12 = new NodeNew();
		node12.setData(1);

		NodeNew node2 = new NodeNew();
		node2.setData(2);
		NodeNew node21 = new NodeNew();
		node21.setData(2);
		NodeNew node22 = new NodeNew();
		node22.setData(2);

		unsorted.appendNode(node22);
		unsorted.appendNode(node0);
		unsorted.appendNode(node11);
		unsorted.appendNode(node01);
		unsorted.appendNode(node1);
		unsorted.appendNode(node21);
		unsorted.appendNode(node02);
		unsorted.appendNode(node12);
		unsorted.appendNode(node2);

		LinkedList sorted = unsorted.sortList(unsorted);
		NodeNew current = sorted.getHead();
		while (current != null) {
			System.out.println("The data of NodeNew is ::" + current.getData());
			current = current.getNext();
		}
		
		

	
	}

	public LinkedList sortList(LinkedList unsorted) {
		LinkedList sortedList = new LinkedList();

		LinkedList list0 = new LinkedList();
		LinkedList list1 = new LinkedList();
		LinkedList list2 = new LinkedList();

		NodeNew current = unsorted.getHead();

		while (current != null) {
			if (current.getData() == 0) {
				list0.appendNode(current);
			} else if (current.getData() == 1) {
				list1.appendNode(current);
			} else {
				list2.appendNode(current);
			}
			current = current.getNext();
		}

		list0.getTail().setNext(null);
		list1.getTail().setNext(null);
		list2.getTail().setNext(null);

		sortedList.appendNode(list0.getHead());
		sortedList.setTail(list0.getTail());

		sortedList.appendNode(list1.getHead());
		sortedList.setTail(list1.getTail());

		sortedList.appendNode(list2.getHead());
		sortedList.setTail(list2.getTail());

		return sortedList;

	}

	public boolean findIfCycle(LinkedList list) {
		NodeNew fast = list.getHead();
		NodeNew slow = list.getHead();

		while (fast != null) {
			fast = fast.getNext();
			if (fast == slow)
				return true;
			if (fast != null) {
				fast = fast.getNext();
				if (fast == slow)
					return true;
			}
			slow = slow.getNext();
		}
		return false;
	}

	public int findCycleLength(LinkedList list) {
		NodeNew fast = list.getHead();
		NodeNew slow = list.getHead();
		int length = 0;

		while (fast != null) {
			fast = fast.getNext();
			if (fast == slow) {
				length = countNodes(fast);
				break;
			}
			if (fast != null) {
				fast = fast.getNext();
				if (fast == slow) {
					length = countNodes(fast);
					break;
				}
			}
			slow = slow.getNext();
		}
		return length;
	}
	
	public NodeNew findStartOfCycle(LinkedList list) {
		NodeNew fast = list.getHead();
		NodeNew slow = list.getHead();
		int length = findCycleLength(list);
		int advance = 0;
		while(advance != length) {
			fast = fast.getNext();
			advance++;
		}
		
		while(fast != slow) {
			fast = fast.getNext();
			if(fast != slow)
			slow = slow.getNext();
		}
		return fast;		
	}

	public int countNodes(NodeNew fast) {
		NodeNew travelling = fast;
		travelling = travelling.getNext();
		int count = 1;
		while (fast != travelling) {
			travelling = travelling.getNext();
			count++;
		}
		return count;
	}
	
	
	public NodeNew reverseLinkedList(NodeNew node) {
		NodeNew temp;
		NodeNew current = node;
		NodeNew prev = null;
		while(current != null) {
			temp = current.getNext();
			current.setNext(prev);
			prev = current;
			current = temp;
		}
		return prev;
	}

}

class NodeNew {

	private NodeNew next;
	private int data;

	public NodeNew getNext() {
		return next;
	}

	public void setNext(NodeNew next) {
		this.next = next;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

}
