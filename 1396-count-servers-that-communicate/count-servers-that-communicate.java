class Solution {
    public int countServers(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;

        int serverCount = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1)serverCount++;
            }
        }
        
        int[] serversInRow = new int[m];
        for(int i = 0; i < m; i++){
            int currCount = 0;
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1)currCount++;
            }
            serversInRow[i] = currCount;
        }


        int[] serversInCol = new int[n];
        for(int i = 0; i < n; i++){
            int currCount = 0;
            for(int j = 0; j < m; j++){
                if(grid[j][i] == 1)currCount++;
            }
            serversInCol[i] = currCount;
        }
        
        int isolatedServerCount = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1 && serversInRow[i] + serversInCol[j] - 1 <= 1)
                isolatedServerCount++;
            }
        }

        // System.out.println(serverCount);
        // System.out.println(isolatedServerCount);

        return serverCount - isolatedServerCount;
    }

}