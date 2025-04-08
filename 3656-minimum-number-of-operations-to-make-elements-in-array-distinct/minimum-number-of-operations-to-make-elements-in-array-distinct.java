class Solution {
    public int minimumOperations(int[] nums) {
        Set<Integer> elements = new HashSet<>();
        int n = nums.length;

        int[] uniqueCount = new int[n];
        for(int i = n-1; i >= 0; i--){
            elements.add(nums[i]);
            uniqueCount[i] = elements.size();
        }

        System.out.println(Arrays.toString(uniqueCount));

        int pos = 0;
        if(uniqueCount[0] == n) return (pos-1) / 3;
        while(pos < n){
            if(uniqueCount[pos] == n - pos) return (pos-1) / 3 + 1;
            pos += 3;
        }

        return (pos-1) / 3 + 1;
    }
}