package leetcode.amazon.arraysAndString;
/*Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:

Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].*/

import java.util.*;

public class Twosum {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        int r[] = new int[2];
        for(int i =0;i<nums.length;i++){
            //find if target-nums[i] exists in hm
            if(hm.containsKey(target-nums[i])){
                r[0] = hm.get(target-nums[i]);
                r[1] = i;

            }
            hm.put(nums[i],i);

        }

        return r;
    }
}
