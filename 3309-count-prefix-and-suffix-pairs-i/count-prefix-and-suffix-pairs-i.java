class Solution {
    public int countPrefixSuffixPairs(String[] words) {
        int n = words.length;
        int count = 0;
        for(int i = 0; i < n-1; i++){
            for(int j = i+1; j < n; j++){
                if(
                    isPrefixAndSuffix(words[i], words[j])
                ) count++;
            }
        }

        return count;
    }

    private boolean isPrefixAndSuffix(String a, String b){
        if(b.length() < a.length()) return false;

        int n = a.length();
        int m = b.length();
        String prefix = b.substring(0, n);
        String suffix = b.substring(m-n, m);

        if(a.equals(prefix) && a.equals(suffix)) return true;

        return false;
    }
}