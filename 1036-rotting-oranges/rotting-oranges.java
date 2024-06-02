class Solution {
    int[] X = {0, 1, 0, -1};
    int[] Y = {1, 0, -1, 0};

    public int orangesRotting(int[][] grid) {
        Queue<Integer[]> rottenOranges = new LinkedList<>();
        int m = grid.length;
        int n = grid[0].length;
        int minutes = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 2) rottenOranges.add(new Integer[]{i, j});
            }
        }

        while(!rottenOranges.isEmpty()){
            int size = rottenOranges.size();
            for(int j = 0; j < size; j++){
                Integer[] currNode = rottenOranges.poll();
                int x = currNode[0];
                int y = currNode[1];
                for(int i = 0; i < 4; i++){
                    if(isFreshOrange(x+X[i], y+Y[i], m, n, grid)){
                        // System.out.println((x+X[i])+" "+(y+Y[i]));
                        rottenOranges.add(new Integer[]{x+X[i], y+Y[i]});
                        grid[x+X[i]][y+Y[i]] = 2;
                    }
                }
            }
            minutes++;
        }
        // for(int i = 0; i < m; i++){
        //     for(int j = 0; j < n; j++){
        //         System.out.print(grid[i][j] + " ");
        //     }
        //     System.out.println();
        // }

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1) return -1;
            }
        }

        return minutes == 0 ? 0 : minutes-1;
    }

    boolean isFreshOrange(int x, int y, int m, int n, int[][] grid){
        if(x < 0 || y < 0 || x >= m || y >= n || grid[x][y] != 1) return false;
        return true;
    }
}