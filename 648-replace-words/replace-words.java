class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        Set<String> prefixSet = new HashSet<>(dictionary);
        String[] words = sentence.split(" ");

        for(int i = 0; i < words.length; i++){
            String word = words[i];
            for(int j = 1; j <= word.length(); j++){
                if(prefixSet.contains(word.substring(0, j))){
                    words[i] = word.substring(0, j);
                    break;
                }
            }
        }

        String res = words[0];
        for(int i = 1; i < words.length; i++){
            res += ( " " + words[i]);
        }

        return res;
    }
}