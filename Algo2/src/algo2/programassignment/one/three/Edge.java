package algo2.programassignment.one.three;

import java.util.ArrayList;
import java.util.List;

public class Edge {
	private int id;
	
	private int weight;
	private List<Node> nodes = new ArrayList<Node>();
	
	public Edge(Node n1, Node n2, int weight, int edgeId){
		nodes.add(n1);
		nodes.add(n2);
		this.weight=weight;
		this.id=edgeId;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public List<Node> getNodes() {
		return nodes;
	}
	public void setNodes(List<Node> nodes) {
		this.nodes = nodes;
	}
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if (obj instanceof Edge){
			if( this.id == ((Edge) obj).getId()){
				return true;
			}
		}
		return false;
	}
	
}

