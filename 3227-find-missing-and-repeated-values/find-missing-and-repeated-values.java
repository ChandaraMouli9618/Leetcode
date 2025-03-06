class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int length = grid.length;
        int[] freq = new int[length * length + 1];
        int[] res = new int[2];

        for(int[] arr : grid){
            for(int i : arr) freq[i]++;
        }

        for(int i = 1; i <= length * length; i++){
            if(freq[i] == 2) res[0] = i;
            else if(freq[i] == 0) res[1] = i;
        }

        return res;
    }
}