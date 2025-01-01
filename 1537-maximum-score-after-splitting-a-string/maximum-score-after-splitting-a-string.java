class Solution {
    public int maxScore(String s) {
        int zeroCount = 0;
        int oneCount = 0;
        int maxScore = 0;

        for(char ch : s.toCharArray()){
            if(ch == '1') oneCount++;
        }

        for(int i = 0; i < s.length()-1; i++){
            char ch = s.charAt(i);
            if(ch == '0') zeroCount++;
            else oneCount--;

            maxScore = Math.max(maxScore, zeroCount + oneCount);
        }

        return maxScore;
    }
}