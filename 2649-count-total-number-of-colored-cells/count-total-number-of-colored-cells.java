class Solution {
    public long coloredCells(int n) {
        long ans = 1;
        long max = n;

        if(--max > 0){
            ans += (long)(max * (2 * 4 + (max - 1)*4))/2;
        }

        return ans;
    }
}