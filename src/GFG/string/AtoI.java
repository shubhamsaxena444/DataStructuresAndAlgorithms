package string;

public class AtoI {

    public static int myAtoi(String str) {
        double num = 0;
//        int prev =0;
        boolean isneg =false;
        if(str.length() ==0 || isFirstNonWhitespaceNotInteger(str)){
            return 0;
        }
        //check for int overflow , we keep previous sum in prev
        int i;
        for (i =0;i<str.length();i++){
            if(str.charAt(i) == ' '){
                continue;
            }else if(str.charAt(i) == '-'){
               isneg =true;
            }else if(str.charAt(i) == '+') {
                continue;
            }else{
                break;
            }
        }

        for(int j = i;j<str.length();j++){


           if(Character.isDigit(str.charAt(j))){
                num = num * 10 +   str.charAt(j)-'0' ;
//                if((num - (str.charAt(j)-'0'))/10 != prev){
//                    //overflow has occured,
//                    return isneg? Integer.MIN_VALUE: Integer.MAX_VALUE;
//                }
//                prev = num;
            }else{
               if(num > Integer.MAX_VALUE || num < Integer.MIN_VALUE){
                   return isneg ? Integer.MIN_VALUE: Integer.MAX_VALUE;

               }else{
                   return  isneg ? -(int)num : (int)num;
               }
           }
        }
        if(num > Integer.MAX_VALUE || num < Integer.MIN_VALUE){
            return isneg ? Integer.MIN_VALUE: Integer.MAX_VALUE;

        }else{
            return  isneg ? -(int)num : (int)num;
        }
    }

    private static boolean isFirstNonWhitespaceNotInteger(String str) {
        for(int i =0;i<str.length();i++){
            //check for consecutive -
            if((str.charAt(i) == '-' || str.charAt(i) == '+') && i < str.length()-1 && (str.charAt(i+1) == '-' ||  str.charAt(i+1) == '+')){
                return true;
            }
            if(str.charAt(i) == ' ' || str.charAt(i) == '-' || str.charAt(i) == '+'  ){
                continue;
            }else if(!Character.isDigit(str.charAt(i))){
                return true;
            }else{
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        System.out.println(myAtoi("-91283472332"));
    }
}
