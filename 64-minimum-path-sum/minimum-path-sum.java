class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];
        for(int[] arr : dp) Arrays.fill(arr, -1);

        for(int i = m-1; i >= 0; i--){
            for(int j = n-1; j >= 0; j--){
                int right = Integer.MAX_VALUE;
                int down = Integer.MAX_VALUE;

                if(j < n-1) right = dp[i][j+1];
                if(i < m-1) down = dp[i+1][j];

                int currMin = Math.min(right, down);

                dp[i][j] = (currMin == Integer.MAX_VALUE ? 0 : currMin )  + grid[i][j];
            }
        }

        return dp[0][0];
    }
}