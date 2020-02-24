package leetcode.google.arrays;

import java.util.Arrays;

/*Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also represented as a string.

Example 1:

Input: num1 = "2", num2 = "3"
Output: "6"
Example 2:

Input: num1 = "123", num2 = "456"
Output: "56088"
Note:

The length of both num1 and num2 is < 110.
Both num1 and num2 contain only digits 0-9.
Both num1 and num2 do not contain any leading zero, except the number 0 itself.
You must not use any built-in BigInteger library or convert the inputs to integer directly.*/
public class MultimplyStrings {
    public static void main(String[] args) {
        System.out.println(multiply("123", "12"));
    }

    public static String multiply(String num1, String num2){

    int n = num1.length();
    int m = num2.length();
        if(n==0||m==0||num1.equals("0")||num2.equals("0"))return"0";
    //since length of resultant number cannot be greater than n+m
    char[] res = new char[n + m];
        Arrays.fill(res,'0');
    //reverse the two nums
    num1 =new

    StringBuilder(num1).

    reverse().

    toString();

    num2 =new

    StringBuilder(num2).

    reverse().

    toString();
    //e.g, 123 * 12 == 321 *21
    //make num2 smaller
        if(m>n)

    {
        String temp = num1;
        num1 = num2;
        num2 = temp;
    }

    m =num2.length();
    n =num1.length();

    int carry = 0;
    int index = 0, sum, shift = 0;
        for(
    int i = 0;
    i<m;i++)

    {
        for (int j = 0; j < n; j++) {
            sum = (num2.charAt(i) - '0') * (num1.charAt(j) - '0') + carry;

            int lastdigit = sum % 10;
            carry = sum / 10;
            //add the previous index element
            int nextSum = lastdigit + (res[index] - '0');
            res[index++] = (char) ('0' + nextSum % 10);

            carry += nextSum / 10;
        }
        if (carry != 0) {
            res[index++] = (char) ('0' + carry);
            carry = 0;
        }
        shift++;
        index = shift;
    }

    String raw = new StringBuilder(String.valueOf(res)).reverse().toString();
    int r = 0;
        while(r<raw.length()&&raw.charAt(r)=='0')r++;
        return raw.substring(r);
}
}
