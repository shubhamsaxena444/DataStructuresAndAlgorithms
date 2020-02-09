package CompetitiveProgrammingQuestions.Trie;

import java.util.Scanner;
/*
*Maximum XOR Subarray
Send Feedback
Given an array of n integers, find subarray whose xor is maximum.
Input Format
First line contains single integer n (1<=n<=1000000).
Next line contains n space separated integers.
Output Format
Print xor of the subarray whose xor of all elements in subarray is maximum over all subarrays.
Constraints
1 <= n <= 1000000
1 <= A[i] <=100000
Sample Input
4
1 2 3 4
Sample Output
7
* */
public class maxXORSubarray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int  n  = sc.nextInt();
        int a [] =new int[n];
        for(int i =0;i<n;i++){
            a[i] =sc.nextInt();
        }
        TrieNode head = new TrieNode();
        System.out.println(maxXOR(head,a,n));
    }

    private static int maxXOR(TrieNode head, int[] a, int n) {
        int preXOR=0;
        int result = Integer.MIN_VALUE;
        for(int i =0;i<n;i++){
            //insert the number in head
            preXOR ^= a[i];
            insert(head,preXOR);

            // Query for current prefix xor in Trie and update
            // result if required
            result = Math.max(result, query(head, preXOR));

        }
        return result;
    }

    private static int query(TrieNode head, int preXOR) {
        TrieNode cur  = head;
        int curXOR=0;
        for(int i =31;i>=0;i--) {
            //check the bit
            int b = ((preXOR &(1<<i)) > 0) ?1:0;
            if(b==0){
                //check of bit 1 in right
                if(cur.right!=null){
                    curXOR+=Math.pow(2,i);
                    cur=cur.right;
                }else{
                    cur=cur.left;
                }
            }else{
                //check of bit 0 in left
                if(cur.left!=null){

                    curXOR+=Math.pow(2,i);
                    cur=cur.left;
                }else{
                    cur=cur.right;
                }
            }
        }
        return curXOR;
    }

    static  class TrieNode{
        TrieNode left;
        TrieNode right;
    }
    static void insert(TrieNode head, int n ){
        //for a 32 bit number, we need to insert from msb to lsb
        TrieNode cur = head;
        for(int i =31;i>=0;i--){
            int b = (n & (1<<i)) >=1 ? 1 : 0;
            if(b==1){
                //the bit is 1
                //check if its already present
                if(cur.right==null){
                    cur.right =new TrieNode();
                }
                cur=cur.right;
            }else{
                //check if its already present
                if(cur.left==null){
                    cur.left =new TrieNode();
                }
                cur=cur.left;
            }
        }
    }
}