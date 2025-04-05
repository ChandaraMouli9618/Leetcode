class Solution {
    public int maxSubArray(int[] nums) {
        int maxSubArraySum = nums[0];
        int currSubArraySum = 0;

        for(int i : nums){
            currSubArraySum = Math.max(currSubArraySum + i, i);
            maxSubArraySum = Math.max(currSubArraySum, maxSubArraySum);
        }

        return maxSubArraySum;
    }
}