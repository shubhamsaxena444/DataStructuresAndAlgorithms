package CompetitiveProgrammingQuestions.numberTheory;

import java.util.Scanner;

public class NumberOfFactors {
    public static void main(String[] args) {


    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
        int a[] = new int[t];
        int b[] = new int[t];
    int n[] = new int[t];

    //compute using seive logic, we have to store which number has how many distinct prime factors
    sieveOfEratosthenes(num);

        for(int i =0;i<t;i++){

            a[i] =sc.nextInt();

            b[i] =sc.nextInt();

            n[i] =sc.nextInt();
        }
        preCompute();
        for(int i =0;i<t;i++) {
            System.out.println(solve(a[i],b[i],n[i]));

           
        }
    }
    static int num =    1000001;
    //n can range from 1 to 10^6
    static int[] arr;

    static {
        arr = new int[num];
    }
    static  int matrix[][] = new int[11][num];
    static void preCompute(){
        for(int i =0;i<11;i++){
            for(int j =1;j<num;j++){
                if(arr[j] == i) {
                    matrix[i][j] = matrix[i][j - 1] + 1;
                }else{
                    matrix[i][j] = matrix[i][j - 1];
                }
            }
        }
    }
    private static int solve(int a,int b, int n) {

       return matrix[n][b] - matrix[n][a];

    }



    static void sieveOfEratosthenes(int n)
    {
        // Create a boolean array "prime[0..n]" and initialize
        // all entries it as true. A value in prime[i] will
        // finally be false if i is Not a prime, else true.

        for(int p = 2; p*p <n; p++)
        {
            // If prime[p] is not changed, then it is a prime
            if(arr[p] == 0)
            {
                // Update all multiples of p
                for(int i = p; i < n; i += p)
                    arr[i] ++;
            }
        }
    }
}
