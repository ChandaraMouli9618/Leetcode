class Solution {
    public int minDifference(int[] nums) {
        if(nums.length <= 3) return 0;
        Arrays.sort(nums);
        return getMinDiff(3, 0, nums.length-1, nums);
    }

    int getMinDiff(int k, int i, int j, int[] arr){
        if(k == 0) return arr[j] - arr[i];
        
        return Math.min(
            getMinDiff(k-1, i+1, j, arr),
            getMinDiff(k-1, i, j-1, arr)
        );
    }
}