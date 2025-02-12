class Solution {
    public int maximumSum(int[] nums) {
        int n = nums.length;
        int res = -1;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            int digitSum = getDigitSum(nums[i]);
            if(map.containsKey(digitSum)){
                int prevMaxDigitSum = map.get(digitSum);
                res = Math.max(res, nums[i] + prevMaxDigitSum);
                map.put(digitSum, Math.max(nums[i], prevMaxDigitSum));
            }
            else map.put(digitSum, nums[i]);
        }

        return res;
    }

    int getDigitSum(int num){
        int sum = 0;
        while(num != 0){
            sum += (num % 10);
            num /= 10;
        }
        return sum;
    }
}