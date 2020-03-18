package leetcode.googleAndFacebook.frequentlyasked;
/*007. Minimum Domino Rotations For Equal Row
Medium

553

146

Add to List

Share
In a row of dominoes, A[i] and B[i] represent the top and bottom halves of the i-th domino.  (A domino is a tile with two numbers from 1 to 6 - one on each half of the tile.)

We may rotate the i-th domino, so that A[i] and B[i] swap values.

Return the minimum number of rotations so that all the values in A are the same, or all the values in B are the same.

If it cannot be done, return -1.*/
public class Dominos {
    public int minDominoRotations(int[] A, int[] B) {
        int n = A.length;
        int m = B.length;
        if(n!=m)return -1;
        boolean isPossible =true;
        int minSwaps = Integer.MAX_VALUE;

        for(int p=1;p<=6;p++){
            int count =0;
            isPossible = true;
            //want to convert A such that all elements of A are equal ==p
            for(int i=0;i<n;i++){
                if(A[i]==p){
                    continue;
                }else if(B[i]==p){
                    count++;
                }else{
                    isPossible = false;
                    count =0;
                    break;
                }
            }
            if(isPossible)
                minSwaps=Math.min(minSwaps,Math.min(count,n-count));
        }

        for(int p=1;p<=6;p++){
            int count =0;
            isPossible = true;
            //want to convert A such that all elements of A are equal ==p
            for(int i=0;i<n;i++){
                if(B[i]==p){
                    continue;
                }else if(A[i]==p){
                    count++;
                }else{
                    isPossible = false;
                    count =0;
                    break;
                }
            }
            if(isPossible)
                minSwaps=Math.min(minSwaps,Math.min(count,n-count));
        }
        return minSwaps != Integer.MAX_VALUE?minSwaps:-1;
    }
}
