class Solution {
    public int heightChecker(int[] heights) {
        int[] copy = heights.clone();
        Arrays.sort(copy);
        int res = 0;
        for(int i = 0 ; i < copy.length; i++) if(copy[i] != heights[i]) res++;
        return res;
    }
}