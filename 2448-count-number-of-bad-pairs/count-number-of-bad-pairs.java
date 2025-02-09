class Solution {
    public long countBadPairs(int[] nums) {
        int n = nums.length;
        long goodPairCount = 0;
        Map<Integer, Long> differenceFrequencies = new HashMap<>(); // Use Long for frequencies

        for (int i = 0; i < n; i++) {
            int difference = nums[i] - i;
            long frequency = differenceFrequencies.getOrDefault(difference, 0L); // Get with default 0L
            goodPairCount += frequency;
            differenceFrequencies.put(difference, frequency + 1);
        }

        long totalPairs = (long) n * (n - 1) / 2; // Cast n to long for accurate calculation

        return totalPairs - goodPairCount;
    }
}