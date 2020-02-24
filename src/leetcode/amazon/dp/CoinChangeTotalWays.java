package leetcode.amazon.dp;

import java.util.Arrays;

public class CoinChangeTotalWays {
//in this problem, you can start and check for 1 coin, and make all sums, but not in cointchangemincoins
    public static void main(String[] args) {
        int n = 10;
        int a[] = new int[]{2, 5, 3, 6};
        System.out.println(coinchangeSpaceOptimised(a,n));

    }

    private static int coinchange(int[] a, int n) {
        int dp[][] =new int[n+1][a.length+1];
        //if n ==0, then there will be exactly 1 way
        Arrays.fill(dp[0],1);
        //if there is no coin availalabe, then there will be 0 ways when a.length ==0
        for(int i =1;i<n+1;i++){
            for(int j =1;j<a.length+1;j++){
                //if a[j-1] >=i, then total ways will be includtion + excluding j-1th element
                if(a[j-1]<=i){
                    dp[i][j] = dp[i-a[j-1]][j] + dp[i][j-1];
                }else{
                    dp[i][j] =dp[i][j-1];
                }
            }
        }
        return dp[n][a.length];
    }

    //space optimised, we can just keep second dimention as 2
    private static long coinchangeSpaceOptimised(int[] a, int n) {
        long[] table = new long[n+1];
        Arrays.fill(table, 0);   //O(n)

        // Base case (If given value is 0)
        table[0] = 1;
        int m = a.length;
        // Pick all coins one by one and update the table[]
        // values after the index greater than or equal to
        // the value of the picked coin
        for (int i=0; i<m; i++)
            for (int j=a[i]; j<=n; j++)
                table[j] += table[j-a[i]];

        return table[n];
    }
    //when at most 1 coin sis allowed
    /*
    * 0

for coin-change problem, u can use forward or backward recurrence. in ur statement, u used backward. here i'll give a forward method, and it can easily solve UNLIMITED version and AT-MOST-ONCE version

suppose f is a 1D boolean array. f[i] means whether u can make change for value i. initially, f[0]=true, others equals false.

UNLIMITED version:

for (int i=1;i<=n;i++)
    for (int j=0;j<v;j++)
        if (f[j])
            f[j+x[i]]=true;
AT-MOST-ONCE version:

for (int i=1;i<=n;i++)
    for (int j=v-1;j>=0;j--)
        if (f[j])
            f[j+x[i]]=true;
the only difference is the order for loop j.

an example which helps u understand:

suppose there is only one kind of coin which cost 2. ie x[1]=2. and v=10

after the 1st algorithm, u can get f[0]=f[2]=f[4]=f[6]=f[8]=f[10]=true.

but for the 2nd algorithm, u can only get f[0]=f[2]=true.*/
}
