class Solution {
    int[] dp;
    public int rob(int[] nums) {
        int n = nums.length;
        dp = new int[n+1];
        Arrays.fill(dp, -1);
        return solve(0, n, nums);
    }

    int solve(int pos, int n, int[] nums){
        if(pos >= n) return 0;
        if(dp[pos] != -1) return dp[pos];

        int pick = nums[pos] + solve(pos + 2, n, nums);
        int notPick = solve(pos + 1, n, nums);
        return dp[pos] = Math.max(pick, notPick);
    }
}