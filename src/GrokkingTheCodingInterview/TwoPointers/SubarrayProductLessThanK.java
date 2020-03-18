package GrokkingTheCodingInterview.TwoPointers;

import java.util.*;

/*Problem Statement #
Given an array with positive numbers and a target number, find all of its contiguous subarrays whose product is less than the target number.

Example 1:

Input: [2, 5, 3, 10], target=30
Output: [2], [5], [2, 5], [3], [5, 3], [10]
Explanation: There are six contiguous subarrays whose product is less than the target.
Example 2:

Input: [8, 2, 6, 5], target=50
Output: [8], [2], [8, 2], [6], [2, 6], [5], [6, 5]
Explanation: There are seven contiguous subarrays whose product is less than the target.
Try it yourself #
Try solving this question here:

Java
Python3
JS
C++
1234567891011
import java.util.*;

class SubarrayProductLessThanK {

  public static List<List<Integer>> findSubarrays(int[] arr, int target) {
    List<List<Integer>> subarrays = new ArrayList<>();
    // TODO: Write your code here
    return subarrays;
  }
}


TEST
SAVERESET
Solution #
This problem follows the Sliding Window and the Two Pointers pattern and shares similarities with Triplets with Smaller Sum with two differences:

In this problem, the input array is not sorted.
Instead of finding triplets with sum less than a target, we need to find all subarrays having a product less than the target.
The implementation will be quite similar to Triplets with Smaller Sum.

Code #
Here is what our algorithm will look like:*/
public class SubarrayProductLessThanK {


    public static List<List<Integer>> findSubarrays(int[] arr, int target) {
        List<List<Integer>> result = new ArrayList<>();
        int product = 1, left = 0;
        for (int right = 0; right < arr.length; right++) {
            product *= arr[right];
            while (product >= target && left < arr.length)
                product /= arr[left++];
            // since the product of all numbers from left to right is less than the target therefore,
            // all subarrays from lef to right will have a product less than the target too; to avoid
            // duplicates, we will start with a subarray containing only arr[right] and then extend it
            List<Integer> tempList = new LinkedList<>();
            for (int i = right; i >= left; i--) {
                tempList.add(0, arr[i]);
                result.add(new ArrayList<>(tempList));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(SubarrayProductLessThanK.findSubarrays(new int[] { 2, 5, 3, 10 }, 30));
        System.out.println(SubarrayProductLessThanK.findSubarrays(new int[] { 8, 2, 6, 5 }, 50));
    }
}
/*Time complexity #
The main for-loop managing the sliding window takes O(N)O(N) but creating subarrays can take up to O(N^2)O(N
​2
​​ ) in the worst case. Therefore overall, our algorithm will take O(N^3)O(N
​3
​​ ).

Space complexity #
Ignoring the space required for the output list, the algorithm runs in O(N)O(N) space which is used for the temp list.

Can you try estimating how much space will be required for the output list?

Hide Hint
The worst case will happen when every subarray has a product less than the target!

So the question will be, how many contiguous subarray an array can have?

It is definately not all Permutations of the given array, is it all Combinations of the given array?*/