class Solution {
    public boolean doesValidArrayExist(int[] derived) {
        int n = derived.length;

        // Check for both assumptions of original[0]: 0 and 1
        return isValid(derived, 0) || isValid(derived, 1);
    }

    boolean isValid(int[] derived, int original0) {
        int n = derived.length;
        int[] original = new int[n];
        original[0] = original0;

        // Compute the rest of the original array
        for (int i = 0; i < n - 1; i++) {
            original[i + 1] = original[i] ^ derived[i];
        }

        // Check the cyclic dependency
        return (original[n - 1] ^ original[0]) == derived[n - 1];
    }
}