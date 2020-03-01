package leetcode.amazonAndMicrosoft.searchingAndSorting;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BitonicBinarySearch {


    public static void main(String[] args) {
        int a[] = new int[]{ 101, 103, 106, 109, 158, 164, 182, 187, 202, 205, 2, 3, 32, 57, 69, 74, 81, 99, 100};
        int b = 202;
        System.out.println(searchSol((List<Integer>)Arrays.stream(a).boxed().collect(Collectors.toList()),b));

    }


    //correct solutopn
    // DO NOT MODIFY THE LIST
    public static int searchSol(final List<Integer> a, int b) {
        int i=0;
        int j=a.size()-1;

        while(i<=j) {
            int mid = (i +j)/2;

            if(a.get(mid)==b)
                return mid;
            //here if mid > i , then i am in the first slope(bigger one)
            if(a.get(mid)>=a.get(i)) {
                //if it is in the first slope
                if(b>=a.get(i)&&b<a.get(mid))
                    j=mid-1;
                else
                    i=mid+1;
            }
            else {
                //here if mid < i , then i am in the second slope(smaller one)
                if(b>a.get(mid)&&b<=a.get(j))

                    i=mid+1;
                else
                    j=mid-1;
            }
        }
        return -1;
    }

}
