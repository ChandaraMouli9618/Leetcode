class Solution {

    int[] X = new int[] { 1, -1, 0, 0 };
    int[] Y = new int[] { 0, 0, 1, -1 };
    int group = 2;
    Map<Integer, Integer> map = new HashMap<>();

    public int largestIsland(int[][] grid) {
        int n = grid.length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int size = dfs(i, j, n, grid);
                    res = Math.max(res, size);
                    map.put(group, size);
                    replaceSize(i, j, group, n, grid);
                    group++;

                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    int currSum = 0;
                    Set<Integer> groups = new HashSet<>();
                    for(int k = 0; k < X.length; k++){
                        if(i + X[k] < 0 || j + Y[k] < 0 || i + X[k] >= n || j + Y[k] >= n) continue;
                        int currGroup = grid[i + X[k]][j + Y[k]];

                        if(!groups.contains(currGroup)){
                            currSum += map.getOrDefault(currGroup, 0);
                            groups.add(currGroup);
                        }
                    }
                    res = Math.max(res, currSum + 1);
                    System.out.println(i + ", " + j + "  - " + res);
                }
            }
        }

        // for (int[] arr : grid) {
        //     System.out.println(Arrays.toString(arr));
        // }
        return res;
    }

    int dfs(int x, int y, int n, int[][] grid) {
        if (x < 0 || y < 0 || x >= n || y >= n || grid[x][y] != 1)
            return 0;

        grid[x][y] = 0;
        int currCount = 0;
        for (int i = 0; i < X.length; i++) {
            currCount += dfs(x + X[i], y + Y[i], n, grid);
        }
        grid[x][y] = -1;

        return currCount + 1;
    }

    void replaceSize(int x, int y, int size, int n, int[][] grid) {
        if (x < 0 || y < 0 || x >= n || y >= n || grid[x][y] != -1)
            return;
        grid[x][y] = size;

        for (int i = 0; i < X.length; i++) {
            replaceSize(x + X[i], y + Y[i], size, n, grid);
        }
    }
}