package graphs;

import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Prim {
	class MinW {
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getOuterType().hashCode();
			result = prime * result + (vertex == null ? 0 : vertex.hashCode());
			return result;
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

		Integer vertex;
		Integer weight;

		MinW(Integer v, Integer w) {
			vertex = v;
			weight = w;

		}

		private Prim getOuterType() {
			return Prim.this;
		}
	}

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
		minSpanningTree(v, g);
	}

	/**
	 * @param v
	 * @param g
	 */
	private static void minSpanningTree(final int v, final WeightedGraph g) {
		// initialize the vertex array.
		final char vertex[] = new char[] { 'A', 'B', 'C', 'D', 'E', 'F' };
		final PriorityQueue<MinW> pq = new PriorityQueue<>(v, (a, b) -> a.weight - b.weight);
		// initialize pq with a,0 and rest all with infinity weigth.
		final Prim p = new Prim();
		pq.offer(p.new MinW(0, 0));

		// maintain a vertex and edge.
		final HashMap<Integer, Integer[]> veMap = new HashMap<>();

		// maintain a distance table
		final Integer dist[] = new Integer[v];
		Arrays.fill(dist, -1);

		// initialize distance of A from A as 0
		dist[0] = 0;

		while (!pq.isEmpty()) {
			// here it is returning the minimum element i.e min weight
			final MinW ver = pq.poll();

			g.getAllAdjacentVertices(ver.vertex).forEach(x -> {
				// either the adjacent x will already be present in veMap / pq or not. we will
				// handle both cases
				// if x exists in pq, we check if the weight that exists is greater that the
				// current ,if yes then we update the weight in pq
				// and also the veMap
				final Integer newDist = dist[ver.vertex] + x.weight;
				// we need to update the veMap when existing distance of x is -1 or is greater
				// than new distance.

				if (dist[x.vertex] == -1 || dist[x.vertex] > newDist) {
					// update dist of adjacent to the weight of current edge
					dist[x.vertex] = x.weight;
					// update the priority of x.vertex to newDist
					pq.offer(p.new MinW(x.vertex, x.weight));
					// update the veMap
					veMap.put(x.vertex, new Integer[] { ver.vertex, x.vertex });
				}
			});
		}
		for (int i = 0; i < v; i++) {
			System.out.println("distance to " + vertex[i] + " is " + dist[i] + " via edge ");
			if (veMap.get(i) != null) {
				System.out.print(vertex[veMap.get(i)[0]] + "" + vertex[veMap.get(i)[1]]);
			}
			System.out.println();
		}
	}

}
