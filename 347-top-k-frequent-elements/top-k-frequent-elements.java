class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        for(int i : nums){
            freq.put(i, freq.getOrDefault(i, 0)+1);
        }

        List<Integer>[] buckets = new List[nums.length+1];
        for(int num : freq.keySet()){
            int currFreq = freq.get(num);
            if(buckets[currFreq] == null) buckets[currFreq] = new ArrayList<>();
            buckets[currFreq].add(num);
        }
        
        int[] res = new int[k];
        int pos = 0;
        for(int i = buckets.length-1; i >= 0 && pos < k; i--){
            if(buckets[i] != null){
                for(int j = 0; j < buckets[i].size() && pos < k; j++){
                    res[pos] = buckets[i].get(j);
                    pos++;
                }
            }
        }

        return res;
    }
}