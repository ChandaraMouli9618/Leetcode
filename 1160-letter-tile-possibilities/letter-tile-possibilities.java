class Solution {
    public int numTilePossibilities(String tiles) {
        int[] freq = new int[26];
        for(char ch : tiles.toCharArray()) freq[ch - 'A']++;

        return countUniquetileArrangements(freq);
    }

    int countUniquetileArrangements(int[] freq){
        int currRes = 0;
        for(int i = 0; i < freq.length; i++){
            if(freq[i] != 0){
                freq[i]--;
                currRes += (countUniquetileArrangements(freq) + 1);
                freq[i]++;
            }
        }
        return currRes;
    }
}