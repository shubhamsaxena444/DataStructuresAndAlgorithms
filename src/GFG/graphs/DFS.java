package graphs;

public class DFS {
	static int visited[];

	public static void main(String[] args) {
		final Graph graph = new Graph(5, false);

		graph.addEdge(0, 1);
		graph.addEdge(0, 4);
		graph.addEdge(1, 2);
		graph.addEdge(1, 3);
		graph.addEdge(1, 4);
		graph.addEdge(2, 3);
		graph.addEdge(3, 4);

		// print the adjacency list representation of
		// the above graph
		visited = new int[graph.getV()];
		// call dfs for s =0;
		dfs(graph, 0);
	}

	private static void dfs(Graph g, int s) {

		// mark s as visited
		visited[s] = 1;

		// System.out.println(Arrays.toString(visited));
		System.out.println(s);
		// see if there is any adjacent of s which is unvisited.
		// for (int i = 0; i < Graph.v; i++) {
		// if (AdjacencyList.adjacent(s, i) && !visited[i]) {
		// dfs(g, i);
		// }
		// }

		// iterate over g.list
		g.getAllAdjacentVertices(s).forEach(x -> {
			if (visited[x] == 0) {
				dfs(g, x);
			}
		});
	}

}
