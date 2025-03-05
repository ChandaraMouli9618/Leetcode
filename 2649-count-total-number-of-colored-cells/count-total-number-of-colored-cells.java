class Solution {
    public long coloredCells(int n) {
        long ans = 1;

        for(int i = 2; i <= n; i++){
            ans += ( 2 * i + (i - 2) * 2);
        }

        return ans;
    }
}