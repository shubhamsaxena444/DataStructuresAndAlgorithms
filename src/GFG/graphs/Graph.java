/**
 * 
 */
package graphs;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author batman
 *
 */
// we create this graph keeping in mind that we can always get the actual elemtn
// from vertex list using indices
public class Graph implements GraphInterface<Integer> {
	// here list is a dynamic array , so the amortized time complexity would be o(1)
	// to insert or remove a node
	LinkedList<Integer>[] list;
	boolean isDirected = false;

	int v; // no of vertices
	int e; // no of edges

	Graph(int v, boolean isDirected) {
		this.v = v;
		this.isDirected = isDirected;
		list = new LinkedList[v];
		for (int i = 0; i < v; i++) {
			list[i] = new LinkedList<>();
		}
	}

	@Override
	public LinkedList<Integer>[] getArrayList() {
		return list;
	}

	@Override
	public LinkedList<Integer> getAllAdjacentVertices(Integer i) {
		return list[i];
	}

	public int getV() {
		return v;
	}

	public void setV(int v) {
		this.v = v;
	}

	public int getE() {
		return e;
	}

	public void setE(int e) {
		this.e = e;
	}

	// here u and v are the indices of v[u] and v[v]. It returns true if v is the
	// adjacent of u
	@Override
	public boolean isAdjacent(Integer u, Integer v) {
		final LinkedList<Integer> ll = list[u];
		if (ll.indexOf(v) != -1) {
			return true;
		}
		return false;
	}

	@Override
	public int outDegree(Integer i) {
		return list[i].size();
	}

	@Override
	public int inDegree(Integer in) {
		int count = 0;
		for (int i = 0; i < v; i++) {
			if (list[i].contains(in)) {
				count++;
			}
		}
		return count;
	}

	// return the total number of edges. here i and j are the indices of v[i] and
	// v[j] O(1)
	@Override
	public int addEdge(Integer i, Integer j) {
		if (!isDirected) {
			list[i].addFirst(j);
			list[j].addFirst(i);
		} else {
			list[i].addFirst(j);
		}
		e++;
		return e;
	}

	// this method removes undirected edge from u to v and returns true if removed
	// else false. O(V)
	@Override
	public boolean removeEdge(Integer u, Integer v) {
		boolean deleted = false;
		if (!isDirected) {
			deleted = list[u].remove(v) && list[v].remove(u);
		} else {
			deleted = list[u].remove(v);
		}
		if (deleted) {
			e--;
		}
		return deleted;
	}

	// Returns the total number of verteces here newV is the index of newly added
	// vertex (basically the last index)
	@Override
	public int addVertex(Integer newV) {
		// if the array size is full, then create a new array,copy all the elements of
		// old array, of double the size and insert v
		if (list.length == v) {
			final LinkedList<Integer> tmp[] = list;
			list = new LinkedList[2 * v];
			// list = tmp; // this line doenot work since list size has become 4 again
			// because it has started poining to tmp
			for (int i = 0; i < v; i++) {
				list[i] = tmp[i];
			}
			list[v] = new LinkedList<>();

		} else {
			// else the array size was already big enough,then just insert the element
			list[v] = new LinkedList<>();
		}
		v++;
		return v;
	}

	// Returns the total number of vertices. here index is the index of
	// vertex to be removed O(v).Currently removes the edges from and to this index
	// ,but keeps the vertex
	@Override
	public int removeVertex(Integer index) {
		// if the array size is less than half then reduce the size by half, copy all
		// the elements of
		// old array,and remove index
		if (index < 0 || index >= v) {
			return v;
		}
		// we also need to remove edge from vertices whose adjacent is index
		for (int i = 0; i < v; i++) {
			removeEdge(i, index);
		}
		// also remove all the adjecents of index.
		list[index].clear();
		// since all the edges have been removed
		// left shift all the elements from i = index+1 to v
		// for (int i = index + 1; i < v; i++) {
		// //also decreament the position of element stored in list
		// list[i - 1] = list[i];
		// }
		// v--;
		return v;
	}

	@Override
	public void printGraph(Graph graph) {
		for (int v = 0; v < graph.getV(); v++) {
			System.out.println("Adjacency list of vertex " + v);
			System.out.print("head");
			for (final Integer pCrawl : list[v]) {
				System.out.print(" -> " + pCrawl);
			}
			System.out.println("\n");
		}
	}

	@Override
	public void printGraph(Graph graph, char[] vertex) {
		for (int i = 0; i < v; i++) {
			System.out.println("Adjacency list of vertex " + vertex[i]);
			// System.out.print(" is ");
			for (final Integer pCrawl : list[i]) {
				System.out.print(" -> " + vertex[pCrawl]);
			}
			System.out.println("\n");
		}

	}

	// returns the array of vertices
	@Override
	public ArrayList<Integer> bfs() {
		final int[] visited = new int[v];
		final ArrayList<Integer> r = new ArrayList<>();
		// call dfs for s =0;
		// but for unconnected graph and directed graph , we need this
		for (Integer s = 0; s < v; s++) {
			{
				r.addAll(bfsUtil(this, s, visited));
			}
		}
		return r;
	}

	private ArrayList<Integer> bfsUtil(Graph g, Integer s, int[] visited) {
		// mark s as visited
		final ArrayList<Integer> res = new ArrayList<>();
		// Create a queue for BFS
		final LinkedList<Integer> queue = new LinkedList<Integer>();
		if (visited[s] == 0) {
			visited[s] = 1;
			queue.addLast(s);
		}
		int var;
		while (!queue.isEmpty()) {
			// fetch first and add adjacent to queue
			var = queue.pollFirst();
			res.add(var);
			// System.out.println(var);

			g.getAllAdjacentVertices(var).forEach(x -> {
				if (visited[x] == 0) {
					visited[x] = 1;
					queue.addLast(x);
				}
			});
		}
		return res;
	}

}
