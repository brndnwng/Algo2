package algo2.programassignment.one.three;

import java.util.ArrayList;
import java.util.List;

public class Node {
	private int id;
	List<Edge> edges = new ArrayList<Edge>();
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public List<Edge> getEdges() {
		return edges;
	}
	public void setEdges(List<Edge> edges) {
		this.edges = edges;
	}
	
	public Node(int id){
		this.id=id;
	}
	
	public void addEdge(Edge e){
		edges.add(e);
	}
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if (obj instanceof Node){
			if( this.id == ((Node) obj).getId()){
				return true;
			}
		}
		return false;
	}
	
	
}
