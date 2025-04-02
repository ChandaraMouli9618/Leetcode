class Solution {
    public long maximumTripletValue(int[] nums) {
        int n = nums.length;
        int[] maxRight = new int[n];
        maxRight[n-1] = -1;

        for(int i = n-2; i >= 0; i--){
            maxRight[i] = Math.max(nums[i+1], maxRight[i+1]);
        }

        int leftMax = nums[0];
        long res = 0;
        for(int i = 1; i < n-1; i++){
            //System.out.println("Left Max : " + leftMax + ", Right max : " + maxRight[i] + ", " + "Num : " + nums[i]);
            res = Math.max(res, ((long)(leftMax-nums[i]) * maxRight[i]));
            leftMax = Math.max(leftMax, nums[i]);
        }

        return res;
    }
}