class Solution {
public int minimumTotal(List<List<Integer>> triangle){
	int n = triangle.size();
	int[][] dp = new int[n][n];
	for(int[] arr : dp) Arrays.fill(arr, -1);

	return minPathSum(0, 0, triangle, n, dp);
}

int minPathSum(int level, int pos, 
List<List<Integer>> triangle, int n, int[][] dp){

	if(level == n) return 0;
	if(dp[level][pos] != -1) return dp[level][pos];

	int leftPathSum = minPathSum(level+1, pos, triangle, n, dp);
	int rightPathSum = minPathSum(level+1, pos+1, triangle, n, dp);

	return dp[level][pos] = Math.min(leftPathSum, rightPathSum) + 
triangle.get(level).get(pos);
}


}