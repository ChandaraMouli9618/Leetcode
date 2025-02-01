class Solution {
    int[] X = new int[]{1, -1, 0, 0};
    int[] Y = new int[]{0, 0, 1, -1};
    public int largestIsland(int[][] grid) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = grid.length;
        int group = 2;
        int maxIsland = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0 ; j < n; j++){
                if(grid[i][j] == 1){
                    int res = dfs(i, j, n, grid, group);
                    maxIsland = Math.max(maxIsland, res);
                    map.put(group, res);
                    group++;
                }
            }
        }

        //for(int[] arr : grid) System.out.println(Arrays.toString(arr));

        for(int i = 0; i < n; i++){
            for(int j = 0 ; j < n; j++){
                if(grid[i][j] == 0){
                    Set<Integer> groupSet = new HashSet<>();
                    int currIslandSize = 0;
                    for(int k = 0; k < X.length; k++){
                        int adjX = i + X[k];
                        int adjY = j + Y[k];

                        if(adjX < 0 || adjX >= n || adjY < 0 || adjY >= n) continue;

                        int currGroup = grid[adjX][adjY];
                        if(groupSet.contains(currGroup)) continue;

                        currIslandSize += map.getOrDefault(currGroup, 0);
                        groupSet.add(currGroup);
                    }
                    maxIsland = Math.max(maxIsland, currIslandSize + 1);
                }
            }
        }

        return maxIsland;
    }

    int dfs(int x, int y, int n, int[][] grid, int group){
        if(x < 0 || y < 0 || x >= n || y >= n || grid[x][y] != 1) return 0;
        
        grid[x][y] = group;
        int currSize = 0;
        for(int i = 0; i < X.length; i++){
            currSize += dfs(x + X[i], y + Y[i], n, grid, group);
        }

        return currSize + 1;
    }
}