class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int minLeft = prices[0];
        int res = 0;

        for(int i = 1; i < n; i++){
            res = Math.max(prices[i]-minLeft, res);
            minLeft = Math.min(minLeft, prices[i]);
        }
        
        return res;
    }
}