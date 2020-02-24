package GFG.DP.GFG_must_do;

import java.util.Arrays;

/*Minimum number of jumps to reach end
Given an array of integers where each element represents the max number of steps that can be made forward from that element. Write a function to return the minimum number of jumps to reach the end of the array (starting from the first element). If an element is 0, then cannot move through that element.

Example:

Input: arr[] = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9}
Output: 3 (1-> 3 -> 8 ->9)
First element is 1, so can only go to 3. Second element is 3, so can make at most 3 steps eg to 5 or 8 or 9.*/
public class MinJumps {
   static int dp[] =new int[11];

    public static void main(String[] args) {
        Arrays.fill(dp,-1);
        System.out.println(minJumps(new int[]{1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9},0,10));
    }
   static int minJumps =Integer.MAX_VALUE;
    static int minJumps(int[] arr,int l,int h){
        /*if(n==0 )return n;
        if(n==1)return 0;
        if(n==2){
            return a[0]>0 ? 1: -1;
        }
        //what are the min jumps required to reach n-1 index ?
        for(int i =n-2;i>=0;i--){
            if(a[i]>= (n-i-1)){

              minJumps =  Math.min(minJumps, minJumps(a,i+1));
            }
        }
        return minJumps+1;*/
        // Base case: when source
        // and destination are same
        if (h == l)
            return 0;

        // When nothing is reachable
        // from the given source
        if (arr[l] == 0)
            return Integer.MAX_VALUE;

        if(dp[l]!= -1)return dp[l];

        // Traverse through all the points
        // reachable from arr[l]. Recursively
        // get the minimum number of jumps
        // needed to reach arr[h] from these
        // reachable points.
        int min = Integer.MAX_VALUE;
        for (int i = l + 1; i <= h && i <= l + arr[l]; i++) {
            int jumps = minJumps(arr, i, h);
            if (jumps != Integer.MAX_VALUE && jumps + 1 < min)
                min = jumps + 1;
        }
        return dp[l] = min;
    }
}
