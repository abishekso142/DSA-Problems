package leetcode;


public class BuyAndSellStock
{

    public static void main(String[] args)
    {
        System.out.println(maxProfit1(new int[] {7,6,4,3,1}));

    }
    
    //https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
    public static int maxProfit(int[] prices) {
        
        /* Brute force
         
         int profit = 0;
         
         for(int i = 0; i < prices.length; i++){
             for(int j = i+1; j < prices.length; j++){
                 profit = Math.max(profit,prices[j] - prices[i]);
             }
         }
         return profit; */
         
         int profit = 0, mincp = Integer.MAX_VALUE;
         for(int i = 0; i < prices.length; i++){
             mincp = Math.min(mincp,prices[i]);
             profit = Math.max(profit,prices[i]-mincp);
         }
         return profit;
     }
    
    //https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
    public static int maxProfit1(int[] prices) {
        
        boolean hold = true;
        int profit = 0;
        
        for(int i = 0 ; i < prices.length; i++) {
            if(i>0 && hold && (prices[i] > prices[i-1])) {
                profit+= prices[i]-prices[i-1];
                hold= false;
            }
            if(i < (prices.length-1) && hold==false && (prices[i+1] > prices[i])) {
                hold=true;
            }
        }
        
        return profit;
        
    }

}
