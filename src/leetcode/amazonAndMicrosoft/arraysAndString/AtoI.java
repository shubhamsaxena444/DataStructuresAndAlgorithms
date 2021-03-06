package leetcode.amazonAndMicrosoft.arraysAndString;
/*Implement atoi which converts a string to an integer.

The function first discards as many whitespace characters as necessary until the first non-whitespace character is found. Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible, and interprets them as a numerical value.

The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function.

If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.

If no valid conversion could be performed, a zero value is returned.

Note:

Only the space character ' ' is considered as whitespace character.
Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. If the numerical value is out of the range of representable values, INT_MAX (231 − 1) or INT_MIN (−231) is returned.*/
public class AtoI {
    public int myAtoi(String str) {
        int res=0;
        int prev=0;
        str = str.trim();
        if(str.length() ==0) return 0;
        if(str.length() ==1 && (str.charAt(0) > '9' || str.charAt(0) < '0'))return 0;
        if((str.charAt(0) > '9' || str.charAt(0) < '0') && str.charAt(0)!='-' && str.charAt(0) != '+')return 0;
        boolean isMinus =false;
        boolean isPlus =false;
        int i =0;
        if(str.charAt(0) =='-'){
            isMinus =true;
            i++;
        }else if(str.charAt(0) =='+'){
            isPlus =true;
            i++;
        }
        while(i<str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9'){
            prev = res;
            res= res*10 + (str.charAt(i)-'0');
            if((res - (str.charAt(i)-'0'))/10 != prev){
                //overflow
                return isMinus?Integer.MIN_VALUE:Integer.MAX_VALUE;
            }
            i++;
        }

        return isMinus?-1*res:res;
    }
}
