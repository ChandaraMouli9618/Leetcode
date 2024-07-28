class Solution {
    public int rob(int[] nums) {
        int n= nums.length;
        int res = 0;

        int a = nums[0];
        if(n == 1) return a;

        int b = Math.max(nums[0], nums[1]);
        if(n == 2) return b;

        for(int i = 2; i < n; i++){
            res = Math.max(b, a + nums[i]);
            a = b;
            b = res;
        }

        return res;
    }
}