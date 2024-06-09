class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> freq = new HashMap<>();
        freq.put(0, 0);
        int prefixSum = 0;
        int res = 0;

        for(int i = 0; i < n; i++){
            prefixSum += nums[i];
            int rem = prefixSum % k;
            rem = rem < 0 ? rem + k : rem;
            freq.put(rem, freq.getOrDefault(rem, -1)+1);
            res += freq.get(rem);
            System.out.println(rem + " " + freq.get(rem));
        }

        return res;
    }
}