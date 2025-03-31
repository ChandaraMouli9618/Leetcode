class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        if(n == 2) return Math.max(nums[0], nums[1]);

        return Math.max(
            linearHouseRobber(nums, 0, n-2),
            linearHouseRobber(nums, 1, n-1)
        );

    }

    int linearHouseRobber(int[] nums, int start, int end){

        int prev2 = nums[start];
        int prev1 = Math.max(nums[start], nums[start+1]);
        int current = prev1;

        for(int i = start+2; i <= end; i++){
            current = Math.max(prev2 + nums[i], prev1);
            prev2 = prev1;
            prev1 = current;
        }

        return current;
    }
}