class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        reverseArray(0, n-1, nums);
        reverseArray(0, k-1, nums);
        reverseArray(k, n-1, nums);
    }


    void reverseArray(int start, int end, int[] nums){
        while(start < end){
            int temp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = temp;
        }
    }
}