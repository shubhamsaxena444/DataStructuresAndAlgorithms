package GFG.DP.GFG_must_do;

import java.util.Arrays;

/*Maximize the number of segments of length p, q and r
Given a rod of length L, the task is to cut the rod in such a way that the total number of segments of length p, q and r is maximized. The segments can only be of length p, q, and r.

Examples:

Input: l = 11, p = 2, q = 3, r = 5
Output: 5
Segments of 2, 2, 2, 2 and 3





Input: l = 7, p = 2, q = 5, r = 5
Output: 2
Segments of 2 and 5*/
public class MaxCoinChangeOrRodOfLengthLProblem {
    public static void main(String[] args) {
        System.out.println(solve(new int[]{2,3,5},23));
    }

    private static int solve(int[] a, int n) {
        if(n==0)return Integer.MIN_VALUE;
        int[] dp = new int[n+1]; //here dp[i] represent max number of segments that can be ued to form
        // rod of length i, if not possible, then it contains -infinity
        Arrays.fill(dp,Integer.MIN_VALUE);
        dp[0] = 0;
        //traverse for all possible lengths
        for(int i =1;i<=n;i++){
            //traverse for all possible segment length/coins
            for(int j =0;j<a.length;j++){
                //if a[j]< i(length of rod
                if(a[j]<=i){
                    //i can either include this jth segment or exclude it to find max segments
                    int include = dp[i-a[j]] != Integer.MIN_VALUE ? 1 + dp[i-a[j]] : Integer.MIN_VALUE;
                    int exclude = dp[i];
                    dp[i] = Math.max(include,exclude);
                }

            }

        }
        return dp[n];

    }
}
