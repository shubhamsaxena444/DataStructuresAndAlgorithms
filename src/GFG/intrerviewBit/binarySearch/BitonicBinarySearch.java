package GFG.intrerviewBit;
import java.util.*;
import java.util.stream.Collectors;

public class BitonicBinarySearch {
    public static int search(final List<Integer> A, int B) {
        int n = A.size();
        if(n==0)return -1;

        int pivotIndex =     findPivotIndex(A,0,n-1);
        System.out.println("pivot = " + pivotIndex);

        int s = 0;
        int e =n-1;
        if(pivotIndex!= -1 && B==A.get(pivotIndex)){
            return pivotIndex;
        }else if(pivotIndex!= -1 && B<A.get(pivotIndex) && B >= A.get(s)){
            //search with s, pivotIndex
            return  binarySearch(A,B,s,pivotIndex);
        }else{
            //search with  pivotIndex+1,end
            return   binarySearch(A,B,pivotIndex+1,e);
        }
    }

  static   int binarySearch(final List<Integer> A,int B, int s,int e){
        //
        if(s>e)return -1;
        int m = s+ (e-s)/2;
        //if a[m]>a[m-1] && a[m]>a[m+1]>>then this is pivot
        if(A.get(m) == B){
            return m;
        }else if(A.get(m)> B){
            //if a[m]>a[m-1] && a[m]<a[m+1]>>then pivot in in left half
            return binarySearch(A,B,s,m-1);
        }else{
            return binarySearch(A,B,m+1,e);
        }
    }
    //will return index of the pivot in case it is rotated or else it will //return -1

    /*
    6 7 0 1 2 3 4 5
    0 1 2 3 4 5 6 7
    s     m       e

    arr[mid] < arr[end]
    start, mid-1

    arr[mid] > arr[end]
    mid, end

    /
       /
        /
        /
    */
  static   int findPivotIndex(final List<Integer> A, int s,int e){
        //
        if(s>e)return -1;
        if(s==e)return -1;
        if(e == s+1){
            return A.get(s)>A.get(e) ? s: -1;
        }
        int m = s+ (e-s)/2;
        //if a[m]>a[m-1] && a[m]>a[m+1]>>then this is pivot
        if(A.get(m)>A.get(m-1) && A.get(m)>A.get(m+1)){
            return m;
        }else if(A.get(m) < A.get(e)){
            //if a[m]>a[m-1] && a[m]<a[m+1]>>then pivot in in left half
            return findPivotIndex(A,s,m-1);
        }else{
            return findPivotIndex(A,m+1,e);
        }
    }

    public static void main(String[] args) {
        int a[] = new int[]{ 101, 103, 106, 109, 158, 164, 182, 187, 202, 205, 2, 3, 32, 57, 69, 74, 81, 99, 100};
        int b = 202;
        System.out.println(search((List<Integer>)Arrays.stream(a).boxed().collect(Collectors.toList()),b));

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
