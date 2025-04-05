class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int[] arr : dp) Arrays.fill(arr, -1);
        return pathCountUtil(0, 0, m, n, dp);
    }

    int pathCountUtil(int x, int y, int m, int n, int[][] dp){
        if(x == m || y == n) return 0;
        if(dp[x][y] != -1) return dp[x][y];
        if(x == m-1 && y == n-1) return 1;

        return dp[x][y] = pathCountUtil(x+1, y, m, n, dp) + pathCountUtil(x, y+1, m, n, dp);
    }
}