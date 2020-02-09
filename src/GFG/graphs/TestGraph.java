package graphs;

public class TestGraph {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final Graph g = new Graph(4, true);
		char vertex[] = new char[] { 'A', 'B', 'C', 'D' };
		g.addEdge(0, 1);
		g.addEdge(1, 2);
		g.addEdge(1, 3);
		g.addEdge(0, 3);
		g.removeEdge(0, 1);
		vertex = new char[] { 'A', 'B', 'C', 'D', 'E' };
		g.addVertex(4);
		g.addEdge(0, 4);
		// vertex = new char[] { 'A', 'B', 'C', 'E' };
		// g.removeVertex(3);
		g.printGraph(g, vertex);
		System.out.println(g.bfs());
	}

}
