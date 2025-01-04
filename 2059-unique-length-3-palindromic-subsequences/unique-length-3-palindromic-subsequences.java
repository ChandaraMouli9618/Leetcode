class Solution {
    public int countPalindromicSubsequence(String s) {
        int[][] range = new int[26][2];
        boolean[][] dp = new boolean[26][26];
        for(int[] arr : range){
            arr[0] = Integer.MAX_VALUE;
            arr[1] = Integer.MIN_VALUE;
        }

        for(boolean[] arr : dp){
            Arrays.fill(arr, false);
        }
        for(int i = 0; i < s.length(); i++){
            int charIndex = s.charAt(i)-'a';
            if(range[charIndex][0] >= i) range[charIndex][0] = i;
            if(range[charIndex][1] < i) range[charIndex][1] = i;
        }

        int res = 0;

        for(int i = 1; i < s.length()-1; i++){
            int charIndex = s.charAt(i) - 'a';
            for(int j = 0; j < 26; j++){
                if(dp[j][charIndex]) continue;
                if(range[j][0] < i && range[j][1] > i){
                    dp[j][charIndex] = true;
                    res++;
                }
            }
        }

        return res;
    }
}