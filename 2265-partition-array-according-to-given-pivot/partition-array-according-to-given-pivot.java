class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int n = nums.length;
        int[] temp = new int[n];
        int index = 0;
        int count = 0;
        for(int i : nums){
            if(i < pivot) temp[index++] = i;
            else if (i == pivot) count++;
        }

        for(int i = 0; i < count; i++) temp[index++] = pivot;

        for(int i : nums)if(i > pivot) temp[index++] = i;

        return temp;
    }
}