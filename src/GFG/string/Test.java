package string;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Arrays.*;

public class Test {

    private static class Stu {
        int roll;
        int marks;
        String name;

        public Stu(int roll, int marks, String name) {
            this.roll = roll;
            this.marks = marks;
            this.name = name;
        }

        public int getRoll() {
            return roll;
        }

        public void setRoll(int roll) {
            this.roll = roll;
        }

        public int getMarks() {
            return marks;
        }

        public void setMarks(int marks) {
            this.marks = marks;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public static void rotate(int[] arr, int d) {

        //
        /* Your class should be named ArrayRotate
         * Don't write main().
         * Don't read input, it is passed as function argument.
         * No need to print or return the output.
         * Taking input and printing the output is handled automatically.
         */
        int n = arr.length;
        //reverse first d
        arr = rvereseArray(arr,0,(d%n)-1);
        //reverse next n-d
        arr=  rvereseArray(arr,(d%n),n-1);
        //reverse n
        arr=  rvereseArray(arr,0,n-1);
        for(int i =0;i<n;i++) {
            System.out.print(arr[i]);
        if(i !=n-1){
            System.out.print(" ");
        }
        }
    }
    static  int[] rvereseArray(int arr[], int start, int end)
    {
        while (start < end)
        {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
        return arr;
    }
    static int xor(int arr[]){
       return stream(arr).reduce(0,(x,y)->{return x^y;});
    }

    public static void PairSum(int[] arr, int x) {
        /* Your class should be named TripletSum.
         * Don't write main().
         * Don't read input, it is passed as function argument.
         * Print output and don't return it.
         * Taking input is handled automatically.
         */
        //sort the arr in O(nlogn)
        sort(arr);
        int n = arr.length;


        //use 2 pointer approach to find a pair with sum = x-arr[i]
        pairSum(arr,0,n-1,0);

    }

  /*  private static void pairSum(int[] arr, int i ,int j, int k){
        //take 2 pointers x and y
        int x =i;
        int y = j;

        while(x<y){
            if(arr[x]+arr[y] == k){

                FoodSystem.out.println(arr[x]+ " " +arr[y]);
                x++;
          //      y--;
            }else if(arr[x]+arr[y] > k){
                y--;
            }else{
                x++;
            }
        }
        // return noTriplet;
    }*/


    public static void FindTriplet(int[] arr, int x){
        /* Your class should be named TripletSum.
         * Don't write main().
         * Don't read input, it is passed as function argument.
         * Print output and don't return it.
         * Taking input is handled automatically.
         */
        //sort the arr in O(nlogn)
        sort(arr);
        int n = arr.length;

        for(int i =0;i<n-2;i++){
            //use 2 pointer approach to find a pair with sum = x-arr[i]
            pairSum(arr,i+1,n-1,x-arr[i]);

        }
    }

    private static void pairSum(int[] arr, int i ,int j, int k){
        //take 2 pointers x and y
        int x =i;
        int y = j;

        while(x<y){
            if(arr[x]+arr[y] == k){

                System.out.println( arr[i-1]+ " " +arr[x]+ " " +arr[y]);
                x++;
                y--;
            }else if(arr[x]+arr[y] > k){
                y--;
            }else{
                x++;
            }
        }
        // return noTriplet;
    }





    private static int largestMinimumDistance(int[] arr, int c) {
        int d; //d will range from 0 to max-min element.
        //do binary search for d =0 to max-min
        sort(arr);
        int n = arr.length;
        return binarySearchArrangement(arr,0,arr[n-1]-arr[0],c);
    }

    private static int binarySearchArrangement(int[] arr, int s, int e,int c) {
        if(s>e){
            return -1;
        }
        int m = s+ (e-s)/2 ;
        //if m is possible && m+1 is not possible return m ,else if m is possible, search in m+1,e, else search in s,m-1
        boolean isPossible = isPossible(arr,m,c);
        if(isPossible && ( m+1>e || !isPossible(arr,m+1,c))){
            return m;
        }else if(isPossible){
            return binarySearchArrangement(arr,m+1,e,c);
        }else{
            return binarySearchArrangement(arr,s,m-1,c);
        }
    }

    private static boolean isPossible(int[] arr, int m,int c) {
        int count = c-1;
        int lastCowPlace = 0;
        for(int i =1;i<arr.length;i++){
            if(arr[i]-arr[lastCowPlace] >= m){
                count--;
                lastCowPlace = i;
            }
            if(count == 0){
                return true;
            }
        }
        return count!=0?false:true;
    }





    public static void main(String[] args) {

        // Scanner in = new Scanner(FoodSystem.in);
        //   int t = in.nextInt();
        // while(t-->0) {
       /* int n = in.nextInt();
        //  int c = in.nextInt();
        int[] price = new int[n];
        for (int i = 0; i < n; i++) {
            price[i] = in.nextInt();
        }

        int q = in.nextInt();
        //  int c = in.nextInt();
        int[] day = new int[q];
        for (int i = 0; i < q; i++) {
            day[i] = in.nextInt();
        }*/
//        momos(price,n,day,q);
        //    FoodSystem.out.println(inversionCount(price,0,price.length-1));
        //Arrays.stream(price).forEach(x-> {FoodSystem.out.print(x+",");});
        //}
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-->0) {
            int n = in.nextInt();
            int k = in.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }
            System.out.println(solve1(arr, n,k));
        }
    }

    private static int solve1(int[] arr, int n,int k) {
        Arrays.sort(arr);
        return n>k ? arr[n-k] : -1;
    }

    static int solve(int[] arr, int n){
        int min =Integer.MAX_VALUE;
        int t;
        //for earch i , i will visit again in i+tn time, and i will get ticket if i+tn>=a[i]
        for(int i =0;i<n;i++){
            t = (arr[i] - i)/n;
            if(arr[i]>i && (arr[i]-i)%n !=0){
                t+=1;
            }
            if((i+t*n)<min){
                min =i+t*n;
            }

        }
        return min%n+1;
    }
    private static void momos(int[] price, int n, int[] day, int q) {
        //calc the prefix sum of price array
        for(int i =1;i<n;i++){
            price[i] += price[i-1];
        }
        List<Integer> l = new ArrayList<Integer>();
        l= Arrays.stream(price).boxed().collect(Collectors.toList());
        //for each day , find the lower bound in price array with logn complexity and print the output
        //https://stackoverflow.com/questions/15603832/java-equivalent-of-c-equal-range-or-lower-bound-upper-bound
        for(int i =0;i<q;i++){
            int ind = Collections.binarySearch(l, day[i]);
            //if element is found , then the position of the element in price is the total momos had and money remaining is 0
            if(ind>=0){
                System.out.println(ind+1 +" "+ 0);
            }else if (ind == -1) {
                //there may be edge cases while calc lower_bound index, when ind = -1, in such case, momos had = 0, money left = day[i]
                System.out.println(0 +" "+ day[i]);
            }else
                //else, position of th e lower bound is the total momos had and q-lower_index is the money remaining.

                System.out.println(Math.abs(ind)-1 +" "+ (day[i] - price[Math.abs(ind)-2]));
        }
    }


    private static int inversionCount(int[] arr,int s, int e) {
    //devide the arr in 2 parts
        if(s>=e){
            return 0;
        }
        int m = s + (e-s)/2 ;
        int leftCount= inversionCount(arr,s,m);
        int rightCount = inversionCount(arr,m+1,e);
        int mergeCount = merge(arr,s,m+1,e);
        return  leftCount+ rightCount +    mergeCount;

    }

    private static int merge(int[] arr, int s, int m, int e) {
        int l_temp[] = new int[m-s];
        int r_temp[] = new int[e-m+1];
        int ln = m-s;
        int rn = e-m+1;
        System.arraycopy(arr, s, l_temp, 0, ln);
        System.arraycopy(arr, m, r_temp, 0, rn);
        //count the inversions for r_temp elements, for each r_temp element(if it is smaller) , the no of inversion is l_temp = length(l_temp)-l_temp[i]
        int i =0,j=0,k=s;
        int count=0;
        while(i<ln && j < rn){
            if(l_temp[i] <= r_temp[j]){
                arr[k++]=l_temp[i++];
            }else{
                arr[k++] = r_temp[j++];
                count+=ln-i;
            }
        }
        while (i<ln){
            arr[k++]=l_temp[i++];
        }
        while(j<rn){
            arr[k++] = r_temp[j++];
        }
        return count;
    }
}