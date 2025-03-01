class Solution {
    public int[] applyOperations(int[] nums) {
        for(int i = 0; i < nums.length-1; i++){
            if(nums[i] == nums[i+1]){
                nums[i] *= 2;
                nums[i+1] = 0;
            }
        }

        int left = 0;
        int right = 0;
        
        //1 4 0 2 0 0


        while(right < nums.length){
            if(nums[right] != 0){
                nums[left++] = nums[right];
            }
            right++;
        }

        while(left < nums.length){
            nums[left++] = 0;
        }

        return nums;
    }
}