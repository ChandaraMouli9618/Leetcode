class FindSumPairs {

    Map<Integer, Integer> freq1, freq2;
    int[] nums1, nums2;

    public FindSumPairs(int[] nums1, int[] nums2) {
        this.nums1 = nums1;
        this.nums2 = nums2;

        freq1 = new HashMap<>();
        freq2 = new HashMap<>();

        for(int i : nums1) freq1.put(i, freq1.getOrDefault(i, 0) + 1);
        for(int i : nums2) freq2.put(i, freq2.getOrDefault(i, 0) + 1);
    }
    
    public void add(int index, int val) {
        int oldValue = nums2[index];
        int newValue = oldValue + val;

        int oldFreq = freq2.get(oldValue);
        if(oldFreq == 1) freq2.remove(oldValue);
        else freq2.put(oldValue, oldFreq-1);

        freq2.put(newValue, freq2.getOrDefault(newValue, 0) + 1);
        nums2[index] += val;
    }
    
    public int count(int tot) {
        int res = 0;
        for(Map.Entry<Integer, Integer> entry : freq1.entrySet()){
            int exisValue = entry.getKey();
            int exisFreq= entry.getValue();

            int reqValue = tot - exisValue;
            if(freq2.containsKey(reqValue)){
                int reqFreq = freq2.get(reqValue);
                int currCombinations = reqFreq * exisFreq;
                res += currCombinations;
            }
        }

        return res;
    }
}

/**
 * Your FindSumPairs object will be instantiated and called as such:
 * FindSumPairs obj = new FindSumPairs(nums1, nums2);
 * obj.add(index,val);
 * int param_2 = obj.count(tot);
 */