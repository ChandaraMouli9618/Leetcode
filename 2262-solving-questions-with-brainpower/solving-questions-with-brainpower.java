class Solution {
    public long mostPoints(int[][] qs) {
        int n = qs.length;
        long[] dp = new long[n];
        Arrays.fill(dp, -1);
        return util(0, qs, dp, n);
    }

    long util(int pos, int[][] qs, long[] dp, int n){
        if(pos >= n) return 0;
        if(dp[pos] != -1) return dp[pos];

        long taken = util(pos + qs[pos][1] + 1, qs, dp, n) + qs[pos][0];
        long notTaken = util(pos+1, qs, dp, n);

        return dp[pos] = Math.max(taken, notTaken);
    }
}