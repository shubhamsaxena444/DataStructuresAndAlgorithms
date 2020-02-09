package GFG.arrays;

import java.util.Arrays;

public class ArrayRotation {
    public static void rotate(int[] nums, int k) {
        if (nums.length == 0 ){return ;}
        if(k > nums.length){
            k = k % nums.length;
        }
        reverse(nums,0,nums.length-k-1);
        reverse(nums,nums.length-k,nums.length-1);
        reverse(nums,0,nums.length-1);
    }

    private static void reverse(int[] nums, int i, int j){
        int temp;
        for (int k =i,l=j;k<l;k++,l--){
            temp =nums[k];
            nums[k] = nums[l];
            nums[l] =temp;
        }

    }

    public static void main(String[] args) {
        int a[] = new int[]{1,2,3,4,5,6,7};
        rotate(a,3);
        System.out.println(Arrays.toString(a));
    }
}
