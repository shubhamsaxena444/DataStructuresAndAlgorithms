package leetcode.googleAndFacebook.arrays;

import java.util.*;

/*
* Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms required.

Example 1:

Input: [[0, 30],[5, 10],[15, 20]]
Output: 2
Example 2:

Input: [[7,10],[2,4]]
Output: 1
NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature.*/
public class MinMeetingRooms {
    public int minMeetingRooms(int[][] arr) {
        TreeMap<Integer,Integer> map = new TreeMap<>();
        int n =arr.length;
        if(n==0)return 0;
        int m =arr[0].length;
        int ans = Integer.MIN_VALUE;
        //for every start increase value
        //for every end+1, decrease value
        for(int i =0;i<n;i++){
            //arr[i] is a pair with start = arr[0] and end = arr[1]
            map.put(arr[i][0],map.getOrDefault(arr[i][0],0)+1);

            map.put(arr[i][1],map.getOrDefault(arr[i][1],0)-1);
            //now take cumulative sum of values

            Set set = map.entrySet();
            Iterator it = set.iterator();
            int prev = Integer.MAX_VALUE;
            while(it.hasNext()){
                Map.Entry me = (Map.Entry)it.next();
                if(prev ==Integer.MAX_VALUE ){
                    //first time
                    prev = (int)me.getValue();
                    ans = Math.max(ans,prev);
                }else{
                    int temp = prev + (int)me.getValue();

                    //keep updating answer
                    ans = Math.max(ans,temp);
                    prev = temp;
                }
            }

        }
        return ans;
    }
}
