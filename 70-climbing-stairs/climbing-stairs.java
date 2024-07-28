class Solution {
    int[] dp;
    public int climbStairs(int n) {
        dp = new int[n+1];
        Arrays.fill(dp, -1);
       return util(n);
    }

    private int util(int n){
        if(n < 0) return 0;
        if(n == 0) return 1;
        if(dp[n] != -1) return dp[n];
        return dp[n] = util(n-1) + util(n-2);
    }
}