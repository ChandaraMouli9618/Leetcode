class Solution {
    public int[] searchRange(int[] nums, int target) {
        int start = getStartPos(target, nums);
        int end = getEndPos(target, nums);
        return new int[]{start, end};
    }

    int getStartPos(int target, int[] nums){
        int ans = -1;
        int left = 0;
        int right = nums.length - 1;

        while(left <= right){
            int mid = left + (right-left)/2;

            if(nums[mid] >= target){
                right = mid - 1;
                if(nums[mid] == target)ans = mid;
            }
            else{
                left = mid + 1;
            }
        }

        return ans;
    }

    int getEndPos(int target, int[] nums){
        int ans = -1;
        int left = 0;
        int right = nums.length - 1;

        while(left <= right){
            int mid = left + (right-left)/2;

            if(nums[mid] <= target){
                left = mid + 1;
                if(nums[mid] == target)ans = mid;
            }
            else{
                right = mid - 1;
            }
        }

        return ans;
    }
}