class Solution {
    public int numTeams(int[] nums) {
        int n = nums.length;
        int res = 0;
        for(int i = 1; i < n-1; i++){
            int curr = nums[i];
            int leftLess = 0;
            int leftMore = 0;

            int rightLess = 0;
            int rightMore = 0;

            for(int j = 0; j < i; j++){
                if(nums[j] < curr) leftLess++;
                else if(nums[j] > curr) leftMore++;
            }

            for(int j = i + 1; j < n; j++){
                if(nums[j] < curr) rightLess++;
                else if(nums[j] > curr) rightMore++;
            }

            res += ( (leftLess * rightMore) + ( leftMore * rightLess) );
        }

        return res;
    }
}