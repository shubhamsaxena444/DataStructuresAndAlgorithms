package CompetitiveProgrammingQuestions.numberTheory;

import java.util.Scanner;

public class DivisorsOfFactorial {
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        int t = sc.nextInt();
        primes = sieveOfEratosthenes(max);
        int n[] = new int[t];
        for(int i =0;i<t;i++){
            n[i] =sc.nextInt();
        }
        for(int i =0;i<t;i++){
            System.out.println(solve(n[i]));
        }
    }
    static int max = 50000;
    static int mod = 1000000007;
    static int[] primes;
    static int[] sieveOfEratosthenes(int n)
    {
        // Create a boolean array "prime[0..n]" and initialize
        // all entries it as true. A value in prime[i] will
        // finally be false if i is Not a prime, else true.
        boolean prime[] = new boolean[n+1];
        for(int i=0;i<n;i++)
            prime[i] = true;

        for(int p = 2; p*p <=n; p++)
        {
            // If prime[p] is not changed, then it is a prime
            if(prime[p] == true)
            {
                // Update all multiples of p
                for(int i = p*p; i <= n; i += p)
                    prime[i] = false;
            }
        }
        int count =0;

        // Print all prime numbers
        for(int i = 2; i <= n; i++)
        {
            if(prime[i] == true)
                count++;
        }
        int arr[] = new int[count];
        int k =0;
        for(int i = 2; i <= n; i++) {
            if(prime[i] == true)
                arr[k++] = i;
        }
       return arr;
    }
    private static long solve(int n) {
        // p1, p2... pk are the primes from 1 to n
        //no. of divisors = (a+1)(b+1)...k
        // a = n/p1 +n/p1^2 .... till pq^k <=n

        long result = 1;
        for(int i =0; primes[i]<=n;i++ ){
            long sum=0;
            int p =primes[i];
            while((n/p) !=0){
                sum=(sum+(n/p))%mod;
                p= (p * p)%mod;
            }
            result = (result * ((sum+1)%mod))%mod;

        }
        return result;
    }
}
