class Solution {
    public int minimumLength(String s) {
        int n = s.length();

        int[] freq = new int[26];
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        int deletedCount = 0;
        for (int i : freq) {
            int triplets = i / 2;
            if (i % 2 == 0 && triplets > 0) triplets--;
            deletedCount += (triplets * 2);
        }

        return n - deletedCount;
    }
}