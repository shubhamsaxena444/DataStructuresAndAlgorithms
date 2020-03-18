package string;

import java.util.*;

public class xxx
{

    public static String plusMult(List<Integer> A) {
        // Write your code here
        Integer even=A.get(0);
        Integer odd=A.get(1)%2;
        int n =A.size();
        for(int i =0;i<n-4;i++){
            if(i%2==0){
               even = ((even%2) * (A.get(i+2)%2)%2 + A.get(i+4)%2)%2;

            }else{
                odd = ((odd%2) * (A.get(i+2)%2)%2 + A.get(i+4)%2)%2;
            }

        }
        if(odd >even){
            return "ODD";
        }else if(odd <even){
            return "EVEN";
        }else{
            return "NUETRAL";
        }
    }

    static void calculateSpan(List<Integer> prices)
    {
         int n =prices.size();
          int S[]= new int[n];
        // Create a stack and push index of first element
        // to it
        Stack<Integer> st = new Stack<>();
        st.push(prices.get(n-1));

        // Span value of first element is always 1
        S[n-1] = prices.get(n-1);

        // Calculate span values for rest of the elements
        for (int i = n-2; i >=0; i--) {

            // Pop elements from stack while stack is not
            // empty and top of stack is smaller than
            // price[i]
            while (!st.empty() && st.peek() > prices.get(i))
                st.pop();

            // If stack becomes empty, then price[i] is
            // greater than all elements on left of it, i.e.,
            // price[0], price[1], ..price[i-1]. Else price[i]
            // is greater than elements after top of stack
            S[i] = (st.empty()) ? prices.get(i) : (prices.get(i) - st.peek());

            // Push this element to stack
            st.push(prices.get(i));
        }
        int count =0;
        for(int i =0;i<n;i++){
            count += S[i];
        }
        System.out.println(count);
        for(int i =0;i<n;i++){
            if(prices.get(i) == S[i]){
                System.out.print(i + " ");
            }
        }
    }

    public static int numberOfPaths(List<List<Integer>> a) {
        // Write your code here
        //initial 2 d matrix
        int m = a.size();
        int n = a.get(0).size();
        int[][] memo = new int[m][n];
        //fill row and col if no obstruction
        if(a.get(0).get(0) ==1 ){
            memo[0][0] = 1;
        }
    //row
        for(int i =1;i<n;i++){
            if(a.get(0).get(i) ==1 ){
                memo[0][i] = memo[0][i-1];
            }

        }
        //col
        for(int i =1;i<m;i++){
            if(a.get(i).get(0) ==1 ){
                memo[i][0] = memo[i-1][0];
            }

        }
        for(int i =1;i<m;i++){
            for(int j =1;j<n;j++) {

                if (a.get(i).get(j) == 1) {
                    memo[i][j] = memo[i - 1][j] + memo[i][j-1];
                }
            }
        }
        return memo[m-1][n-1];
    }
    private static class pair{


        int s;
        int e;
        pair(int s,int e){
         this.s=s;
         this.e=e;
        }
}

    public static void main(String[] args) {
      /*  List<Integer> l = new ArrayList<>(Arrays.asList(2,3,1,2,4,2));
        //FoodSystem.out.println(plusMult(l));
        List<Integer> ll =Arrays.asList(5,1,3,4,6,2);
        List<List<Integer>> r = new ArrayList<>();
        r.add(Arrays.asList(1,1,1,1));
        r.add(Arrays.asList(1,1,1,1));
        r.add(Arrays.asList(1,1,1,1));
       // r.add(Arrays.asList(1,1,1,1));
        FoodSystem.out.println(numberOfPaths(r));
*/

//        Arrays.sort(a, new Comparator<pair>() {
//            @Override
//            public int compare(pair o1, pair o2) {
//                return o1.e-o2.e;
//            }
//        });
//        int m=0;
//        for(int i = 0;i<n;i++){
//            m+= Math.pow(2,i)*a[n-1-i];
//        }
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int d = sc.nextInt();
//        int t[] =new int[n];
//        int x[] =new int[n];
//        int y[] =new int[n];
        labour l[] =new labour[n];
        for(int i  =0;i<n;i++){
//            t[i] = sc.nextInt();
//            x[i] = sc.nextInt();
//            y[i] = sc.nextInt();
            l[i] = new labour(sc.nextInt(),sc.nextInt(),sc.nextInt());
        }
        Arrays.sort(l, new Comparator<labour>() {
            @Override
            public int compare(labour o1, labour o2) {
                int res=  o2.y - o1.y;
                if(o2.y - o1.y ==0){
                    return o1.x - o2.x;
                }
                return res;
            }
        });


        // iterate from high y to low y, if avaialable, then use him(if two with equal speed are available, use one with low cost, else continue)
        int curArea=0;
       int time=0;
       int cost=0;
        while(curArea < d) {
            for (int i = 0; i < n; i++) {
                if (l[i].y <= d - curArea && l[i].t <= time) {
                    curArea += l[i].y;
                    cost+=l[i].x;
                }
            }
            time++;
        }
        System.out.println(cost);
    }
    private static class labour{
        int t;
        int x;
        int y;

        labour(int t, int x, int y){
            this.t=t;
            this.x=x;
            this.y=y;
        }

    }
}
