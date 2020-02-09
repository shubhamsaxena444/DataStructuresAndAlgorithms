package string;

import java.util.Arrays;

public class Anagram
{

    public static boolean isAnagram(String s, String t) {

        if(s.length() != t.length()){
            return false;
        }
        // in the first iteration fill the array with the frequency of chars.

        int[] freq = new int[26];
        for(int i = 0 ;i <s.length();i++){
            freq[s.charAt(i)-'a']++;

        }
        //in the second iteration , decrease the freq with t
        for(int i = 0 ;i<t.length();i++){
            freq[t.charAt(i)-'a']--;
        }

        return !Arrays.stream(freq).anyMatch(x -> x!=0 );

    }

    public static void main(String[] args) {
        System.out.println(isAnagram("anagram","aangarm"));
    }
}
