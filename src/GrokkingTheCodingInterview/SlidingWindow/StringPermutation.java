package GrokkingTheCodingInterview.SlidingWindow;
/*Given a string and a pattern, find out if the string contains any permutation of the pattern.

Permutation is defined as the re-arranging of the characters of the string. For example, “abc” has the following six permutations:

abc
acb
bac
bca
cab
cba
If a string has ‘n’ distinct characters it will have n!n! permutations.

Example 1:

Input: String="oidbcaf", Pattern="abc"
Output: true
Explanation: The string contains "bca" which is a permutation of the given pattern.
Example 2:

Input: String="odicf", Pattern="dc"
Output: false
Explanation: No permutation of the pattern is present in the given string as a substring.*/
public class StringPermutation {

    public static boolean findPermutation(String str, String pattern) {
        // TODO: Write your code here
        int start = 0;
        int pCount[] = new int[256];
        if(str.length() < pattern.length()){
            return false;
        }
        int windowSize = pattern.length();
        for(int i =0;i<windowSize;i++){
            pCount[pattern.charAt(i)]++;
        }

        for(int end =0;end<str.length();end++){
            //add end char
            pCount[str.charAt(end)]--;

            //clear window if size is greater than windowsize or equals check fails
            if(end-start+1 > windowSize){
                pCount[str.charAt(start)]++;
                start++;
            }

            if(end-start+1 == windowSize && isZero(pCount)){
                return true;
            }
        }
        return false;
    }

    static boolean isZero(int[] a ){
        boolean flag = true;
        for(int i  =0;i<256;i++){
            if(a[i] != 0){
                flag=false;
                break;
            }
        }
        return flag;
    }
}
