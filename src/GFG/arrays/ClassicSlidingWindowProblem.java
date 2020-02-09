package GFG.arrays;

import java.util.Scanner;
//find if a sum exists or not
public class ClassicSlidingWindowProblem {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int a[] = new int[n];
        for(int i =0;i<n;i++){
            a[i] = in.nextInt();
        }
        int s =0;
        int e=1;
        int slidingSum = a[s];
        for(;e<n;e++){
            //clean the previous window
            while(slidingSum>k && s<e-1){
                slidingSum-=a[s];
                s++;
            }
            if(slidingSum == k){
                System.out.println("true");
                for(int kk=s;kk<e;kk++){
                    System.out.print(a[kk]+" ");
                }
                return;
            }
            //increase the window
            if(e<n){
                slidingSum+=a[e];
            }

        }
        while(slidingSum>k && s<e-1){
            slidingSum-=a[s];
            s++;
        }
        if(slidingSum == k){
            System.out.println("true");
            for(int kk=s;kk<e;kk++){
                System.out.print(a[kk]+" ");
            }
            return;
        }else{
            System.out.println("false");
        }

    }
}
