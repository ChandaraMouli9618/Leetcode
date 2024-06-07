class Solution {
    public int findCenter(int[][] edges) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        for(int[] edge : edges){
            freq.put(edge[0], freq.getOrDefault( edge[0], 0)+1);
            freq.put(edge[1], freq.getOrDefault( edge[1], 0)+1);
        }
        int V = freq.size();
        for(Map.Entry<Integer, Integer> entry : freq.entrySet()){
            if(entry.getValue() == V-1) return entry.getKey();
        }

        return -1;
    }
}