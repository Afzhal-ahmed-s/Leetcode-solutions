class Solution {
    public int maxProfit(int[] prices) {
     
        int length = prices.length;
        int maxProfit = 0;
        int cost = 0;
        int purchaseMin = prices[0];
        
        for(int i=1; i<length; i++){
            cost = prices[i] - purchaseMin;
            maxProfit = Math.max(maxProfit, cost);
            purchaseMin = Math.min(purchaseMin, prices[i]);
        }
        return maxProfit;
        
    }
}