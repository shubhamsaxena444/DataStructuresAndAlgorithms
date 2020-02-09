package GFG.arrays;

import java.util.Arrays;

public class PlusOne {

    public static int[] plusOne(int[] digits) {
        if (digits.length ==0 ){
            return digits;
        }
        int sum =0;
        int carry =1;
        for(int i =digits.length-1;i>=0;i--) {
                sum = (digits[i] +carry)%10;
                carry = (digits[i] +carry)/10;
                digits[i] = sum;
        }
       if(carry!=0){
           int r[] = new int[digits.length+1];
           r[0]=carry;
           for(int i =1;i<r.length;i++){
               r[i]=digits[i-1];
           }
           return r;
       }
        return digits;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(plusOne(new int[]{1,0,9,9,9})));
    }
}
