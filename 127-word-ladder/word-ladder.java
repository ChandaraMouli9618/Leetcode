class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set = new HashSet<>(wordList);
        if(!set.contains(endWord)) return 0;
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(beginWord, 1));
        set.remove(beginWord);

        while(!queue.isEmpty()){
            Pair currPair = queue.poll();
            String word = currPair.word;
            Integer steps = currPair.steps;

            if(word.equals(endWord)) return steps;

            for(int i = 0; i < word.length(); i++){
                for(char ch = 'a'; ch <= 'z'; ch++){
                    char[] replacedCharArray = word.toCharArray();
                    replacedCharArray[i] = ch;
                    String replacedString = new String(replacedCharArray);

                    if(set.contains(replacedString)){
                        set.remove(replacedString);
                        queue.add(new Pair(replacedString, steps + 1));
                    }

                }
            }
        }

        return 0;
    }
}

class Pair{
    String word;
    Integer steps;

    Pair(String word, Integer steps){
        this.word = word;
        this.steps = steps;
    }
}