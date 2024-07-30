class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);
        int[] dp = new int[s.length()];
        Arrays.fill(dp, -1);
        return isSapceSeparatedExist(s, 0, dict, dp);
    }


boolean isSapceSeparatedExist(String s, int pos, Set<String> dict, int[] dp){
    if(s.length() == pos) return true;
    if(dp[pos] != -1) return dp[pos] == 1 ? true : false;

    for(int i = pos; i < s.length(); i++){
	    String currStr = s.substring(pos, i+1);
	    if(dict.contains(currStr)){
		    boolean currRes = isSapceSeparatedExist(s, i+1, dict, dp);
		    if(currRes) return true;
        }
    }
    dp[pos] = 0;
    return false;
}

}