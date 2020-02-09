package CompetitiveProgrammingQuestions.numberTheory;

import java.util.Scanner;

public class CubeFreeNumbers {
    private static int getCubeFreePosition(int i) {
            return cubeFree[i];
    }
    static int num =    1000001;
    //n can range from 1 to 10^6
    static int[] cubeFree;

    static {
        cubeFree = new int[num];
    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int n[] = new int[t];
        //compute using seive logic, which is cubeFree till 10^6
        sieveOfEratosthenes(num);
        for(int i =0;i<t;i++){
            n[i] =sc.nextInt();
        }
        for(int i =0;i<t;i++) {
            int h = getCubeFreePosition(n[i]);

            if (h != 0) {
                System.out.println("Case " +( i + 1) + ": " + h);
            } else {
                System.out.println("Case " + (i + 1 )+ ": " + "Not Cube Free");
            }
        }
    }
    static void sieveOfEratosthenes(int n)
    {
        // Create a boolean array "prime[0..n]" and initialize
        // all entries it as true. A value in prime[i] will
        // finally be false if i is Not a prime, else true.
        boolean cubeF[] = new boolean[n];
        for(int i=0;i<n;i++)
            cubeF[i] = true;

        for(int p = 2; p*p*p <=n; p++)
        {
            // If prime[p] is not changed, then it is a prime
            if(cubeF[p] == true)
            {
                // Update all cubes of p that a=they aint cubefree
                for(int i = p*p*p; i < n; i += p*p*p)
                    cubeF[i] = false;
            }
        }
        int count =1;
        // Print all prime numbers
        for(int i = 1; i < n; i++)
        {
            if(cubeF[i] == true)
                cubeFree[i] = count++;
        }
    }

}
