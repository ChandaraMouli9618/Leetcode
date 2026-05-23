class Solution {
    public boolean check(int[] nums) {
        int breakPoint = 0;
        int n = nums.length;
        for(int i = 1;i < n; i++){
            if(nums[i] < nums[i-1]){
                breakPoint++;
                if(breakPoint > 1) return false;
            }
        }

        if(breakPoint == 1 && nums[0] < nums[n-1]) return false;
        return true;
    }
}