class Solution {
    public long gridGame(int[][] grid) {
        int n = grid[0].length;

        // Calculate the prefix sums for the two rows
        long[] prefixTop = new long[n + 1];
        long[] prefixBottom = new long[n + 1];

        for (int i = 0; i < n; i++) {
            prefixTop[i + 1] = prefixTop[i] + grid[0][i];
            prefixBottom[i + 1] = prefixBottom[i] + grid[1][i];
        }

        long result = Long.MAX_VALUE;

        // Simulate the first robot's transition at each column
        for (int i = 0; i < n; i++) {
            // Points left for the second robot in each case:
            // Top row (unvisited by the first robot)
            long topRemaining = prefixTop[n] - prefixTop[i + 1];
            // Bottom row (unvisited by the first robot)
            long bottomRemaining = prefixBottom[i];

            // The second robot will maximize its points
            long secondRobotPoints = Math.max(topRemaining, bottomRemaining);

            // The first robot minimizes the second robot's points
            result = Math.min(result, secondRobotPoints);
        }

        return result;
    }
}