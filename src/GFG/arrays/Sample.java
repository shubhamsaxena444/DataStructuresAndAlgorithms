package GFG.arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class Sample {


    public static int solve(ArrayList<Integer> A) {
        if(A.size() == 0){
            return 0;
        }
        int count =0;
        int max = Integer.MIN_VALUE ,gcd=0, p=0,q=0;
        //find the maximum gcd for consecutive elements,then remove them, and recursively call the method until size is 0
        while(A.size() != 0)
        {
            max = Integer.MIN_VALUE;
            for(int i = 0 ;i<A.size()-1;i++){
                gcd = gcd(A.get(i),A.get(i+1));
                if(gcd > max){
                    max = gcd;
                    p=i;
                    q=i+1;
                }

            }
            A.remove(p);
            A.remove(q-1);
            count+= max;
        }
        return count;
    }



    static int gcd(int a, int b){
        if(a == 0){
            return b;
        }
        return gcd(b%a, a);
    }

    public static void main(String[] args) {
        ArrayList<Integer> l = new ArrayList<>(Arrays.asList(678,988,298,425,469,665,794,444));
        System.out.println(solve(l));
    }
}
