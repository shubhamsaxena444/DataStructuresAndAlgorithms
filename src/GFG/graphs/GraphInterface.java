package GFG.graphs;

import java.util.ArrayList;
import java.util.LinkedList;

public interface GraphInterface<T> {
	// this method returns the entire array of linked list in which the gaph is
	// stored
	LinkedList<T>[] getArrayList();

	// this method returns the linkedlist which represents all the adjacent elements
	// of the vertex stored at index i of vertex array
	LinkedList<T> getAllAdjacentVertices(Integer i);

	// this method adds an edge between vertex stored at index i and j.
	int addEdge(T i, T j);

	// this methood returns true if there exists a path from v[u] to v[v]
	boolean isAdjacent(T u, T v);

	int outDegree(T i);

	int inDegree(T in);

	// this method removes the edge from u to v
	boolean removeEdge(T u, T v);

	int addVertex(T newV);

	int removeVertex(T index);

	void printGraph(Graph graph);

	void printGraph(Graph graph, char vertex[]);

	ArrayList<T> bfs();

}
