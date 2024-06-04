class Solution {
    public int longestPalindrome(String s) {
        HashMap<Character, Integer> freq = new HashMap<>();
        for(char ch : s.toCharArray()) freq.put(ch, freq.getOrDefault(ch, 0)+1);

        int oddCount = 0;
        int sum = 0;

        for(Map.Entry<Character, Integer> entry : freq.entrySet()){
            int currFreq = entry.getValue();
            if(currFreq % 2 != 0) oddCount++;
            sum += currFreq;
        }
        if(oddCount > 0) oddCount--;
        return sum - oddCount;
    }
}