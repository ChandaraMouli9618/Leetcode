class Solution {
    public int minimumTotal(List<List<Integer>> triangle){
	    int n = triangle.size();
	    int[][] dp = new int[n][n];
	    for(int[] arr : dp) Arrays.fill(arr, -1);
        for(int i = 0; i < n; i++){
            dp[n-1][i] = triangle.get(n-1).get(i);
        }

	    for(int level = n-2; level >= 0; level--){
            for(int pos = level; pos >= 0; pos--){
	            int leftPathSum = dp[level+1][pos];
	            int rightPathSum = dp[level+1][pos+1];
	            dp[level][pos] = Math.min(leftPathSum, rightPathSum) + triangle.get(level).get(pos);
            }
        }
        
        return dp[0][0];
    }
}