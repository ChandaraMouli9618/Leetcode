class Solution {
    public int uniquePathsWithObstacles(int[][] o) {
        int m = o.length;
        int n = o[0].length;
        int[][] dp = new int[m][n];

        for(int i = 0 ; i < m; i++){
            for(int j = 0 ; j < n; j++){
                if(o[i][j] == 1) dp[i][j] = 0;
                else if(i == 0 && j != 0) dp[i][j] = dp[i][j-1];
                else if(i != 0 && j == 0) dp[i][j] = dp[i-1][j];
                else if(i != 0 && j != 0)dp[i][j] = dp[i-1][j] + dp[i][j-1];
                else dp[i][j] = 1;
            }
        }

        return dp[m-1][n-1];
    }
}