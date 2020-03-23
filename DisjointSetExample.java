import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DisjointSetExample {
	
	int vertices;
	int edges;
	Edges[] edge;
	
	
	public DisjointSetExample(int vert, int edg) {
		vertices = vert;
		edges = edg;
		edge = new Edges[edges];
		for(int i=0; i<edges ; i++) {
			edge[i]= new Edges();
		}
	
	}
	
	class Edges{
		int source;
		int destination;
	}
	
	int find(int [] sub, int x){
		if(sub[x] == -1) {
			return x; // indication that this is the parent
		}else {
			return find(sub,sub[x]); // keep finding until you get parent as -1
		}
		
	}
	
	int findUsingMap(Map<Integer,Integer> subset, int key) {
		if(subset.get(key) == -1) {
			return key;
		}else {
			return findUsingMap(subset,subset.get(key));
		}		
	}
	
	void unionUsingMap(Map<Integer,Integer> map, int x, int y) {
		int xset = findUsingMap(map,x);
		int yset = findUsingMap(map,y);		
		map.put(xset, yset);
	}
	
	boolean hasCycleUsingMap(DisjointSetExample graph) {
		Map<Integer , Integer> subset = new HashMap<>();
		
		// populate initial map with -1 as value.
		for(int i=0; i<vertices;i++) {
			subset.put(i, -1);
		}
		
		for(int i =0; i<edges; i++) {
			if(findUsingMap(subset,graph.edge[i].source) == findUsingMap(subset,graph.edge[i].destination)) {
				return true;
			}else {
				unionUsingMap(subset, graph.edge[i].source, graph.edge[i].destination);
			}
		}
		
		return false;
	}
	
	void union(int[] sub, int x, int y) {
		int xset = find(sub,x); // this is to make sure if x is member of subset, then get its parent.
		int yset = find(sub,y); // this is to make sure if x is member of subset, then get its parent.
		sub[xset] = yset; // make the union of two nodes. 
	}
	
	boolean hasCycle(DisjointSetExample graph) {
		// form the subsets...
		int [] subsets = new int[vertices];
		// initialise the subsets
		for(int i=0; i<vertices; i++) {
			subsets[i]=-1;
		}
		// now take the edges and found if they belong to same subset
		
		for(int i =0; i<edges; i++) {
			int x = graph.edge[i].source;
			int y = graph.edge[i].destination;
			if(find(subsets, x) == find(subsets, y)) {
				return true;
			}else {
				union(subsets, x,y);
			}
		}		
		return false;
	}
	
	boolean hasCycleUsingSet(DisjointSetExample graph) {
		Set<Integer> subset = new HashSet<>();
		boolean sourceExists = true;
		boolean destExists = true;
		// take the edges, and get the vertices, check if they exists in Set, 
		//if both exists, there is cycle..simple
		
		for(int i=0; i<edges; i++ ) {
			if(!subset.contains(graph.edge[i].source)) {
				subset.add(graph.edge[i].source);
				sourceExists = false;
			}
			if(!subset.contains(graph.edge[i].destination)) {
				subset.add(graph.edge[i].destination);
				destExists = false;
			}
			if(sourceExists && destExists) {
				return true;
			}
			sourceExists = true;
			destExists = true;
		}
		
		return false;
	}
		
	
	public static void main(String args[]) {
		// form the graph
		DisjointSetExample graph =new  DisjointSetExample(5,5);
		graph.edge[0].source = 0;
		graph.edge[0].destination = 1;
		
		graph.edge[1].source = 1;
		graph.edge[1].destination = 2;
		
		graph.edge[2].source = 0;
		graph.edge[2].destination = 3;
		
		graph.edge[3].source = 3;
		graph.edge[3].destination = 4;
		
		
		  graph.edge[4].source = 0; 
		  graph.edge[4].destination = 2;
		 
		
		if (graph.hasCycle(graph)) 
			System.out.println( "graph contains cycle" ); 
		else
			System.out.println( "graph doesn't contain cycle" ); 
		
		if (graph.hasCycleUsingSet(graph)) 
			System.out.println( "Using Set graph contains cycle" ); 
		else
			System.out.println( "Using Set  graph doesn't contain cycle" ); 
		
		if (graph.hasCycleUsingMap(graph)) 
			System.out.println( "Using Map graph contains cycle" ); 
		else
			System.out.println( "Using Map  graph doesn't contain cycle" ); 
	}
	
	

}
