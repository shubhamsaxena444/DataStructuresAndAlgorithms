package leetcode.googleAndFacebook.arrays;

import java.util.Arrays;

/*
* Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

The replacement must be in-place and use only constant extra memory.

Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.

1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1*/
public class NextGreaterPErmutation {
    public void nextPermutation(int[] nums) {
        boolean isPossible =true;
        //idea is to start from right and look for first smaller number that rightmost and swap
        //with righmost and sort the remaining numbers
        int n = nums.length;
        if(n==0)return;
        int end = n-1;
        int firstSmaller=n-2;
        while(firstSmaller>=0 && nums[firstSmaller]>=nums[firstSmaller+1]){
            firstSmaller--;
        }
        if(firstSmaller<0){
            isPossible=false;
            Arrays.sort(nums);
        }else{
            //swap firstSmaller and just bigget numeber after first smaller
            while(end>=0 && nums[end]<=nums[firstSmaller])end--;
            nums[firstSmaller] = nums[firstSmaller] ^ nums[end];
            nums[end] = nums[firstSmaller] ^ nums[end];
            nums[firstSmaller] = nums[firstSmaller] ^ nums[end];
            //sort remaining numbers after firstSmaller
            Arrays.sort(nums,firstSmaller+1,n);
        }

    }
}
