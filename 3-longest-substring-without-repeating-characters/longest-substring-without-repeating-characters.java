class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLen = 0;
        int n = s.length();
        boolean[] isVisited = new boolean[128];

        int left = 0;
        int right = 0;

        while(right < n){
            char currChar = s.charAt(right);
            while(isVisited[currChar] && left < right){
                isVisited[s.charAt(left++)] = false;
            }
            isVisited[currChar] = true;
            right++;
            maxLen = Math.max(maxLen, right-left);
            //System.out.println(Arrays.toString(isVisited));
            
        }

        return maxLen;
    }
}