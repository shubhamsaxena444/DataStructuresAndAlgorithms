package leetcode.googleAndFacebook.frequentlyasked;

import java.util.*;

public class wordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        if(s=="")
            return true;
        int n = s.length();
        boolean dp[] =new boolean[n+1];
        dp[0]=true;
        Set<String> wordDictSet=new HashSet(wordDict);
        for(int end =1;end<=n;end++){
            for(int start =0;start<end;start++){
                if(dp[start] && wordDictSet.contains(s.substring(start,end))){
                    dp[end] = true;
                    break;
                }
            }

        }
        return dp[n];
    }
}
