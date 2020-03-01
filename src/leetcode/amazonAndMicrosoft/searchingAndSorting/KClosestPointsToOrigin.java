package leetcode.amazonAndMicrosoft.searchingAndSorting;

import java.util.Arrays;

/*We have a list of points on the plane.  Find the K closest points to the origin (0, 0).

(Here, the distance between two points on a plane is the Euclidean distance.)

You may return the answer in any order.  The answer is guaranteed to be unique (except for the order that it is in.)



Example 1:

Input: points = [[1,3],[-2,2]], K = 1
Output: [[-2,2]]
Explanation:
The distance between (1, 3) and the origin is sqrt(10).
The distance between (-2, 2) and the origin is sqrt(8).
Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
We only want the closest K = 1 points from the origin, so the answer is just [[-2,2]].
Example 2:

Input: points = [[3,3],[5,-1],[-2,4]], K = 2
Output: [[3,3],[-2,4]]
(The answer [[-2,4],[3,3]] would also be accepted.)


Note:

1 <= K <= points.length <= 10000
-10000 < points[i][0] < 10000
-10000 < points[i][1] < 10000*/
public class KClosestPointsToOrigin {
    public int[][] kClosest(int[][] points, int K) {
        int N = points.length;
        int[] dists = new int[N];
        for (int i = 0; i < N; ++i)
            dists[i] = dist(points[i]);

        Arrays.sort(dists);
        int distK = dists[K-1];

        int[][] ans = new int[K][2];
        int t = 0;
        for (int i = 0; i < N; ++i)
            if (dist(points[i]) <= distK)
                ans[t++] = points[i];
        return ans;
    }

    public int dist(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }


    /*O(n)
    * Approach 2: Divide and Conquer
Intuition

We want an algorithm faster than N \log NNlogN. Clearly, the only way to do this is to use the fact that the K elements returned can be in any order -- otherwise we would be sorting which is at least N \log NNlogN.

Say we choose some random element x = A[i] and split the array into two buckets: one bucket of all the elements less than x, and another bucket of all the elements greater than or equal to x. This is known as "quickselecting by a pivot x".

The idea is that if we quickselect by some pivot, on average in linear time we'll reduce the problem to a problem of half the size.

Algorithm

Let's do the work(i, j, K) of partially sorting the subarray (points[i], points[i+1], ..., points[j]) so that the smallest K elements of this subarray occur in the first K positions (i, i+1, ..., i+K-1).

First, we quickselect by a random pivot element from the subarray. To do this in place, we have two pointers i and j, and move these pointers to the elements that are in the wrong bucket -- then, we swap these elements.

After, we have two buckets [oi, i] and [i+1, oj], where (oi, oj) are the original (i, j) values when calling work(i, j, K). Say the first bucket has 10 items and the second bucket has 15 items. If we were trying to partially sort say, K = 5 items, then we only need to partially sort the first bucket: work(oi, i, 5). Otherwise, if we were trying to partially sort say, K = 17 items, then the first 10 items are already partially sorted, and we only need to partially sort the next 7 items: work(i+1, oj, 7).*/
}
