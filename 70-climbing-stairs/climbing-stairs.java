class Solution {
    int[] dp;
    public int climbStairs(int n) {
        dp = new int[n+1];
        Arrays.fill(dp, -1);
        return stairClimbWayCount(n);
    }

    int stairClimbWayCount(int n){
        if(n == 0) return 1;
        if(n < 0) return 0;
        if(dp[n] != -1) return dp[n];
        //System.out.println(n);
        return dp[n] = stairClimbWayCount(n-1) + stairClimbWayCount(n-2);
    }
}