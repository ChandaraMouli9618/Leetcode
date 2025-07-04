class Solution {
    public char kthCharacter(long k, int[] operations) {
        int n = operations.length;
        long[] lengths = new long[n + 1];
        lengths[0] = 1;

        // Precompute lengths
        for (int i = 0; i < n; i++) {
            if (operations[i] == 0) {
                lengths[i + 1] = lengths[i] * 2;
            } else {
                lengths[i + 1] = lengths[i] * 2;
            }

            // Prevent overflow
            if (lengths[i + 1] > k) {
                lengths[i + 1] = k;
            }
        }

        // Backtrack
        return (char) helper(k - 1, operations, lengths, n);
    }

    private int helper(long index, int[] operations, long[] lengths, int step) {
        if (step == 0) {
            return 'a';
        }

        long half = lengths[step - 1];
        if (index < half) {
            // It's in the first half
            return helper(index, operations, lengths, step - 1);
        } else {
            int ch = helper(index - half, operations, lengths, step - 1);
            if (operations[step - 1] == 0) {
                return ch;
            } else {
                // Shift character
                return (ch == 'z') ? 'a' : ch + 1;
            }
        }
    }
}
