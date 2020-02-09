package GFG.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {


    public static int[] twoSum(int[] nums, int target) {
        if(nums.length<2){
            return new int[]{};
        }
        int[] res = new int[2];
        //key as number , value as index
        Map<Integer,Integer> tm= new HashMap<>();
        for(int i =0 ;i<nums.length;i++){
            if(!tm.containsKey(target-nums[i])){
                tm.put(nums[i],i);
            }else{
                    res[0] = tm.get(target-nums[i]);
                    res[1] = i;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{2,7,11,15},9)));
    }
}
