package string;

public class AtoiI {
    public static int myAtoi(String str) {
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

    public static void main(String[] args) {
        System.out.println(myAtoi("2147483649"));
    }

}
