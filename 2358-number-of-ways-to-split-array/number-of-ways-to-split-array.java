class Solution {
    public int waysToSplitArray(int[] nums) {
        int len = nums.length;
        long currSum = 0;
        int res = 0;

        long arrSum = 0;
        for(int i : nums) arrSum += i;

        for(int i = 0; i < len-1; i++){
            currSum += nums[i];
            if(currSum >= arrSum - currSum) res++;
        }

        return res;
    }
}

