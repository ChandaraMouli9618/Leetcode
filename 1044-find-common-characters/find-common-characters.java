class Solution {
    public List<String> commonChars(String[] words) {
        int[] baseFreq = new int[26];
        Arrays.fill(baseFreq, Integer.MAX_VALUE);
        List<String> res = new ArrayList<>();

        int[] currFreq = new int[26];
        for(String word : words){
            Arrays.fill(currFreq, 0);
            for(char ch : word.toCharArray()){
                currFreq[ch - 'a']++;
            }

            for(int i = 0; i < baseFreq.length; i++){
                baseFreq[i] = Math.min(baseFreq[i], currFreq[i]);
            }
        }

        for(int i = 0; i < baseFreq.length; i++){
            if(baseFreq[i] > 0)
            for(int j = 0; j < baseFreq[i]; j++){
                res.add((new Character((char)(i+'a'))).toString());
            }
        }

        return res;
    }
}