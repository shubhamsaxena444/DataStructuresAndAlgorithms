package CompetitiveProgrammingQuestions.SearchingAndSorting;

import java.util.Arrays;
import java.util.Scanner;

/*Aggressive Cows Problem
Send Feedback
Farmer John has built a new long barn, with N (2 <= N <= 100,000) stalls. The stalls are located along a straight line at positions x1,...,xN (0 <= xi <= 1,000,000,000).
His C (2 <= C <= N) cows don't like this barn layout and become aggressive towards each other once put into a stall. To prevent the cows from hurting each other, FJ wants to assign the cows to the stalls, such that the minimum distance between any two of them is as large as possible. What is the largest minimum distance?
Input
t – the number of test cases, then t test cases follows.
* Line 1: Two space-separated integers: N and C
* Lines 2..N+1: Line i+1 contains an integer stall location, xi
Output
For each test case output one integer: the largest minimum distance.
Sample Input :
1
5 3
1
2
8
4
9
Sample Output:
3
Output details:
FJ can put his 3 cows in the stalls at positions 1, 4 and 8,
resulting in a minimum distance of 3.*/
public class AggressiveCows {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while(t-->0) {
            int n = in.nextInt();
            int c = in.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }

            System.out.println(largestMinimumDistance(arr, c));
        }
    }

    private static int largestMinimumDistance(int[] arr, int c) {
        int d; //d will range from 0 to max-min element.
        //do binary search for d =0 to max-min
        Arrays.sort(arr);
        int n = arr.length;
        return binarySearchArrangement(arr,0,arr[n-1]-arr[0],c);
    }

    private static int binarySearchArrangement(int[] arr, int s, int e,int c) {
        if(s>e){
            return -1;
        }
        int m = s+ (e-s)/2 ;
        //if m is possible && m+1 is not possible return m ,else if m is possible, search in m+1,e, else search in s,m-1
        boolean isPossible = isPossible(arr,m,c);
        if(isPossible && ( m+1>e || !isPossible(arr,m+1,c))){
            return m;
        }else if(isPossible){
            return binarySearchArrangement(arr,m+1,e,c);
        }else{
            return binarySearchArrangement(arr,s,m-1,c);
        }
    }

    private static boolean isPossible(int[] arr, int m,int c) {
        int count = c-1;
        int lastCowPlace = 0;
        for(int i =1;i<arr.length;i++){
            if(arr[i]-arr[lastCowPlace] >= m){
                count--;
                lastCowPlace = i;
            }
            if(count == 0){
                return true;
            }
        }
        return count!=0?false:true;
    }
}
