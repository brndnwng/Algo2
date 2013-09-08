package algo2.programassignment.one.three;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Graph {
	private List<Node> nodes  = new ArrayList<Node>();
	private List<Edge> edges = new ArrayList<Edge>();
	public List<Node> getNodes() {
		return nodes;
	}
	public void setNodes(List<Node> nodes) {
		this.nodes = nodes;
	}
	public List<Edge> getEdges() {
		return edges;
	}
	public void setEdges(List<Edge> edges) {
		this.edges = edges;
	}
	
	private Node addNode(int id){
		Node n = new Node(id);
		int indexOfNode = nodes.indexOf(n);
		if(indexOfNode >-1){
			n = nodes.get(indexOfNode);
		}
		else{
			nodes.add(n);
		}

		return n;
	}
	
	private void addEdge(int n1, int n2, int weight, int edgeId){
		Node nOne= addNode(n1);
		Node nTwo= addNode(n2);
		
		Edge e = new Edge(nOne, nTwo, weight, edgeId);
		
		nOne.addEdge(e);
		nTwo.addEdge(e);
		this.edges.add(e);
	}
	
	public static Graph makeGraphFromFile(String inputFile){
		Graph result = new Graph();
		FileReader fr;
		BufferedReader br;
		try {
			
			fr = new FileReader(inputFile);
			br = new BufferedReader(fr);
			String line;
			line = br.readLine();
			String[] split1 = line.split("(\\s)+");
			List<Node> theNodes = new ArrayList<Node>(Integer.parseInt(split1[0]));
			List<Edge> theEdges = new ArrayList<Edge>(Integer.parseInt(split1[1]));
			int edgeId = 1;
			while ((line = br.readLine()) != null){
				String[] split = line.split("(\\s)+");
				int node1 = Integer.parseInt(split[0]);
				int node2 = Integer.parseInt(split[1]);
				int weight = Integer.parseInt(split[2]);
				result.addEdge(node1,node2,weight, edgeId);
				edgeId++;
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	public static void main(String[] args){
		Graph gr = makeGraphFromFile("input/graph1.txt");
		System.out.println("DONE");
	}
	
}
