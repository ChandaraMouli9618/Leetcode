class Solution {
    int res = 0;
    public int subsetXORSum(int[] nums) {
        if(nums.length == 0) return 0;
        subsetXORUtil(0, 0, nums);
        return res;
    }

    void subsetXORUtil(int pos, int currXOR, int[] nums){
        if(pos == nums.length){
            res += currXOR;
            return;
        }
        subsetXORUtil(pos + 1, currXOR ^ nums[pos], nums);
        subsetXORUtil(pos + 1, currXOR, nums);
    }
}