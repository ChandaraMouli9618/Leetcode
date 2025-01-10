class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        List<String> res = new ArrayList<>();
        int[] maxFreqs = new int[26];

        for (String word : words2) {
            int[] currFreq = countCharFreq(word);
            for (int i = 0; i < 26; i++)
                maxFreqs[i] = Math.max(maxFreqs[i], currFreq[i]);
        }

        for (String word : words1) {
            int[] baseWordFreq = countCharFreq(word);
            int i;

            for (i = 0; i < 26; i++) {
                if (baseWordFreq[i] < maxFreqs[i])
                    break;
            }
            if (i == 26)
                res.add(word);
        }

        return res;

    }

    int[] countCharFreq(String word) {
        int[] freq = new int[26];

        for (char ch : word.toCharArray()) {
            freq[ch - 'a']++;
        }

        return freq;
    }
}