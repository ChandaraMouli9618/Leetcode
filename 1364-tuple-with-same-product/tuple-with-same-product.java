class Solution {
    public int tupleSameProduct(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for(int i = 0 ; i < n-1 ; i++){
            for(int j = i + 1; j < n; j++){
                int product = nums[i] * nums[j];
                int currFreq = map.getOrDefault(product, 0);
                res += (currFreq) * 8;
                map.put(product, currFreq+1);
            }
        }

        return res;
    }
}