package leetcode.amazon.arraysAndString;
/*Given a column title as appear in an Excel sheet, return its corresponding column number.

For example:

    A -> 1
    B -> 2
    C -> 3
    ...
    Z -> 26
    AA -> 27
    AB -> 28
    ...
Example 1:

Input: "A"
Output: 1
Example 2:

Input: "AB"
Output: 28
Example 3:

Input: "ZY"
Output: 701*/
public class ExcelSheetNumber {
    public static int titleToNumber(String s) {
        //
        int n =s.length();
        if(n==0)return 0;
        if(n==1){
            return s.charAt(0)-'A'+1;
        }
        int res =0;
        int base =26;
        for(int i =0;i<n;i++){
            res+=Math.pow(base,n-i-1) * (s.charAt(i)-'A'+1);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(titleToNumber("ACF"));
    }
}
