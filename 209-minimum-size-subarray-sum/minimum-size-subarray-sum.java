class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int l = 0;
        int r = 0;
        int n = nums.length;
        int res = Integer.MAX_VALUE;
        int sum = 0;

        for(r = 0; r < n; r++){
            sum += nums[r];

            while(sum >= target){
                res = Math.min(res, r - l + 1);
                sum -= nums[l++];
            }
        }

        if(res == Integer.MAX_VALUE) return 0;
        return res;
    }
}