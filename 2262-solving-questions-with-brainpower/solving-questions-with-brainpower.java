class Solution {
    public long mostPoints(int[][] q) {
        int n = q.length;
        long[] dp = new long[n+1];

        for(int i = n-1; i >= 0; i--){
            int next = i + q[i][1] + 1;

            long taken = q[i][0] + (next > n ? 0 : dp[next]);
            long notTaken = dp[i+1];

            dp[i] = Math.max(taken, notTaken);
        }

        return dp[0];
    }
}