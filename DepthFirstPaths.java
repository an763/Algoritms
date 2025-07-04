
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
	
	////////////////////////////////////////
	 public int maxProfit(int[] prices) {
	        int max_profit = 0;
	        int min_price = prices[0];         

	        for(int i = 1; i<prices.length; i++){
	             min_price = Math.min(min_price, prices[i]);
	             max_profit = Math.max( max_profit , maxProfitSingle(prices,0,i ) + maxProfitSingle(prices, i+1,prices.length-1)) ;              
	             i++;
	         }
	         if(max_profit <= 0) return 0;
	         return max_profit;
	    }

	    public int maxProfitSingle(int[] prices, int startIndex, int endIndex) {
	        if(startIndex >= endIndex) return 0;
	        int max_profit = 0;
	        int min_price = prices[startIndex];
	        int i=startIndex + 1;         

	         for(int j = i; j<= endIndex; j++){
	             min_price = Math.min(min_price, prices[j]);
	             max_profit = Math.max(prices[j] - min_price , max_profit);             
	         }
	         if(max_profit <= 0) return 0;
	         return max_profit;
	    }
	    //////////////////////////////////

}
