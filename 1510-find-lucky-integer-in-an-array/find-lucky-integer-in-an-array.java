class Solution {
    public int findLucky(int[] arr) {
        Map<Integer, Integer> freq = new HashMap<>();
        for(int i : arr) freq.put(i, freq.getOrDefault(i, 0)+1);
        int res = -1;

        for(Map.Entry<Integer, Integer> entry : freq.entrySet()){
            int key = entry.getKey();
            int value = entry.getValue();
            if( key == value && key > res) res = key;
        }

        return res;
    }
}