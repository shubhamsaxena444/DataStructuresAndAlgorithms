package GFG.arrays.DP;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LongestCommonSequence {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
     //   QuickSort.quickSort(arr,0,n-1);
       LCS(arr,n);
    }

    private static void LCS(int a[], int n){
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
            if(isVisited.get(a[i])){
                continue;
            }else{
                isVisited.put(a[i],true);
            }
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
            System.out.println(start+i);
            }
        }else{
            System.out.println(minElement);
        }
    }
}
