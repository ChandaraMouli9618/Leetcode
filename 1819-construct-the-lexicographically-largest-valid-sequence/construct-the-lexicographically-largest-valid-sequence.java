import java.util.Arrays;

class Solution {
    public int[] constructDistancedSequence(int n) {
        int[] res = new int[2 * n - 1];
        boolean[] used = new boolean[n + 1];

        if (solve(0, res, used, n)) {
            return res;
        }
        return new int[0]; // Should not happen, but good practice to handle.
    }

    private boolean solve(int index, int[] res, boolean[] used, int n) {
        if (index == res.length) {
            return true;
        }

        if (res[index] != 0) { // Check for 0, not -1, as array initializes to 0
            return solve(index + 1, res, used, n);
        }

        for (int num = n; num >= 1; num--) {
            if (used[num]) {
                continue;
            }

            int nextIndex = (num == 1) ? index : index + num;

            if (nextIndex < res.length && res[nextIndex] == 0) { // Check bounds and if the next position is free
                used[num] = true;
                res[index] = num;
                if (num != 1) {
                    res[nextIndex] = num;
                }

                if (solve(index + 1, res, used, n)) {
                    return true;
                }

                // Backtrack: Important! Reset for the next iteration
                used[num] = false;
                res[index] = 0;
                if (num != 1) {
                    res[nextIndex] = 0;
                }
            }
        }
        return false;
    }
}