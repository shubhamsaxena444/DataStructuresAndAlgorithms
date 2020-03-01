package leetcode.amazonAndMicrosoft.arraysAndString;

import java.util.Scanner;

/*
* Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

Example:

Input: S = "ADOBECODEBANC", T = "ABC"
Output: "BANC"
Note:

If there is no such window in S that covers all characters in T, return the empty string "".
If there is such window, you are guaranteed that there will always be only one unique minimum window in S*/
public class MinimumWindowSubstring {

    public String minWindow(String s, String t) {
        // start with window of length t.size
        // maintain char arr for t
        //maintain char arr for sliding wind s
        //whenver chr arr of s >= char arr of t (can accomodate t), compare it with global minLength and update
        int minLength =Integer.MAX_VALUE;
        String ans="";
        if(s.length() == 0 || t.length() ==0 || s.length()<t.length()){
            return "";
        }
        if(s.length() ==1 && t.length() ==1 && t == s   ){
            return s;
        }
        int n = s.length();
        int m = t.length();

        int start =0;
        int end;
        //maintain tc
        int[] tc = new int[256];
        int wc[] = new int[256];
        for(int i =0;i<m;i++){
            tc[ t.charAt(i)- 'A' ]++;
        }
        //initialise window wc with length m
        for(int i =0;i<m;i++){
            wc[ s.charAt(i)- 'A' ]++;
        }
        for(end=m;end<n; end++){
            //clear the window, if possible
            //if s.charAt(s) is not required in the substring remove it
            while(start<end-1 && wc[s.charAt(start)- 'A' ] > tc[s.charAt(start)-'A']  ){
                wc[s.charAt(start)- 'A' ]--;
                start++;
            }

            //check for solution
            if(check(wc,tc)){
                if(end-start < minLength){
                    minLength = end-start;
                    ans= s.substring(start,end);

                }

            }

                //extend the window
                if(end<n){
                    wc[s.charAt(end)- 'A' ]++;
                }

        }
        while(start<end-1 && wc[s.charAt(start)- 'A' ] > tc[s.charAt(start)-'A']  ){
            wc[s.charAt(start)- 'A' ]--;
            start++;
        }
        //check for solution
        if(check(wc,tc)){
            if(end-start < minLength){
                minLength = end-start;
                ans= s.substring(start,end);

            }

        }
        return ans;
    }

    private boolean check(int[] wc,int[] tc){

        for(int i =0;i<256;i++){
            if(wc[i]<tc[i])
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        String s = sc.nextLine();
        String t = sc.nextLine();
        MinimumWindowSubstring r = new MinimumWindowSubstring();
        System.out.println(r.minWindow(s,t));
    }
}
