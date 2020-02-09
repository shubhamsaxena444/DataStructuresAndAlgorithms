package CompetitiveProgrammingQuestions.preRequisites;

import java.util.Scanner;

public class StockWithOneTransaction {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int prices[] = new int[n];
        for(int i =0;i<n;i++){
            prices[i] = in.nextInt();
        }
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < n; i++) {
            if (prices[i] < minprice)
                minprice = prices[i];
            else if (prices[i] - minprice > maxprofit)
                maxprofit = prices[i] - minprice;
        }
        System.out.print( maxprofit);
    }
}
