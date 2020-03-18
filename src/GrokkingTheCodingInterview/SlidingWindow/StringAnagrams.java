package GrokkingTheCodingInterview.SlidingWindow;

import java.util.*;
/*String Anagrams (hard) #
Given a string and a pattern, find all anagrams of the pattern in the given string.

Anagram is actually a Permutation of a string. For example, “abc” has the following six anagrams:

abc
acb
bac
bca
cab
cba
Write a function to return a list of starting indices of the anagrams of the pattern in the given string.

Example 1:

Input: String="ppqp", Pattern="pq"
Output: [1, 2]
Explanation: The two anagrams of the pattern in the given string are "pq" and "qp".
Example 2:

Input: String="abbcabc", Pattern="abc"
Output: [2, 3, 4]
Explanation: The three anagrams of the pattern in the given string are "bca", "cab", and "abc".*/
public class StringAnagrams {
    public static List<Integer> findStringAnagrams(String str, String pattern) {
        List<Integer> resultIndices = new ArrayList<Integer>();
        // TODO: Write your code here

        int start = 0;
        int pCount[] = new int[256];
        int sCount[] = new int[256];
        if(str.length() < pattern.length()){
            return resultIndices;
        }
        int windowSize = pattern.length();
        for(int i =0;i<windowSize;i++){
            pCount[pattern.charAt(i)]++;
            sCount[str.charAt(i)]++;
        }
        if(isEqual(pCount,sCount)){
            resultIndices.add(0);
            return resultIndices;
        }
        for(int end =windowSize;end<str.length();end++){
            //add end char
            sCount[str.charAt(end)]++;

            //clear window if size is greater than windowsize or equals check fails
            if(end-start+1 > windowSize){
                sCount[str.charAt(start)]--;
                start++;
            }

            if(isEqual(pCount,sCount)){
                resultIndices.add(start);
            }
        }
        return resultIndices;
    }

    static boolean isEqual(int[] a ,int[] b){
        boolean flag = true;
        for(int i  =0;i<256;i++){
            if(a[i] != b[i]){
                flag=false;
                break;
            }
        }
        return flag;
    }
}
