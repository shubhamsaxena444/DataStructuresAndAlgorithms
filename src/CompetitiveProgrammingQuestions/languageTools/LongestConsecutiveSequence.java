package CompetitiveProgrammingQuestions.languageTools;

import java.util.*;

/*Longest consecutive Sequence
Send Feedback
You are given with an array of integers that contain numbers in random order. Write a program to find the longest possible sequence of consecutive numbers using the numbers from given array.
You need to return the output array which contains consecutive elements. Order of elements in the output is not important.
Best solution takes O(n) time.
If two sequences are of equal length then return the sequence starting with the number whose occurrence is earlier in the array.
Input Format :
Line 1 : Integer n, Size of array
Line 2 : Array elements (separated by space)
Constraints :
1 <= n <= 50000
Sample Input 1 :
13
2 12 9 16 10 5 3 20 25 11 1 8 6
Sample Output 1 :
8
9
10
11
12
Sample Input 2 :
7
3 7 2 1 9 8 1
Sample Output 2 :
7
8
9
Explanation: Sequence should be of consecutive numbers. Here we have 2 sequences with same length i.e. [1, 2, 3] and [7, 8, 9], but output should be [7, 8, 9] because the starting point of [7, 8, 9] comes first in input array.
Sample Input 3 :
7
15 24 23 12 19 11 16
Sample Output 3 :
15
16*/
public class LongestConsecutiveSequence {
    public static ArrayList<Integer> longestConsecutiveIncreasingSequence(int a[]){
        int n = a.length;
        ArrayList<Integer> res = new ArrayList<Integer>();
        //maintain a hashmap and two variables, start of sequence and length of sequence
        int start =Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int minElement = Integer.MAX_VALUE;
        Map<Integer,Boolean> isVisited = new HashMap<>();
        for(int i =0;i<n;i++){
            isVisited.put(a[i],false);
            if(minElement>a[i]){
                minElement = a[i];
            }
        }
        for(int i =0;i<n;i++){
            //for this element , calculate fowrard length and backward length and update the variables, start and max
            int forward=0;
            int backward = 0;
            while(isVisited.get(a[i]+forward+1)!=null && !isVisited.get(a[i]+forward+1)){
                isVisited.put(a[i]+forward+1,true);
                forward++;
            }
            while(isVisited.get(a[i]-backward-1)!=null && !isVisited.get(a[i]-backward-1)){
                isVisited.put(a[i]-backward-1,true);
                backward++;
            }
            if(max < forward+backward+1){
                max = forward+backward+1;
                start= a[i] - backward;
            }
            if(max == forward+backward+1){
                start= a[i] - backward;
            }
        }
        if(max>1){
            for(int i =0;i<max;i++){
                res.add(start+i);
            }
        }else{
            res.add(minElement);
        }
        return res;
    }
}
