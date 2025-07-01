class Solution {
    public int possibleStringCount(String word) {
        int sequenceCounter = 1;
        int i = 1;
        int n = word.length();
        int res = 0;

        while(i < n){
            if(word.charAt(i) != word.charAt(i-1)){
                res += (sequenceCounter - 1);
                sequenceCounter = 1;
            }
            else{
                sequenceCounter++;
            }
            i++;
        }

        return res + sequenceCounter;
    }
}