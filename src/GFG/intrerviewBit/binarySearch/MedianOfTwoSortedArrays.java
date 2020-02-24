package GFG.intrerviewBit.binarySearch;
import java.util.*;
/*
There are two sorted arrays A and B of size m and n respectively.

Find the median of the two sorted arrays ( The median of the array formed by merging both the arrays ).

The overall run time complexity should be O(log (m+n)).

Sample Input

A : [1 4 5]
B : [2 3]

Sample Output

3
 NOTE: IF the number of elements in the merged array is even, then the median is the average of n / 2 th and n/2 + 1th element.
* */
public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(final List<Integer> A, final List<Integer> B) {
        int len = A.size() + B.size();
        //if odd length
        if(len % 2 == 1) return findKth(A, 0, B, 0, len / 2 + 1);
        //if even length
        else return (findKth(A, 0, B, 0, len / 2) + findKth(A, 0, B, 0, len / 2 + 1)) / 2.0;
    }

    public int findKth(List<Integer> A, int A_start, List<Integer> B, int B_start, int k){
        //if not in a, find kth element in b
        if(A_start >= A.size()) return B.get(B_start + k - 1);
        //if not in b, find kth element in a
        if(B_start >= B.size()) return A.get(A_start + k - 1);
        //if k==1, return min of a, and b
        if(k == 1) return Math.min(A.get(A_start), B.get(B_start));

        int A_mid = A_start + k / 2 - 1 < A.size() ? A.get(A_start + k / 2 - 1) : Integer.MAX_VALUE;
        int B_mid = B_start + k / 2 - 1 < B.size() ? B.get(B_start + k / 2 - 1) : Integer.MAX_VALUE;

        if(A_mid < B_mid){
            // element does not exist in first half of a
            return findKth(A, A_start + k / 2, B, B_start, k - k / 2);
        }
        else
            // element does not exist in first half of b
            return findKth(A, A_start, B, B_start + k / 2, k - k / 2);
    }
}
