package hashmap;

import java.util.*;

/*You have a collection of coins, and you know the values of the coins and the quantity of each type of coin in it. You want to know how many distinct sums you can make from non-empty groupings of these coins.

Example

For coins = [10, 50, 100] and quantity = [1, 2, 1], the output should be
possibleSums(coins, quantity) = 9.*/
public class DistinctSum {


    public static void main(String []args){
        int[] a = new int[20];
        int[] b = new int[1000];
        int i, count=0;
        Scanner sc = new Scanner(System.in);
        String input1 = sc.nextLine();
        String astr[] = input1.split(" ");
        for(i=0;i<astr.length;i++){
            a[i]=Integer.parseInt(astr[i]);
        }
        Stack st = new Stack();

        count=astr.length;
        for(i=0;i<count;i++){
            b[i] =sc.nextInt();
        }
        st =func(a, b, count, -1, st, 0);
        i=-1;
        while(!st.empty()){
            b[++i]=(int)st.pop();
        }
        System.out.println(i);

    }
    public static Stack func(int[] a, int[] b, int count, int k, Stack st, int sum){
        if(k<count-1){
            int i, temp_sum;++k;

            for(i=0;i<=b[k];i++){
                temp_sum=i*a[k]+sum;
                st= func(a, b, count, k, st, temp_sum);
                st = push(temp_sum, st);

            }
        }
        return st;
    }

    public static Stack push(int sum, Stack st){
        if(st.search(sum)==-1){
            st.push(sum);
        }
        return st;
    }
}
