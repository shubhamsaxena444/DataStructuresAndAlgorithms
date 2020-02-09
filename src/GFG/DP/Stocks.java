package GFG.arrays.DP;

public class Stocks {
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{}));
    };
    public static int maxProfit(int[] prices) {

        int n = prices.length ;
        if(n<=1){
            return 0;
        }
        int p[][] = new int[n][n];
        //the p table holds the maximum profit that can be made with int overflow
        for(int i =0;i<n-1;i++){
            for(int j =i+1;j<n;j++){
                if(i == 0){
                    p[i][j] = prices[j] - prices[i];
                }else{
                    p[i][j] = Math.max(prices[j] - prices[i],  Math.max(p[i-1][j],  Math.max(p[i][j-1], p[i-1][j-1])));
                }
            }
        }
        return p[n-2][n-1] < 0 ? 0: p[n-2][n-1] ;
    }
}
