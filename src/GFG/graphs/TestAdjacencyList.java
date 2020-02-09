package graphs;

public class TestAdjacencyList {

	public static void main(String[] args) {
		// insert no of vertices and edges
		// final Scanner sc = new Scanner(System.in);

		final Graph graph = new Graph(5, false);

		// e = sc.nextInt();

		graph.addEdge(0, 1);
		graph.addEdge(0, 4);
		graph.addEdge(1, 2);
		graph.addEdge(1, 3);
		graph.addEdge(1, 4);
		graph.addEdge(2, 3);
		graph.addEdge(3, 4);

		// print the adjacency list representation of
		// the above graph
		graph.printGraph(graph);
	}

}
