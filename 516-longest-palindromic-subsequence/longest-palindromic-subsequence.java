class Solution {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for(int[] arr : dp) Arrays.fill(arr, -1);
        return LPSUtil(0, n-1, s, dp);
    }

    int LPSUtil(int left, int right, String s, int[][] dp){
        if(left == right) return 1;
        if(left > right) return 0;

        if(dp[left][right] != -1) return dp[left][right];

        int pick = Integer.MIN_VALUE;
        if(s.charAt(left) == s.charAt(right)){
            pick = LPSUtil(left+1, right-1, s, dp) + 2;
        }

        int leftInc = LPSUtil(left+1, right, s, dp);
        int rightDec = LPSUtil(left, right-1, s, dp);

        return dp[left][right] = Math.max(pick, Math.max(leftInc, rightDec));
    }
}