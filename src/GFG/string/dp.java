package string;

import java.util.*;

public class dp {
   static String[] composeRanges(int[] nums) {
        int n = nums.length;
        // String s[] = new String[];
        List<String> l = new ArrayList<String>();
        if(n==0){

        }else if(n== 1){
            l.add(nums[0]+"");
        }
        int start =0,end;
        String str =nums[0]+"";
        for(end =start+1;end<n;end++){
            if(nums[end-1] == nums[end]-1){
                str+= "->"+nums[end];
            }else{
                start =end;
                l.add(str);
                str = nums[start]+"";
            }
        }
        l.add(str);
        return (String[])l.toArray(new String[l.size()]);

    }

    public static void main(String[] args) {
        System.out.println(mapDecoding("123"));
    }

    static int mapDecoding(String message,int n,int[] dp) {
//int n = message.length();
        if(n<=1)return 1;
        if(dp[n] !=0){
            return dp[n];
        }

        if(message.charAt(n-2) =='1' || (message.charAt(n-2) =='2' && message.charAt(n-1) <='6')){
            return  dp[n] = mapDecoding(message,n-1,dp) +mapDecoding(message,n-2,dp);
        }
        return dp[n] = mapDecoding(message,n-1,dp) ;

    }

    static int mapDecoding(String message) {
        int n = message.length();
        int dp[] = new int[n+1];
        return mapDecoding(message,n,dp);
    }
}
