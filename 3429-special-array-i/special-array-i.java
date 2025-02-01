class Solution {
    public boolean isArraySpecial(int[] nums) {
        int mod = nums[0]%2;
        for(int i = 1; i < nums.length; i++){
            if(nums[i]%2 == mod) return false;
            mod = nums[i]%2;
        }
        return true;
    }
}