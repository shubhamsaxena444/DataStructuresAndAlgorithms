package CompetitiveProgrammingQuestions.BitManipulation;

import java.util.Scanner;

/*Clear All Bits From MSB
Send Feedback
You are given two integers N and i. You need to clear all bits from MSB to ith bit (start i from right to left) and return the updated N.
Counting of bits starts from 0 from right to left.
Input Format :
Two integers N and i (separated by space)
Output Format :
Updated N
Sample Input 1 :
15 2
Sample Output 1 :
3
Sample Output 1 Explanation :
We need to clear all bits from MSB to ith bit i.e. clear all bits except 0th and 1st.
Sample Input 2 :
4 4
Sample Output 2 :
4*/
public class ClearAllBitsFromMSB {
    public static void main(String[] args) {
        /* Your class should be named Main
         * Read input as specified in the question.
         * Print output as specified in the question.
         */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ii =sc.nextInt();
        int m =1;
        for(int i =0;i<ii;i++){
            m= m<<1;

        }
        // m = (m << ii) -1;
        System.out.println( n &( m-1));
    }
}