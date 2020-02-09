package string;

public class CountAndSay
{

    public static String countAndSay(int n) {
        //using sliding window and recursion
        if(n == 1 ){
            return "1";
        }

        int i =0,j=0;
        String r="";
        //keep increasing the window as long as the there are duplicate numbers, else, append count(j-i) and number and
        // move ahead to the next char
        String num =  countAndSay(n-1);//String.valueOf(n);
        while(i < num.length() && j < num.length() && i<=j){
            if(j+1 <num.length() && num.charAt(j+1) == num.charAt(i)){
                j++;
            }else{
                r+= j-i +1;
                r+= num.charAt(i);
                i = j+1;
                j = i;
            }
        }
        return r;
    }




    public static void main(String[] args) {
        for (int i = 1; i < 31; i++) {
            System.out.println(countAndSay(i));
        }
    }
}
