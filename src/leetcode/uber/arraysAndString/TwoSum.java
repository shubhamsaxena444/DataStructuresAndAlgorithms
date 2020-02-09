package leetcode.uber.arraysAndString;

import java.util.HashMap;
import java.util.Map;

/*
* Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:

Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].*/
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        // use a hashmap to store key, value as number,index and at each number search for (value-x) in the hashmap, if found return
        int[] res = new int[2];
        Map<Integer,Integer> hm = new HashMap<Integer,Integer>();
        for(int i =0;i<nums.length;i++){
            //if found , then return
            int value = target- nums[i];
            if(hm.get(value)!=null){
                res[0] =hm.get(value);
                res[1] =i;
                return res;
            }else{
                hm.put(nums[i],i);
            }
        }
        return res;
    }
}
