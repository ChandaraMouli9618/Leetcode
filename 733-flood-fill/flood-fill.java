class Solution {
    int[] X = {0, 1, 0, -1};
    int[] Y = {1, 0, -1, 0};

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int currCol = image[sr][sc];
        if(currCol != color) dfs(sr, sc, image.length, image[0].length, image, currCol, color);
        return image;
    }

    void dfs(int x, int y, int m, int n, int[][] image, int prevCol, int newCol){
        if(x < 0 || y < 0 || x >= m || y >= n || image[x][y] != prevCol) return;
        image[x][y] = newCol;
        for(int i = 0; i < 4; i++){
            dfs(x + X[i], y + Y[i], m, n, image, prevCol, newCol);
        }
    }
}