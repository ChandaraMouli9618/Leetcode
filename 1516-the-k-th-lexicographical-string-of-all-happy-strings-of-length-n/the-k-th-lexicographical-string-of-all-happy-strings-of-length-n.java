class Solution {
    int count = 0;
    public String getHappyString(int n, int k) {
        return dfs(0, new StringBuilder(), k , n);
    }

    String dfs(int pos, StringBuilder currStr, int k, int n){
        if(pos == n){
            count++;
            return count == k ? currStr.toString() : "";
        }

        int currStrLen = currStr.length();
        for(char i = 'a'; i <= 'c'; i++){
            if(currStrLen == 0 || currStr.charAt(currStrLen-1) != i){
                currStr.append(i);
                String currRes = dfs(pos + 1, currStr, k , n);
                if(currRes.length() > 0) return currRes;
                currStr.deleteCharAt(currStrLen);
            }
        }
        return "";
    }
}