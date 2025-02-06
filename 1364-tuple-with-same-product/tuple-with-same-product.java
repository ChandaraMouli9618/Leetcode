class Solution {
    public int tupleSameProduct(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0 ; i < n-1 ; i++){
            for(int j = i + 1; j < n; j++){
                int product = nums[i] * nums[j];
                map.put(product, map.getOrDefault(product, 0)+1);
            }
        }
        int res = 0;
        for(Integer key : map.keySet()){
            // System.out.println(key + " -> " + map.get(key));
            int freq = map.get(key);
                if(freq > 1){
                    res += ((freq * (freq-1))/2) * 8;
                }

        }

        return res;
    }
}