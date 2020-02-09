package GFG.arrays;

import java.util.Arrays;

public class ThreeSumClosest {
    public static void main(String[] args) {
        System.out.println(threeSumClosest(new int[]{-1,-4,1,2},1));
    }

    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int a =0, b=0, c=0;
        int diff =Integer.MAX_VALUE;
        for(int k =0;k<nums.length-2;k++){

            int v = target-nums[k];
            for(int i =k+1,j=nums.length-1;i<j;){
                if(nums[i] + nums[j] == v){
                    diff =0;
                    a= nums[k];
                    b =nums[i];
                    c= nums[j];
                    return a+b+c;
                }else if(nums[i] + nums[j] < v) {
                    if(diff > Math.abs(v-(nums[i] + nums[j]))){
                        diff = Math.abs(v-(nums[i] + nums[j]));
                        a= nums[k];
                        b =nums[i];
                        c= nums[j];

                    }
                    i++;
                }else{
                    if(diff > Math.abs(v-(nums[i] + nums[j]))){
                        diff = Math.abs(v-(nums[i] + nums[j]));
                        a= nums[k];
                        b =nums[i];
                        c= nums[j];

                    }
                    j--;
                }
            }
        }
        return a+b+c;
    }
}
