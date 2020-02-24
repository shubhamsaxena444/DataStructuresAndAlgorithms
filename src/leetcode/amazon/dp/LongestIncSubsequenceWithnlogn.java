package leetcode.amazon.dp;

import java.util.*;
import java.util.stream.Collectors;

public class LongestIncSubsequenceWithnlogn {

    public static void main(String[] args) {
        System.out.println(lis(new int[]{4,10,4,3,8,9}));
    }

    private static int lis(int[] a) {
        List<Integer> tail = new ArrayList<>();
        //tail[i]  array contains the minimum possible value of the lis with length (i+1)
        if(a.length <=1)return a.length;
        tail.add(a[0]);
        for(int i =1;i<a.length;i++) {
            // if a[i]  is greater than the last element of tail , then append,
            if (a[i] == tail.get(tail.size() - 1)) {
                continue ; //we dont want to consider equal elements in the lis
            }else if (a[i] > tail.get(tail.size() - 1)) {
                    tail.add(a[i]);
            } else {
                //else. , find the ceil vaule in tail till i-1 and replace cur with ceil val
                int index = Collections.binarySearch(tail,a[i]);
                int ceilIndex;
                if(index>=0){
                    continue; ////we dont want to consider equal elements in the lis
                  //  ceilIndex =index+1;
                }else{
                    ceilIndex =Math.abs(index) -1;
                }
                tail.set(ceilIndex,a[i]);
            }
        }
        return tail.size();
    }
}
