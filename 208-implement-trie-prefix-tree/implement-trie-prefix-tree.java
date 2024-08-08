class Trie {

    TrieNode root;
    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode curr = root;
        for(char ch : word.toCharArray()){
            int ind = ch - 'a';
            if(curr.children[ind] == null){
                curr.children[ind] = new TrieNode();
            }
            curr = curr.children[ind];
        }
        curr.isEndOfWord = true;
    }
    
    public boolean search(String word) {
        TrieNode curr = root;
        for(char ch : word.toCharArray()){
            int ind = ch - 'a';
            if(curr.children[ind] == null) return false;
            curr = curr.children[ind];
        }

        return curr.isEndOfWord;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for(char ch : prefix.toCharArray()){
            int ind = ch - 'a';
            if(curr.children[ind] == null) return false;
            curr = curr.children[ind];
        }
        return true;
    }
}


class TrieNode{
    boolean isEndOfWord;
    TrieNode[] children;

    public TrieNode(){
        isEndOfWord = false;
        children = new TrieNode[26];
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */