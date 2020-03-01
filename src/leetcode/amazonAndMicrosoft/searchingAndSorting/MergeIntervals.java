package leetcode.amazonAndMicrosoft.searchingAndSorting;

public class MergeIntervals {
    /*Approach 2: Sorting
Intuition

If we sort the intervals by their start value, then each set of intervals that can be merged will appear as a contiguous "run" in the sorted list.

Algorithm

First, we sort the list as described. Then, we insert the first interval into our merged list and continue considering each interval in turn as follows: If the current interval begins after the previous interval ends, then they do not overlap and we can append the current interval to merged. Otherwise, they do overlap, and we merge them by updating the end of the previous interval if it is less than the end of the current interval.

A simple proof by contradiction shows that this algorithm always produces the correct answer. First, suppose that the algorithm at some point fails to merge two intervals that should be merged. This would imply that there exists some triple of indices ii, jj, and kk in a list of intervals \text{ints}ints such that i < j < ki<j<k and (\text{ints[i]}ints[i], \text{ints[k]}ints[k]) can be merged, but neither (\text{ints[i]}ints[i], \text{ints[j]}ints[j]) nor (\text{ints[j]}ints[j], \text{ints[k]}ints[k]) can be merged. From this scenario follow several inequalities:

\begin{aligned} \text{ints[i].end} < \text{ints[j].start} \\ \text{ints[j].end} < \text{ints[k].start} \\ \text{ints[i].end} \geq \text{ints[k].start} \\ \end{aligned}
ints[i].end<ints[j].start
ints[j].end<ints[k].start
ints[i].end≥ints[k].start
​


We can chain these inequalities (along with the following inequality, implied by the well-formedness of the intervals: \text{ints[j].start} \leq \text{ints[j].end}ints[j].start≤ints[j].end) to demonstrate a contradiction:

\begin{aligned} \text{ints[i].end} < \text{ints[j].start} \leq \text{ints[j].end} < \text{ints[k].start} \\ \text{ints[i].end} \geq \text{ints[k].start} \end{aligned}
ints[i].end<ints[j].start≤ints[j].end<ints[k].start
ints[i].end≥ints[k].start
​


Therefore, all mergeable intervals must occur in a contiguous run of the sorted list.

Sorting Example

Consider the example above, where the intervals are sorted, and then all mergeable intervals form contiguous blocks.


Complexity Analysis

Time complexity : O(n\log{}n)O(nlogn)

Other than the sort invocation, we do a simple linear scan of the list, so the runtime is dominated by the O(nlgn)O(nlgn) complexity of sorting.

Space complexity : O(1)O(1) (or O(n)O(n))

If we can sort intervals in place, we do not need more than constant additional space. Otherwise, we must allocate linear space to store a copy of intervals and sort that.

*/
}
