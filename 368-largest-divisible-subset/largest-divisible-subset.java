class Solution {
        public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return new ArrayList<>();
        }
        Arrays.sort(nums);

        // dp[i] stores the size of the largest divisible subset ending with nums[i]
        int[] dp = new int[n];
        // prev[i] stores the index of the previous element in the largest divisible subset ending with nums[i]
        int[] prev = new int[n];
        Arrays.fill(dp, 1);
        Arrays.fill(prev, -1);

        int maxSize = 1;
        int maxIndex = 0;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0) {
                    if (dp[i] < dp[j] + 1) {
                        dp[i] = dp[j] + 1;
                        prev[i] = j;
                        if (dp[i] > maxSize) {
                            maxSize = dp[i];
                            maxIndex = i;
                        }
                    }
                }
            }
        }

        // Reconstruct the largest divisible subset
        List<Integer> result = new ArrayList<>();
        int current = maxIndex;
        while (current != -1) {
            result.add(nums[current]);
            current = prev[current];
        }
        // The subset is built in reverse order, so reverse it if the order matters
        // Collections.reverse(result);

        return result;
    }
}