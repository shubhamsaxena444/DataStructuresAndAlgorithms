package leetcode.amazon.dp;

/*
* Given a string s, find the longest palindromic subsequence in s. You may assume that the maximum length of s is 1000.

Example 1:

Input: "babad"
Output: "bab"
Note: "aba" is also a valid answer.
Example 2:

Input: "cbbd"
Output: "bb"
* */
//SC and TC = O(n2)
public class LongestPalindromicSubsequence {
    public static String longestPalindrome(String s) {

        int n  = s.length();
        String dp[][] = new String[n][n];

        String res ="";
        return helper(s,0,n-1,res,dp) + "";
    }

    private static String helper(String s, int i, int j, String res, String[][] dp) {
        //if s has length ==1
        if(i ==j){
           return s.charAt(i)+""; // return 1;
        }else if(i>j){
            return "";  //return 0;
        }
        if(dp[i][j] != null){
            return dp[i][j];
        }
        if (s.charAt(i)==s.charAt(j)){
            dp[i][j] = s.charAt(i) + helper(s,i+1,j-1,res, dp)+ s.charAt(j); //2 + helper(s,i+1,j-1,res);
        }else{
            String left = helper(s,i,j-1,res, dp);
            String right = helper(s,i+1,j,res, dp);
           if(left.length()>=right.length()){
               dp[i][j]= left;
           }else{
               dp[i][j]= right;
           }
        }
        return dp[i][j];
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
    }
}
