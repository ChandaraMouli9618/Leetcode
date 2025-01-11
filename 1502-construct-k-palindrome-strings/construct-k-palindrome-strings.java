class Solution {
    public boolean canConstruct(String s, int k) {
        int n = s.length();

        if(n < k) return false;

        int[] charFreq = new int[26];
        for(char ch : s.toCharArray()) charFreq[ch-'a']++;
        
        int oddFreqCount = 0;
        for(int i : charFreq) if(i % 2 != 0) oddFreqCount++;
        if(oddFreqCount > k) return false;

        return true;
    }
}