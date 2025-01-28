class Solution {

    int[] X = new int[]{0, 1, 0, -1};
    int[] Y = new int[]{1, 0, -1, 0};

    public int findMaxFish(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int res = 0;

        for(int i = 0; i < m ; i++){
            for(int j = 0 ; j < n; j++){
                if(grid[i][j] > 0){
                    res = Math.max(res, dfs(i, j, grid));
                }
            }
        }

        return res;
    }

    int dfs(int i, int j, int[][] grid){
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0) return 0;

        int totalFish = grid[i][j];
        grid[i][j] = 0;

        for(int k = 0; k < X.length; k++){
            totalFish += dfs(i + X[k], j + Y[k], grid);
        }

        return totalFish;
    }

    
}