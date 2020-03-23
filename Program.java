import java.util.ArrayList;
import java.util.HashSet;

class Program {
  // Do not edit the class below except
  // for the breadthFirstSearch method.
  // Feel free to add new properties
  // and methods to the class.
  static class Node{
    String name;
    ArrayList<Node> children = new ArrayList<Node>();

    public Node(String name) {
      this.name = name;
    }

    public ArrayList<String> depthFirstSearch(ArrayList<String> array,Node node) {
        if(node == null) return array;
  			  array.add(node.name);
  			  if(!node.children.isEmpty()){
  					 for(Node child : node.children){
  						depthFirstSearch(array,child);
  					 }
  				}
  			  return array;
      }
		
		public void helper(Node node, HashSet visited, ArrayList<String> array){
			  if(node == null) return ;
			  visited.add(node);
			  array.add(node.name);
			  if(!node.children.isEmpty()){
					 for(Node child : node.children){
						 if(visited.contains(child)){
							 continue;
						 }
						 helper(child,visited,array);
					 }
				}
		}
		

    public Node addChild(String name) {
      Node child = new Node(name);
      children.add(child);
      return this;
    }
  }
}