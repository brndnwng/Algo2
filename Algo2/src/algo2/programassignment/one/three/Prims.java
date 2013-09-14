package algo2.programassignment.one.three;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Prims {
	
	List<Node> newGraph = new ArrayList<Node>();
	PriorityQueue<Edge> adjacentEdges = new PriorityQueue<Edge>(100, new EdgeComparator());
	List<Edge> mst = new ArrayList<Edge>();
	
	//sort priorityQueue by ascending weight
	public static class EdgeComparator implements Comparator<Edge>{

		@Override
		public int compare(Edge arg0, Edge arg1) {
			// TODO Auto-generated method stub
			if (arg0.getWeight() > arg1.getWeight()){
				return 1;
			}
			else{
				return -1;
			}
		}
		
	}
	/*
	 * pick the first node from graph
	 * add to the list of connected nodes
	 * add all adjacent edges to a priority queue
	 * take the minimum edge
	 * check to see if endpoints of edge are in the list of connected nodes
	 * if one of the nodes is not in that list, add that to the connected nodes list, add all adjacent edges to that new node
	 * repeat until all edges visited
	 * 
	 * TODO: pick a random node, prune the heap for edges which will not result in a non-visited node
	 */
	public void primsAlgo(Graph gr){
		Node n = gr.getNodes().get(0);
		newGraph.add(n);
		for(Edge e : n.getEdges()){
			adjacentEdges.add(e);
		}
		
		while(adjacentEdges.size() >0){
			Edge min = adjacentEdges.poll();
			List<Node> newNodes = min.getNodes();
			for(Node n1 : newNodes){
				if(!newGraph.contains(n1)){
					mst.add(min);
					newGraph.add(n1);
					for(Edge e1 : n1.getEdges()){
						adjacentEdges.add(e1);
					}
				}
			}
		}
		
		//Sum the cost of the MST
		long cost = 0;
		for(Edge e3 : mst){
			cost += e3.getWeight();
		}
		System.out.println("MST Cost: "+cost);
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Graph gr = Graph.makeGraphFromFile("input/edges.txt");
		Prims pr = new Prims();
		pr.primsAlgo(gr);
		System.out.println("DONE");
	}

}
