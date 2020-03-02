package GFG.graphs;

import java.util.Arrays;
import java.util.LinkedList;

public class BFS {

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
		// Graph.printGraph(graph);
		visited = new int[graph.getV()];
		// call dfs for s =0;
		bfs(graph, 0);
	}

	private static void bfs(Graph g, int s) {

		// mark s as visited
		// Create a queue for BFS
		final LinkedList<Integer> queue = new LinkedList<Integer>();
		visited[s] = 1;
		queue.addLast(s);
		int var;
		while (!queue.isEmpty()) {
			// fetch first and add adjacent to queue
			var = queue.pollFirst();
			System.out.println(var);

			g.getAllAdjacentVertices(var).forEach(x -> {
				if (visited[x] == 0) {
					visited[x] = 1;
					queue.addLast(x);
				}
			});
		}
		System.out.println(Arrays.toString(visited));
	}

}
