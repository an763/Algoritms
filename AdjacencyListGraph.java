import java.util.LinkedList;
import java.util.List;

public class AdjacencyListGraph {
	
	private int vertices;
	private List<Integer>[] adjacenyList;
	
	public AdjacencyListGraph(int numVert) {
		this.vertices = numVert;
		adjacenyList = (LinkedList<Integer>[])new LinkedList[numVert];
		
		for(int i=0; i<numVert; i++) {
			adjacenyList[i] = new LinkedList<>();
		}		
	}
	
	public void addEdge(int v, int w) {
		adjacenyList[v].add(w);
		adjacenyList[w].add(v);
	}
	
	public List<Integer> getVertices(int v){
		return adjacenyList[v];
	}
	
	public List<Integer>[] getAdjList(){
		return adjacenyList;
	}
		
}
