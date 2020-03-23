import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class GraphNode {
	
	public Map<Integer,MyNode> nodeLookup = new HashMap<>();
	
	public static class MyNode{
		private int id;
		public List<MyNode> adjacent = new LinkedList<>();
		public MyNode(int nodeId) {
			id = nodeId;
		}		
	}
	
	
	public void addEdge(int source, int dest) {
		MyNode sNode = nodeLookup.get(source);
		MyNode dNode = nodeLookup.get(dest);
		sNode.adjacent.add(dNode);
	}
	
	public boolean hasDFSPath(int source, int dest) {
		MyNode sNode = nodeLookup.get(source);
		MyNode dNode = nodeLookup.get(dest);
		
		HashSet<MyNode> visited = new HashSet<>();
		return dfsPath(sNode,dNode,visited);
		
	}
	
	private boolean dfsPath(MyNode source, MyNode dest,HashSet<MyNode> visited) {
		if(visited.contains(source)) return false;		
		if(source == dest) {
			System.out.println("The next node :"+source.id);
			return true;		
		}
		visited.add(source);
		System.out.println("The next node :"+source.id);
		for(MyNode current : source.adjacent) {
			if(dfsPath(current, dest, visited)) {
				return true;
			}
		}
		
		return false;
	}
	
	public boolean hasBFSPath(int source, int dest) {
		MyNode sNode = nodeLookup.get(source);
		MyNode dNode = nodeLookup.get(dest);		
		return bfsPath(sNode,dNode);
		
	}
	
	private boolean bfsPath(MyNode source, MyNode dest) {
		Queue<MyNode> nodeToVisit = new LinkedList<>();
		HashSet<MyNode> visited = new HashSet<>();
		if(source == dest) {
			System.out.println("The next node :"+source.id);
			return true;
		}
		nodeToVisit.add(source);
		while(!nodeToVisit.isEmpty()) {			
				MyNode head = nodeToVisit.poll();	
				System.out.println("The next node :"+head.id);
				if(head == dest) return true;
				if(visited.contains(head)) continue;
				visited.add(head);
				for(MyNode current:head.adjacent) {
					if(current == dest) {
						System.out.println("The next node :"+current.id);
						return true;
					}else {
						nodeToVisit.add(current);
					}
				}			
		}
		return false;
	}
	
	
	
	public static void main(String args[]) {
		GraphNode graph = new GraphNode();
		MyNode node1 = new MyNode(1);
		MyNode node2 = new MyNode(2);
		MyNode node3 = new MyNode(3);
		MyNode node4 = new MyNode(4);
		MyNode node5 = new MyNode(5);
		MyNode node6 = new MyNode(6);
		MyNode node7 = new MyNode(7);
		
		graph.nodeLookup.put(1, node1);
		graph.nodeLookup.put(2, node2);
		graph.nodeLookup.put(3, node3);
		graph.nodeLookup.put(4, node4);
		graph.nodeLookup.put(5, node5);
		graph.nodeLookup.put(6, node6);
		graph.nodeLookup.put(7, node7);
		
		node1.adjacent.add(node2);
		node1.adjacent.add(node3);
		node2.adjacent.add(node4);
		node2.adjacent.add(node5);
		node4.adjacent.add(node6);
		
		System.out.println("The Path from 1 to 5 exist :: "+graph.hasDFSPath(1, 5));
		System.out.println("The Path from 1 to 6 exist :: "+graph.hasDFSPath(1, 6));
		System.out.println("The Path from 1 to 5 exist :: "+graph.hasDFSPath(1, 5));
		System.out.println("The Path from 1 to 7 exist :: "+graph.hasDFSPath(1, 7));
		
		
		System.out.println("The Path from 1 to 5 exist :: "+graph.hasBFSPath(1, 5));
		System.out.println("The Path from 1 to 6 exist :: "+graph.hasBFSPath(1, 6));
		System.out.println("The Path from 1 to 3 exist :: "+graph.hasBFSPath(1, 3));
		System.out.println("The Path from 1 to 7 exist :: "+graph.hasBFSPath(1, 7));
		
		
	}
		
	
	




	
}
