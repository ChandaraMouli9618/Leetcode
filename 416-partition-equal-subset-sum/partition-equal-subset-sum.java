class Solution {
    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if(sum % 2 != 0) return false;
        int[][] dp = new int[nums.length][sum/2+1];
        for(int[] arr : dp) Arrays.fill(arr, -1);
        return partitionUtil(0, sum/2, nums, dp);
    }

    boolean partitionUtil(int pos, int target, int[] nums, int[][] dp){
        if(target == 0) return true;
        if(target < 0) return false;
        if(pos >= nums.length) return false;
        if(dp[pos][target] != -1) return dp[pos][target] == 1 ? true : false;

        boolean currRes = partitionUtil(pos+1, target - nums[pos], nums, dp) 
            || partitionUtil(pos+1, target, nums, dp);
        
        dp[pos][target] = currRes ? 1 : 0;

        return currRes;
    }
}