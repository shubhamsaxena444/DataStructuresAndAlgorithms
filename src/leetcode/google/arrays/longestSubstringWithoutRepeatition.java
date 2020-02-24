package leetcode.google.interviewProcess.arrays;

import java.util.HashMap;

public class longestSubstringWithoutRepeatition {
    public int lengthOfLongestSubstring(String s) {
        //sliding window
        HashMap<Character,Integer> map = new HashMap<>();
        int n = s.length();
        if(n==0)return 0;
        int start =0,maxWindowSize=0;


        for(int end = start;end< n;end++){
            //if element is already present, update the start index,else put the element back
            if(map.containsKey(s.charAt(end))){
                //update the start with new if its greater
                start = Math.max(map.get(s.charAt(end)),start);
            }
            //put index of the next element
            map.put(s.charAt(end),end+1);
            //update max window size
            maxWindowSize = Math.max(maxWindowSize,end-start+1);

        }
        return maxWindowSize;
    }
}
