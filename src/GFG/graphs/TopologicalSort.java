package GFG.graphs;

public class TopologicalSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final Graph graph = new Graph(12, true);

		graph.addEdge(7, 11);
		graph.addEdge(7, 8);
		graph.addEdge(5, 11);
		graph.addEdge(3, 8);
		graph.addEdge(3, 10);
		graph.addEdge(11, 2);
		graph.addEdge(11, 9);
		graph.addEdge(11, 10);
		graph.addEdge(8, 9);

		// print the adjacency list representation of
		// the above graph
		// Graph.printGraph(graph);
		final int[] visited = new int[graph.getV()];
		// call dfs for s =0;
		graph.printGraph(graph);
		// FoodSystem.out.println(Arrays.toString(
		topologicalSort(graph, visited);
		// ));
	}

	private static int[] topologicalSort(Graph graph, int[] visited) {
		// TODO Auto-generated method stub
		final int v = graph.getV();
		for (int i = 0; i < v; i++) {

			if (graph.inDegree(i) == 0 && visited[i] == 0) {
				System.out.println(i);
				visited[i] = 1;
				graph.getAllAdjacentVertices(i).clear();
				topologicalSort(graph, visited);
			}

		}
		return null;
	}

}
