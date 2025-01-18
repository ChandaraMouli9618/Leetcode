class Solution {
    public int minCost(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        // Direction arrays for Right, Left, Down, Up
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        // Priority queue or deque for 0-1 BFS
        Deque<int[]> deque = new ArrayDeque<>();
        deque.offer(new int[]{0, 0, 0}); // {row, col, cost}

        // Visited array to store minimum cost to reach each cell
        int[][] visited = new int[m][n];
        for (int[] row : visited) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        visited[0][0] = 0;

        while (!deque.isEmpty()) {
            int[] current = deque.poll();
            int x = current[0], y = current[1], cost = current[2];

            // If we reach the bottom-right corner, return the cost
            if (x == m - 1 && y == n - 1) {
                return cost;
            }

            // Check all four possible directions
            for (int i = 0; i < 4; i++) {
                int nx = x + directions[i][0];
                int ny = y + directions[i][1];

                // Check if the next cell is within bounds
                if (nx >= 0 && ny >= 0 && nx < m && ny < n) {
                    int newCost = cost + (grid[x][y] == i + 1 ? 0 : 1);
                    if (newCost < visited[nx][ny]) {
                        visited[nx][ny] = newCost;
                        if (grid[x][y] == i + 1) {
                            deque.offerFirst(new int[]{nx, ny, newCost}); // Zero-cost move
                        } else {
                            deque.offerLast(new int[]{nx, ny, newCost}); // One-cost move
                        }
                    }
                }
            }
        }

        return -1;
    }
}