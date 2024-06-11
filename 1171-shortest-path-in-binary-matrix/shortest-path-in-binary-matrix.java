class Solution {
    int[] X = {0, 1, 1, 1, 0, -1, -1, -1};
    int[] Y = {1, 1, 0, -1, -1, -1, 0, 1};
    boolean[][] isVisited;

    public int shortestPathBinaryMatrix(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        isVisited = new boolean[m][n];
        Queue<Integer[]> queue = new LinkedList<>();
        queue.add(new Integer[]{0, 0});
        int steps = 1;

        while(!queue.isEmpty()){
            int size = queue.size();

            for(int k = 0; k < size; k++){
                Integer[] coord = queue.poll();
                if(!isValid(coord[0], coord[1], m, n, grid)) continue;
                if(coord[0] == m-1 && coord[1] == n-1) return steps;

                isVisited[coord[0]][coord[1]] = true;
                for(int i = 0; i < 8; i++){
                    queue.add(new Integer[]{coord[0]+X[i], coord[1]+Y[i]});
                }
            }
            steps++;
        }
        return -1;
    }

    boolean isValid(int x, int y, int m, int n, int[][] grid){
        if(x < 0 || y < 0 || x >= m || y >= n || grid[x][y] == 1 || isVisited[x][y]) return false;
        return true;
    }

}