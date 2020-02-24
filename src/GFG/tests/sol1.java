package GFG.tests;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.stream.Stream;

public class sol1 {
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in );
       // Arrays.stream(IntegertoBase(-12)).forEach(x-> System.out.print(x +" "));
//        solution(A,B)
    }

    public static  int[] solution(int[] A, int[] B) {
        // write your code in Java SE 8

//        long res = baseToInteger(A) + baseToInteger(B);

//        return IntegertoBase(res);
        return null;
    }

    static long baseToInteger(int[] arr) {
        long integerValue = 0;
        //handle base case
        if (arr.length == 0) {
            return 0;
        }

        long temp = 1;
        //start from least significant bit
        for (int i = 0; i < arr.length; i++) {
            int last_digit = arr[i];

            integerValue += last_digit * temp;

            temp = temp * (-2);
        }

        return integerValue;
    }

    static int[] IntegertoBase(int integerValue)
    {
        //handle base case
        if (integerValue == 0)
            return new int[]{0};

        LinkedList<Integer> a = new LinkedList<>();
        while (integerValue != 0) {
            int rem = integerValue % -2;
            integerValue /= -2;

            //since rem cant be negative, covert ot counter part (a-b)%r = (a%r -b%r +r)%r
            if (rem < 0) {
                rem += (2);
                integerValue += 1;
            }

            //add bit to linkedlist at the end
            a.addLast(rem);
        }
        // convert linkedlist to array;
        return a.stream().mapToInt(x -> x).toArray();
    }


    static int binaryToInteger(int[] arr){
        int dec_value = 0;

        // Initializing base
        // value to 1, i.e 2^0
        int base = 1;

        for (int i =arr.length-1;i>=0;i--) {
            int last_digit = arr[i];
            // temp = temp / 10;

            dec_value += last_digit * base;

            base = base * (2);
        }

        return dec_value;
    }


   static  int[] integerToBit(int n){
// array to store binary number
       LinkedList<Integer> a = new LinkedList<>();
       int[] binaryNum = new int[32];

       // counter for binary array
       int i = 0;
       while (n > 0) {
           // storing remainder in binary array
           a.addFirst( n % 2);
           n = n / 2;
           i++;
       }

        return a.stream().mapToInt(x -> x).toArray();
       // printing binary array in reverse order
//       for (int j = i - 1; j >= 0; j--)
//           System.out.print(binaryNum[j]);
   }

    /*static  int[] integerToBitBF(int n) {

        for(int i =Integer.MIN_VALUE;i<= Integer.MAX_VALUE;i++){
            int[] seed = integerToBit(i);
           int bitInteger = bitToInteger(seed);
           if(bitInteger ==n){
                return seed;
           }
        }
    return new int[]{};
    }*/
}
