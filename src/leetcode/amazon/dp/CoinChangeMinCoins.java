package leetcode.amazon.dp;

public class CoinChangeMinCoins {
    public static void main(String[] args) {
        int n = 11;
        int a[] = new int[]{1, 2, 5};
        System.out.println(minCoinsSpaceOptimised(a,3,n));

    }
//in this problem you have to check for each sum, the min no of coins using all a=coins
    private static int coinchangeminCoins(int[] a, int n) {
        int dp[][] =new int[n+1][a.length+1];
        for(int i =1;i<=n;i++){
            dp[i][0] = -1;
        }

        for(int  i =1;i<=n;i++){
            for(int  j =1;j<=a.length;j++){
                if(a[j-1] <= i){
                    if(dp[i-a[j-1]][j] != -1  && dp[i][j-1] != -1){
                       dp[i][j] = Math.min(1+dp[i-a[j-1]][j],dp[i][j-1] );
                    }else if(dp[i-a[j-1]][j] != -1){
                        dp[i][j] =1+dp[i-a[j-1]][j];
                    }else{
                        dp[i][j] =dp[i][j-1];
                    }
                }else{
                    dp[i][j] =dp[i][j-1];
                }
            }
        }
       return dp[n][a.length];
    }

    // m is size of coins array
    // (number of different coins)
    static int minCoinsSpaceOptimised(int coins[], int m, int V)
    {
        // table[i] will be storing
        // the minimum number of coins
        // required for i value. So
        // table[V] will have result
        int table[] = new int[V + 1];

        // Base case (If given value V is 0)
        table[0] = 0;

        // Initialize all table values as Infinite
        for (int i = 1; i <= V; i++)
            table[i] = Integer.MAX_VALUE;

        // Compute minimum coins required for all
        // values from 1 to V
        for (int i = 1; i <= V; i++)
        {
            // Go through all coins smaller than i
            for (int j = 0; j < m; j++)
                if (coins[j] <= i)
                {
                    int sub_res = table[i - coins[j]];
                    if (sub_res != Integer.MAX_VALUE
                            && sub_res + 1 < table[i])
                        table[i] = sub_res + 1;


                }

        }
        return table[V];

    }


}
