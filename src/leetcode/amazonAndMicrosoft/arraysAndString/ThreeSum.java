package leetcode.amazonAndMicrosoft.arraysAndString;
/*Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note:

The solution set must not contain duplicate triplets.

Example:

Given array nums = [-1, 0, 1, 2, -1, -4],

A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]*/
import java.util.*;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                // ## find pair without duplicate, that adds upto target -nums[i]
                int ii = i + 1;
                int jj = nums.length - 1;
                int target = -nums[i];
                while (ii < jj) {
                    int sum = nums[ii] + nums[jj];
                    if (sum == target) {
                        list.add(Arrays.asList(nums[i], nums[ii], nums[jj]));
                        // skip duplicates
                        while (ii < jj && nums[ii] == nums[ii + 1]) ii++;
                        while (ii < jj && nums[jj] == nums[jj - 1]) jj--;
                        ii++;
                        jj--;
                    } else if (sum < target) {
                        ii++;
                    } else {
                        jj--;
                    }
                }
            }
        }
        return list;
    }
}
