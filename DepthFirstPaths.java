
public class DepthFirstPaths {
	
	private boolean marked[];
	private int edgeTo[];
	private int source;
	private AdjacencyListGraph graph;
	
	public DepthFirstPaths(AdjacencyListGraph graph,int source) {
		this.graph = graph;
		this.source = source;
		edgeTo = new int[graph.getAdjList().length];
		marked = new boolean[graph.getAdjList().length];
		dfs(graph,source);
	}
	
	private void dfs(AdjacencyListGraph graph,int v) {
		marked[v] = true;
		for(int w:graph.getVertices(v)) {
			if(!marked[w]) {
				dfs(graph,w);
				edgeTo[w] = v;
			}
		}		
	}	 
	
	public boolean hasPathDFS(int destination) {
		return marked[destination];
	}

}
