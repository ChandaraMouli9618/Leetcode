class Solution {
    public int subarraySum(int[] nums, int k) {
        
        HashMap<Integer, Integer> freq = new HashMap<>();
        int preSum = 0;
        int res = 0;
        freq.put(0, 1);

        for(int i : nums){
            preSum += i;
            freq.put(preSum, freq.getOrDefault(preSum, 0)+1);
            int reqNum = preSum-k;

            if(reqNum == preSum) res += freq.get(reqNum)-1;
            else res += freq.getOrDefault(reqNum, 0);
        }

        return res;
    }
}