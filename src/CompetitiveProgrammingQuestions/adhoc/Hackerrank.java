package CompetitiveProgrammingQuestions.adhoc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Hackerrank {
    public static void main(String[] args) {

        List<Integer> l = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i =0;i<n;i++){
            l.add(sc.nextInt());
        }
        System.out.println(minX(l));
    }

    public Hackerrank() {
    }

    public static int minX(List<Integer> arr) {
        //lets create a prefix sum array
        int prefix[] = new int[arr.size()];
        prefix[0] = arr.get(0);
        for(int i =1;i<arr.size();i++){
            prefix[i] = arr.get(i)+ prefix[i-1];
        }
        int x;
        //find the min element in prefix
        int min = Arrays.stream(prefix).min().getAsInt();
        //at this point our live sume should be such that on addition with min, the sum is >=1

        //max value at this point should be
        x= 1-min;

        return x;
    }


}
