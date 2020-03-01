package GFG.tests;

import java.util.Scanner;

//pair with least energy
public class Rupeek {
    public static void main(String args[] ) throws Exception {
        /* Sample code to perform I/O:
         * Use either of these methods for input

        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name = br.readLine();                // Reading input from STDIN
        System.out.println("Hi, " + name + ".");    // Writing output to STDOUT

        //Scanner
        Scanner s = new Scanner(System.in);
        String name = s.nextLine();                 // Reading input from STDIN
        System.out.println("Hi, " + name + ".");    // Writing output to STDOUT

        */

        // Write your code here
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();

        long first = 0,second=0;


        //find how many 0s are there in the right
        int count = 0;
        long num = n;
        while(num%10 ==0){
            count++;
            num/=10;
        }
        if(count ==0){
            first =1;
        }else{
            first = (long)Math.pow(10,count-1);
        }
        second = n  - first;

        System.out.println( findEnergy(first) + findEnergy(second));

    }

    private static long findEnergy(long num) {
        long sum = 0;
        long n = num;
        while(n!=0){
            long lastDigit = n%10;
            sum+=lastDigit;
            n=n/10;
        }
        return sum;
    }
}
