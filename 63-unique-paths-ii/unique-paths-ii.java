class Solution {
    public int uniquePathsWithObstacles(int[][] grid) {
        if(grid[0][0] == 1) return 0;
        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];
        dp[0][0] = 1;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1) continue;
                if(i > 0) dp[i][j] = dp[i-1][j];
                if(j > 0) dp[i][j] += dp[i][j-1];
            }
        }

        //for(int[] arr : dp) System.out.println(Arrays.toString(arr));
        
        return dp[m-1][n-1];
    }
}