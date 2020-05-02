package leetcode.googleAndFacebook.frequentlyasked;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*You are given an array of N integers, A1, A2 ,…, AN. Return maximum value of f(i, j) for all 1 ≤ i, j ≤ N.
f(i, j) is defined as |A[i] - A[j]| + |i - j|, where |x| denotes absolute value of x.

For example,

A=[1, 3, -1]

f(1, 1) = f(2, 2) = f(3, 3) = 0
f(1, 2) = f(2, 1) = |1 - 3| + |1 - 2| = 3
f(1, 3) = f(3, 1) = |1 - (-1)| + |1 - 3| = 4
f(2, 3) = f(3, 2) = |3 - (-1)| + |2 - 3| = 5

So, we return 5.*/
public class MaxAbsoluteDiff {
    public static int maxArr(List<Integer> A) {
        int[] a = new int[A.size()];
        int n = A.size();
        for(int i =0;i<A.size();i++){
            a[i] = A.get(i);
        }
        int maxV = Integer.MIN_VALUE;
        int X[] = new int[n];
        int Y[] = new int[n];
        for(int i =0;i<n;i++){
            X[i] = i -a[i];
            Y[i] = i +a[i];
        }
        //modifying X and Y such that each index will store the maximum value in the right excluding current element
        int xmax = X[n-1];
        int ymax = Y[n-1];

        for(int i = n-2; i>=0;i--){
            int tempX = X[i];
            X[i] =xmax;
            if(xmax < tempX){
                xmax = tempX;
            }
            int tempY = Y[i];
            Y[i] = ymax;
            if(ymax < tempY){
                ymax = tempY;
            }
        }

        for(int i=0;i<n-1;i++ ){
/*
*       ai-aj+j-i == ai-i+ (j-aj)  =ai-i +xi
*
*       aj-ai+j-i == aj+j - ai-i = yi -ai-i
* */
            maxV = Math.max(maxV,Math.max(a[i] -i +X[i] , Y[i] -i-a[i]));

        }

        return maxV;
    }


    public static void main(String[] args) {
        List<Integer> a = Arrays.asList(-39, -24, 82, 95, 91, -65, 16, -76, -56, 70 );
        System.out.println(maxArr(a));
    }
}
