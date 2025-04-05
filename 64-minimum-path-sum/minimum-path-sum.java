class Solution {
    int[][] dp;
    public int minPathSum(int[][] grid) {
        dp = new int[grid.length][grid[0].length];
        for(int[] arr : dp) Arrays.fill(arr, -1);
        return minPathUtil(0, 0, grid);
    }

    int minPathUtil(int x, int y, int[][] grid){
        if(dp[x][y] != -1) return dp[x][y];

        if(x == grid.length-1 && y == grid[0].length-1) return grid[x][y];

        int right = Integer.MAX_VALUE;
        int down = Integer.MAX_VALUE;

        if(y < grid[0].length - 1) right = minPathUtil(x, y + 1, grid);
        if(x < grid.length - 1) down = minPathUtil(x + 1, y, grid);

        return dp[x][y] = Math.min(down, right) + grid[x][y];
    }
}