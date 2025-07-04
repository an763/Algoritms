import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class AdjacencyListNodeGraph {
	
	private List<MyGraphNode> nodes;
	
	public AdjacencyListNodeGraph() {
		nodes = new ArrayList<>();
	}
	
	public void addNode(MyGraphNode node) {
		nodes.add(node);
	}
	
	public List<MyGraphNode> getNodes(){
		return nodes;
	}

	
	public static void main(String args[]) {
		
		
		/***
		 *     1--2--4
		 *     |
		 *     3--5--6--7-11
		 * 			 |
		 * 			 8--9--10
		 * 					|
		 * 					12--13	
		 * 
		 */
		MyGraphNode firstNode = new MyGraphNode();
		firstNode.setData(1);
		MyGraphNode secNode = new MyGraphNode();
		secNode.setData(2);
		MyGraphNode thirdNode = new MyGraphNode();
		thirdNode.setData(3);
		MyGraphNode fourthNode = new MyGraphNode();
		fourthNode.setData(4);
		MyGraphNode fifthNode = new MyGraphNode();
		fifthNode.setData(5);
		MyGraphNode sixNode = new MyGraphNode();
		sixNode.setData(6);
		MyGraphNode sevenNode = new MyGraphNode();
		sevenNode.setData(7);
		MyGraphNode eightNode = new MyGraphNode();
		eightNode.setData(8);
		MyGraphNode ninthNode = new MyGraphNode();
		ninthNode.setData(9);
		MyGraphNode tenthNode = new MyGraphNode();
		tenthNode.setData(10);
		MyGraphNode elevenNode = new MyGraphNode();
		elevenNode.setData(11);
		MyGraphNode twelveNode = new MyGraphNode();
		twelveNode.setData(12);
		MyGraphNode thirteenNode = new MyGraphNode();
		thirteenNode.setData(13);
		firstNode.addNeighbor(thirdNode);
		firstNode.addNeighbor(secNode);
		
		secNode.addNeighbor(fourthNode);
		thirdNode.addNeighbor(fifthNode);
		fifthNode.addNeighbor(sixNode);
		sixNode.addNeighbor(sevenNode);
		sixNode.addNeighbor(eightNode);
		sevenNode.addNeighbor(elevenNode);
		eightNode.addNeighbor(ninthNode);
		ninthNode.addNeighbor(tenthNode);
		tenthNode.addNeighbor(twelveNode);
		twelveNode.addNeighbor(thirteenNode);
		
		AdjacencyListNodeGraph graph = new AdjacencyListNodeGraph();
		graph.addNode(firstNode);
		graph.addNode(secNode);
		graph.addNode(thirdNode);
		graph.addNode(fourthNode);
		graph.addNode(fifthNode);
		graph.addNode(sixNode);
		graph.addNode(sevenNode);
		graph.addNode(eightNode);
		graph.addNode(ninthNode);
		graph.addNode(tenthNode);
		graph.addNode(elevenNode);
		graph.addNode(twelveNode);
		graph.addNode(thirteenNode);
		
		//graph.dfsVisit(graph.getNodes().get(0));
		
		
		
/*		if(graph.dfsSearch(graph.getNodes().get(0), 16)) {
			System.out.println("==> found Node ==> "+ 16);
		}else {
			System.out.println("==> Not found Node ==> "+ 16);
		}
		
	
		
		if(graph.dfsSearch(graph.getNodes().get(0), 12)) {
			System.out.println("==> found Node ==> "+ 12);
		}
		*/
		
		graph.bfsVisitLevelOrder(graph.getNodes().get(0));
		
		int level = graph.wordLadder("hit", "cog");
		System.out.println("==> level is ==> "+ level);
	}
	
	
	public void dfsVisit(MyGraphNode node) {
		node.setStatus(MyGraphNode.Status.visiting);
		System.out.println("Visiting Node ==> "+ node.getData());
		for(MyGraphNode neighbor: node.getNeighbors()) {
			if(neighbor.getStatus() == MyGraphNode.Status.unvisited) {
				dfsVisit(neighbor);
			}
		}
		node.setStatus(MyGraphNode.Status.visited);
	}
	
	public boolean dfsSearch(MyGraphNode node, int data) {
		node.setStatus(MyGraphNode.Status.visiting);
		System.out.println("Visiting Node ==> "+ node.getData());
		if(node.getData() == data) {
			System.out.println("==> found Node ==> "+ node.getData());
			return true;
		}		
		for(MyGraphNode neighbor : node.getNeighbors()) {
			if(neighbor.getStatus() == MyGraphNode.Status.unvisited && dfsSearch(neighbor,data)) {
				return true;
			}
		}
		node.setStatus(MyGraphNode.Status.visited);
		return false;	
	}
	
	public void bfsVisit(MyGraphNode node) {
		Queue<MyGraphNode> queue = new LinkedList<>();
		queue.add(node);
		node.setStatus(MyGraphNode.Status.visiting);
		while(!queue.isEmpty()) {
			MyGraphNode neighbor = queue.poll();
			System.out.println("Visiting Node ==> "+ neighbor.getData());
			for(MyGraphNode neighborChild : neighbor.getNeighbors()) {
				if(neighborChild.getStatus() == MyGraphNode.Status.unvisited) {
					queue.add(neighborChild);
				}
			}
			neighbor.setStatus(MyGraphNode.Status.visited);
		}
		node.setStatus(MyGraphNode.Status.visited);
	}
	
	public void bfsVisitLevelOrder(MyGraphNode node) {
		Queue<MyGraphNode> queue = new LinkedList<>();
		queue.add(node);
		MyGraphNode dummyNode = new MyGraphNode();
		dummyNode.setData(-1);
		dummyNode.setStatus(MyGraphNode.Status.visited);
		queue.add(dummyNode);
		node.setStatus(MyGraphNode.Status.visiting);
		System.out.println("Visiting Nodes ==> ");
		while(!queue.isEmpty()) {			
			MyGraphNode neighbor = queue.poll();
			if(neighbor.getData() == -1) {
				System.out.println("==");
				if(!queue.isEmpty()) {
					queue.add(dummyNode);
				}
				continue;
			}
			System.out.print("==> "+ neighbor.getData());
			for(MyGraphNode neighborChild : neighbor.getNeighbors()) {
				if(neighborChild.getStatus() == MyGraphNode.Status.unvisited) {
					queue.add(neighborChild);
				}				
			}
			
		}
		
	}
	
	public int wordLadder(String start, String end) {
		if(start.equals(end)) return 0;
		Queue<String> queue = new LinkedList<>();
		queue.add(start);
		Map<String, Integer> map = new HashMap<>();		
		map.put(start, 0);
		while(!queue.isEmpty()) {
			String parent = queue.poll();
			if(parent.equals(end)) {
				return map.get(parent);
			}
			List<String> allowedNeigbors = getNeighbors(parent);
			for(String allowedNeigbor : allowedNeigbors) {
				if(!map.containsKey(allowedNeigbor)) {
					map.put(allowedNeigbor, map.get(parent) + 1);
					queue.add(allowedNeigbor);
				}
			}
			
		}		
		return -1;
	}
	
	private List<String> getNeighbors(String word){
		// create pattern and list of words , then add 
		List<String> neighbors = new ArrayList<>();
		for(int i=0; i<word.length(); i++) {
			String pattern = word.substring(0,i) +"*" + word.substring(i+1);
			if(getPatternMap().containsKey(pattern)) {
				neighbors.addAll(getPatternMap().get(pattern));
			}
		}
		return neighbors;
	}
	
	private Map<String, List<String>> patternMapList = null;
	String [] arr = {"hot",  "lot", "dot","dog" , "cog" };
	private List<String> dictionary = Arrays.asList(arr);
	
	
	private Map<String , List<String>> getPatternMap(){
		if(patternMapList == null) {
			patternMapList = new HashMap<>();		
		for(String word : dictionary) {
			for(int i = 0; i< word.length() ; i++) {
				String pattern = word.substring(0, i) + "*" + word.substring(i+1);
				if(!patternMapList.containsKey(pattern)) {
					patternMapList.put(pattern, new ArrayList<>());
				}
				patternMapList.get(pattern).add(word);
			}
		}
		}
		return patternMapList;		
	}

}


class MyGraphNode{	
	
	public enum Status{
		unvisited, visited, visiting
	}
	public MyGraphNode() {
		status = Status.unvisited;
	}
	
	Status status;
	int data;
	List<MyGraphNode> neighbors = new ArrayList<>();
	
	
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public List<MyGraphNode> getNeighbors() {
		return neighbors;
	}
	public void addNeighbor(MyGraphNode node) {
		neighbors.add(node);
	}
}






