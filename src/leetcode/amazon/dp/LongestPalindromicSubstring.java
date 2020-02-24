package leetcode.amazon.dp;

/*
* Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

Example 1:

Input: "babad"
Output: "bab"
Note: "aba" is also a valid answer.
Example 2:

Input: "cbbd"
Output: "bb"
* */
//SC and TC = O(n2)
public class LongestPalindromicSubstring {
/*

    We could see that the longest common substring method fails when there exists a reversed copy of a non-palindromic substring in some other part of SS. To rectify this, each time we find a longest common substring candidate, we check if the substring’s indices are the same as the reversed substring’s original indices. If it is, then we attempt to update the longest palindrome found so far; if not, we skip this and find the next candidate.

    This gives us an O(n^2)O(n
2
        ) Dynamic Programming solution which uses O(n^2)O(n
2
        ) space (could be improved to use O(n)O(n) space). Please read more about Longest Common Substring here.
  // static int n ,m;
    public static String longestPalindrome(String s) {

        int  n  = s.length();
        String dp[][] = new String[n+1][n+1];

        String res ="";
        int count =0;
        return longestCommonSubstring(s,new StringBuilder(s).reverse().toString(), n,n,res,dp,count) + "";
    }
*/
/*
* this is a very important logic , if we have to start recurion with a new value say 0, then we need to pass it as a paraametr
* *//*

    private static String longestCommonSubstring(String s, String reverse, int n, int m, String res, String[][] dp, int count) {
        //if s has length ==1
        if(n==1&& m==1){
           return  s.charAt(0) ==reverse.charAt(0) ? s.charAt(0)+"":"";
        }else if(n<=0 || m<=0){
           return ""; // return 1;
        }
        if(dp[n][m] != null){
            return dp[n][m];
        }
        if (s.charAt(n-1)==reverse.charAt(m-1)){
            //if its a part of longest suffix , then include it
            dp[n][m] = longestCommonSubstring(s, reverse, n-1,m-1,res+s.charAt(n-1), dp, count+1)+ s.charAt(n-1); //2 + longestCommonSubstring(s,i+1,j-1,res);
        }else{
            //else , it creates a new search for longest suffix
            String left = longestCommonSubstring(s, reverse, n,m-1,"", dp, 0);
            String right = longestCommonSubstring(s, reverse, n-1,m,"", dp, 0);

            if(count >=left.length() && count >=right.length() ){
                dp[n][m] = res;
            }else if(left.length()>= count && left.length()>= right.length()){
               dp[n][m]= left;
           }else{
               dp[n][m]= right;
           }
        }
        return dp[n][m];
    }
*/
public static String longestPalindrome(String s) {
    if (s == null || s.length() < 1) return "";
    int start = 0, end = 0;
    for (int i = 0; i < s.length(); i++) {
        int len1 = expandAroundCenter(s, i, i);
        int len2 = expandAroundCenter(s, i, i + 1);
        int len = Math.max(len1, len2);
        if (len > end - start) {
            start = i - (len - 1) / 2;
            end = i + len / 2;
        }
    }
    return s.substring(start, end + 1);
}

    private static int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }
    public static void main(String[] args) {
        System.out.println(longestPalindrome("a"));
    }
}
