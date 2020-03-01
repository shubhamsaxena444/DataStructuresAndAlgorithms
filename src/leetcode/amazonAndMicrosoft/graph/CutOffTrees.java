package leetcode.amazonAndMicrosoft.graph;
/*You are asked to cut off trees in a forest for a golf event. The forest is represented as a non-negative 2D map, in this map:

0 represents the obstacle can't be reached.
1 represents the ground can be walked through.
The place with number bigger than 1 represents a tree can be walked through, and this positive number represents the tree's height.


You are asked to cut off all the trees in this forest in the order of tree's height - always cut off the tree with lowest height first. And after cutting, the original place has the tree will become a grass (value 1).

You will start from the point (0, 0) and you should output the minimum steps you need to walk to cut off all the trees. If you can't cut off all the trees, output -1 in that situation.

You are guaranteed that no two trees have the same height and there is at least one tree needs to be cut off.*/
public class CutOffTrees {
    /*
    Starting from (0, 0), for each tree in height order, we will calculate the distance from where we are to the next tree (and move there), adding that distance to the answer.

We frame the problem as providing some distance function dist(forest, sr, sc, tr, tc) that calculates the path distance from source (sr, sc) to target (tr, tc) through obstacles dist[i][j] == 0. (This distance function will return -1 if the path is impossible.)

What follows is code and complexity analysis that is common to all three approaches. After, the algorithms presented in our approaches will focus on only providing our dist function.

Python

class Solution(object):
    def cutOffTree(self, forest):
        trees = sorted((v, r, c) for r, row in enumerate(forest)
                       for c, v in enumerate(row) if v > 1)
        sr = sc = ans = 0
        for _, tr, tc in trees:
            d = dist(forest, sr, sc, tr, tc)
            if d < 0: return -1
            ans += d
            sr, sc = tr, tc
        return ans
Java

class Solution {
    int[] dr = {-1, 1, 0, 0};
    int[] dc = {0, 0, -1, 1};

    public int cutOffTree(List<List<Integer>> forest) {
        List<int[]> trees = new ArrayList();
        for (int r = 0; r < forest.size(); ++r) {
            for (int c = 0; c < forest.get(0).size(); ++c) {
                int v = forest.get(r).get(c);
                if (v > 1) trees.add(new int[]{v, r, c});
            }
        }

        Collections.sort(trees, (a, b) -> Integer.compare(a[0], b[0]));

        int ans = 0, sr = 0, sc = 0;
        for (int[] tree: trees) {
            int d = dist(forest, sr, sc, tree[1], tree[2]);
            if (d < 0) return -1;
            ans += d;
            sr = tree[1]; sc = tree[2];
        }
        return ans;
    }
}
Complexity Analysis

All three algorithms have similar worst case complexities, but in practice each successive algorithm presented performs faster on random data.

Time Complexity: O((RC)^2)O((RC)
2
 ) where there are RR rows and CC columns in the given forest. We walk to R*CR∗C trees, and each walk could spend O(R*C)O(R∗C) time searching for the tree.

Space Complexity: O(R*C)O(R∗C), the maximum size of the data structures used.

Approach #1: BFS [Accepted]
Intuition and Algorithm

We perform a breadth-first-search, processing nodes (grid positions) in a queue. seen keeps track of nodes that have already been added to the queue at some point - those nodes will be already processed or are in the queue awaiting processing.

For each node that is next to be processed, we look at it's neighbors. If they are in the forest (grid), they haven't been enqueued, and they aren't an obstacle, we will enqueue that neighbor.

We also keep a side count of the distance travelled for each node. If the node we are processing is our destination 'target' (tr, tc), we'll return the answer.

Python

def bfs(forest, sr, sc, tr, tc):
    R, C = len(forest), len(forest[0])
    queue = collections.deque([(sr, sc, 0)])
    seen = {(sr, sc)}
    while queue:
        r, c, d = queue.popleft()
        if r == tr and c == tc:
            return d
        for nr, nc in ((r-1, c), (r+1, c), (r, c-1), (r, c+1)):
            if (0 <= nr < R and 0 <= nc < C and
                    (nr, nc) not in seen and forest[nr][nc]):
                seen.add((nr, nc))
                queue.append((nr, nc, d+1))
    return -1
Java

public int bfs(List<List<Integer>> forest, int sr, int sc, int tr, int tc) {
    int R = forest.size(), C = forest.get(0).size();
    Queue<int[]> queue = new LinkedList();
    queue.add(new int[]{sr, sc, 0});
    boolean[][] seen = new boolean[R][C];
    seen[sr][sc] = true;
    while (!queue.isEmpty()) {
        int[] cur = queue.poll();
        if (cur[0] == tr && cur[1] == tc) return cur[2];
        for (int di = 0; di < 4; ++di) {
            int r = cur[0] + dr[di];
            int c = cur[1] + dc[di];
            if (0 <= r && r < R && 0 <= c && c < C &&
                    !seen[r][c] && forest.get(r).get(c) > 0) {
                seen[r][c] = true;
                queue.add(new int[]{r, c, cur[2]+1});
            }
        }
    }
    return -1;
}
    * */
}
