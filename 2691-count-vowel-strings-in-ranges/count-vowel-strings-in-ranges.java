class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        Set<Character> charSet = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        int queryCount = queries.length;
        int[] cumCount = new int[words.length+1];
        cumCount[0] = 0;
        int[] res = new int[queryCount];

        for(int i = 0; i < words.length; i++){
            String word = words[i];
            if(charSet.contains(word.charAt(0)) && charSet.contains(word.charAt(word.length()-1))){
                cumCount[i+1] = cumCount[i]+1;
            }
            else{
                cumCount[i+1] = cumCount[i];
            }
            

        }

        for(int i = 0; i < queries.length; i++){
            int[] q = queries[i];
            res[i] = cumCount[q[1]+1] - cumCount[q[0]];
        }
        //System.out.println(Arrays.toString(cumCount));

        return res;
    }
}