class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];

        
        int first = nums[0];
        int second = Math.max(nums[0], nums[1]);
        int current = second;

        for(int i = 2; i < n ;i++){
            current = Math.max(first + nums[i], second);
            first = second;
            second = current;
        }

        return current;
    }
}