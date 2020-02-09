package leetcode.uber.arraysAndString;

import java.util.Arrays;
import java.util.Scanner;

/*
* Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]*/
public class FirstandLastPositionofElementinSortedArray {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        for(int i =0;i<n;i++){
            a[i] =sc.nextInt();
        }
        int t = sc.nextInt();
      Arrays.stream(searchRange(a,t)).forEach(x-> System.out.println(x+" "));
    }
    /*public static int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        res[0]  =binarySearchFirst(nums, 0, nums.length - 1, target);
        res[1]  =binarySearchLast(nums, 0, nums.length - 1, target);
        return res;
    }

    private static int binarySearchFirst(int[] nums, int i, int j, int target) {
        if (i > j) {
            return -1;
        }
        if (i == j) {
            if (nums[i] == target) {
                return i;
            } else {
                return -1;
            }
        }
        int m = i + (j - i) / 2;
        //if m == target and m-1 is not , then return ,else search in left
        if (m - 1 >= 0 && nums[m] == target && nums[m - 1] != target) {
            //return position
            return m;
        } else if (nums[m] > target || (m - 1 >= 0 && nums[m] == target && nums[m - 1] == target)) {
            //search in left
            return binarySearchFirst(nums, i, m - 1, target);
        } else {
            //search in right part

            return binarySearchFirst(nums, m + 1, j, target);
        }


    }

    private static int binarySearchLast(int[] nums, int i, int j, int target) {
        if (i > j) {
            return -1;
        }
        if (i == j) {
            if (nums[i] == target) {
                return i;
            } else {
                return -1;
            }
        }
        int m = i + (j - i) / 2;
        //if m == target and m+1 is not , then return ,else search in left
        if (nums[m] == target && nums[m + 1] != target) {
            //return position
            return m;
        } else if (nums[m] < target || (nums[m] == target && nums[m + 1] == target)) {
            //search in right
            return binarySearchLast(nums, m + 1, j, target);
        } else {
            //search in left part

            return binarySearchLast(nums, i, m - 1, target);
        }
    }
*/
//The above code is full of bugs
    //better code
        // returns leftmost (or rightmost) index at which `target` should be
        // inserted in sorted array `nums` via binary search.
        private static int extremeInsertionIndex(int[] nums, int target, boolean left) {
            int lo = 0;
            int hi = nums.length;

            while (lo < hi) {
                int mid = lo + (hi - lo )/2;
                if (nums[mid] > target || (left && target == nums[mid])) {
                    hi = mid;
                }
                else {
                    lo = mid+1;
                }
            }

            return lo;
        }

        public static int[] searchRange(int[] nums, int target) {
            int[] targetRange = {-1, -1};

            int leftIdx = extremeInsertionIndex(nums, target, true);

            // assert that `leftIdx` is within the array bounds and that `target`
            // is actually in `nums`.
            if (leftIdx == nums.length || nums[leftIdx] != target) {
                return targetRange;
            }

            targetRange[0] = leftIdx;
            targetRange[1] = extremeInsertionIndex(nums, target, false)-1;

            return targetRange;
        }
    }
