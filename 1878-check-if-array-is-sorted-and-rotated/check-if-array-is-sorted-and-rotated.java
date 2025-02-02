class Solution {
    public boolean check(int[] nums) {
        int n = nums.length;
        int breakPoint = 0;
        for(int i = 1; i < n; i++){
            if(nums[i] < nums[i-1]) breakPoint++;
        }

        if(breakPoint == 0) return true;
        return nums[0] >= nums[n-1] && breakPoint == 1;
    }
}