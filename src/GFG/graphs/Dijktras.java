package graphs;

import java.util.Arrays;
import java.util.PriorityQueue;

class MinW {
	Integer vertex;
	Integer weight;

	MinW(Integer v, Integer w) {
		vertex = v;
		weight = w;

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + getOuterType().hashCode();
		result = prime * result + (vertex == null ? 0 : vertex.hashCode());
		return result;
	}

	private Object getOuterType() {
		return this;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final MinW other = (MinW) obj;
		if (!getOuterType().equals(other.getOuterType())) {
			return false;
		}
		if (vertex == null) {
			if (other.vertex != null) {
				return false;
			}
		} else if (!vertex.equals(other.vertex)) {
			return false;
		}
		return true;
	}
}

public class Dijktras {

	public static void main(String[] args) {
		final int v = 6;
		final WeightedGraph g = new WeightedGraph(v, false);
		// initialize the vertex array.
		final char vertex[] = new char[] { 'A', 'B', 'C', 'D', 'E', 'F' };
		// enter the weighted eges.
		g.addEdge(new Node(0, 5), new Node(1, 5));
		g.addEdge(new Node(0, 2), new Node(4, 2));
		g.addEdge(new Node(0, 9), new Node(3, 9));
		g.addEdge(new Node(1, 2), new Node(2, 2));
		g.addEdge(new Node(4, 3), new Node(5, 3));
		g.addEdge(new Node(2, 3), new Node(3, 3));
		g.addEdge(new Node(3, 2), new Node(5, 2));
		g.printGraph(g, vertex);
		singleSourceShortestPath(v, g);
	}

	/**
	 * @param v
	 * @param g
	 */
	private static void singleSourceShortestPath(final int v, final WeightedGraph g) {
		// initialize the vertex array.
		final char vertex[] = new char[] { 'A', 'B', 'C', 'D', 'E', 'F' };
		final PriorityQueue<MinW> pq = new PriorityQueue<>(v, (a, b) -> a.weight - b.weight);
		// initialize pq with a,0 and rest all with infinity weigth.
		pq.offer(new MinW(0, 0));
		// maintain a parent array and a distance array.
		final Integer[] parent = new Integer[v];
		final int dist[] = new int[v];
		Arrays.fill(dist, -1);
		Arrays.fill(parent, -1);
		// update distance of source from source to 0
		dist[0] = 0;
		while (!pq.isEmpty()) {
			// here it is not returning the minimum element
			final MinW ver = pq.poll();

			g.getAllAdjacentVertices(ver.vertex).forEach(x -> {

				final Integer newDist = dist[ver.vertex] + x.weight;
				if (dist[x.vertex] == -1 || dist[x.vertex] > newDist) {
					// update dist of adjacent
					dist[x.vertex] = newDist;
					// update the priority of x.vertex to newDist
					pq.offer(new MinW(x.vertex, newDist));
					// update(pq, x.vertex, newDist);
					// update the parent of x
					parent[x.vertex] = ver.vertex;

				}
			});
		}
		for (int i = 0; i < v; i++) {
			System.out.println("distance to " + vertex[i] + " is " + dist[i] + " via ");
			int j = i;
			while (parent[j] != -1) {
				System.out.print(vertex[parent[j]] + ",");
				j = parent[j];
			}
			System.out.println();
		}
		// System.out.println(Arrays.toString(dist));
	}

	@Deprecated
	private static void update(PriorityQueue<MinW> pq, Integer vertex, Integer newDist) {
		MinW tmp = null;
		for (final MinW x : pq) {
			if (x.vertex == vertex) {
				tmp = x;
				pq.remove(x);
				break;
			}

		}
		if (tmp != null) {
			tmp.weight = newDist;
		}
		pq.offer(tmp);
	}

}
