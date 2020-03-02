package GFG.graphs;

import java.util.ArrayList;
import java.util.LinkedList;

class Node {

	Integer vertex;
	Integer weight;

	Node(Integer v, Integer w) {
		vertex = v;
		weight = w;

	}
}

public class WeightedGraph implements GraphInterface<Node> {

	// here list is a dynamic array , so the amortized time complexity would be o(1)
	// to insert or remove a node
	LinkedList<Node>[] list;
	// LinkedList<Integer>[] list;
	boolean isDirected = false;

	int v; // no of vertices
	int e; // no of edges

	WeightedGraph(int v, boolean isDirected) {
		this.v = v;
		this.isDirected = isDirected;
		list = new LinkedList[v];
		for (int i = 0; i < v; i++) {
			list[i] = new LinkedList<>();
		}
	}

	@Override
	public LinkedList<Node>[] getArrayList() {
		// TODO Auto-generated method stub
		return list;
	}

	@Override
	public LinkedList<Node> getAllAdjacentVertices(Integer i) {
		return list[i];
	}

	@Override
	public int addEdge(Node i, Node j) {
		if (!isDirected) {
			list[i.vertex].addFirst(j);
			list[j.vertex].addFirst(i);
		} else {
			list[i.vertex].addFirst(j);
		}
		e++;
		return e;
	}

	@Override
	public boolean isAdjacent(Node u, Node v) {
		final LinkedList<Node> ll = list[u.vertex];
		if (ll.indexOf(v) != -1) {
			return true;
		}
		return false;
	}

	@Override
	public int outDegree(Node i) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int inDegree(Node in) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean removeEdge(Node u, Node v) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int addVertex(Node newV) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int removeVertex(Node index) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void printGraph(Graph graph) {
		// TODO Auto-generated method stub

	}

	public void printGraph(WeightedGraph graph, char[] vertex) {
		for (int i = 0; i < v; i++) {
			System.out.println("Adjacency list of vertex " + vertex[i]);
			// System.out.print(" is ");
			for (final Node pCrawl : list[i]) {
				System.out.print(" -" + pCrawl.weight + "-> " + vertex[pCrawl.vertex]);
			}
			System.out.println("\n");
		}

	}

	@Override
	public ArrayList<Node> bfs() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void printGraph(Graph graph, char[] vertex) {
		// TODO Auto-generated method stub

	}

}
