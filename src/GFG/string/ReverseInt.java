package string;

class ReverseInt {
    public static int reverse(int n) {
        //normal
        int r=0, d =0, prev=0 ;
        boolean isNeg = n<0?true:false;
        if(isNeg) {
            n= -1 * n;
        }
        while(n>0){
                d = n % 10 + d * 10;

                if((d- n%10)/10 != prev){
                    System.out.println("WARNING NUMBER OVERFLOWED !!!");
                    return 0;
                }
                prev = d;
                n = n / 10;
        }
        return isNeg? -d:d;
    }

    public static void main(String[] args) {
        System.out.println(reverse(-214748364));
    }
}