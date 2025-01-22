class Solution {
    public int[][] highestPeak(int[][] isWater) {
        int m = isWater.length;
        int n = isWater[0].length;
        int[][] heights = new int[m][n];
        for (int[] row : heights) {
            Arrays.fill(row, -1); // Initialize all cells as unvisited
        }

        Queue<int[]> queue = new LinkedList<>();

        // Initialize the queue with all water cells and set their heights to 0
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (isWater[i][j] == 1) {
                    heights[i][j] = 0;
                    queue.offer(new int[]{i, j});
                }
            }
        }

        // Directions for moving in the 4 cardinal directions (north, south, east, west)
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        // Perform BFS
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int x = cell[0], y = cell[1];
            for (int[] dir : directions) {
                int newX = x + dir[0];
                int newY = y + dir[1];

                // Check bounds and if the cell is unvisited
                if (newX >= 0 && newX < m && newY >= 0 && newY < n && heights[newX][newY] == -1) {
                    heights[newX][newY] = heights[x][y] + 1; // Set height
                    queue.offer(new int[]{newX, newY}); // Add to queue
                }
            }
        }

        return heights;
    }
}