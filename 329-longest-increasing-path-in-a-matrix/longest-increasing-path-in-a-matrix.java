class Solution {
    int[] X = {0, 1, 0, -1};
    int[] Y = {1, 0, -1, 0};
    public int longestIncreasingPath(int[][] matrix) {
        int res = 0;
        int m = matrix.length;
        int n = matrix[0].length;

        int[][] dp = new int[m][n];
        for(int[] arr : dp) Arrays.fill(arr, -1);

        for(int row = 0; row < m; row++){
            for(int col = 0; col < n; col++){
                res = Math.max(res, LIPUtil(row, col, matrix, dp));
            }
        }

        return res;
    }

    int LIPUtil(int x, int y, int[][] matrix, int[][] dp){
        
        if(dp[x][y] != -1) return dp[x][y];
        int currRes = 0;

        for(int i = 0;i < X.length; i++){
            if( isSafe(x, y, i, matrix) ){
                currRes = Math.max(currRes, LIPUtil(x+X[i], y+Y[i], matrix, dp));
            }
        }

        return dp[x][y] = currRes+1;
    }

    boolean isSafe(int x, int y, int dir, int[][] matrix){
        int nextX = x+X[dir];
        int nextY = y+Y[dir];
        if( nextX < 0 || nextX >= matrix.length || 
                    nextY < 0 || nextY >= matrix[0].length || 
                    matrix[nextX][nextY] <= matrix[x][y])
            return false;
        
        return true;
    }
}