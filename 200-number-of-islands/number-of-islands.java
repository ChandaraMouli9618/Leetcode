class Solution {
    int[] X = {0, 1, 0, -1};
    int[] Y = {-1, 0, 1, 0};

    public int numIslands(char[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int res = 0;

        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(grid[i][j] == '1'){
                    makeIslandWater(i, j, row, col, grid);
                    res++;
                }
            }
        }

        return res;
    }

    void makeIslandWater(int x, int y, int row, int col, char[][] grid){
        if(x < 0 || y < 0 || x >= row || y >= col || grid[x][y] == '0') return;
        grid[x][y] = '0';

        for(int i = 0; i < 4; i++){
            makeIslandWater(x + X[i], y + Y[i], row, col, grid);
        }
    }
}