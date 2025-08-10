class Trie {
    class TrieNode {
        public Character c;
        public HashMap<Character, TrieNode> childeren;
        public boolean isWord;
        public TrieNode(Character c, boolean isWord) {
            this.c = c;
            this.childeren = new HashMap<>();
            this.isWord = isWord;
        }
    }

    TrieNode root;

    public Trie() {
        root = new TrieNode(null, false);
    }
    
    public void insert(String word) {
        if (word == null || word.isEmpty()) return;
        TrieNode temp = root;
        for(char c : word.toCharArray()) {
            if (temp.childeren.containsKey(c)) {
                temp = temp.childeren.get(c);
            } else {
                temp.childeren.put(c, new TrieNode(c, false));
                temp = temp.childeren.get(c);
            }
        }
        temp.isWord = true;
    }
    
    public boolean search(String word) {
        if (word == null) return false;
        if (word.isEmpty()) return true;
        TrieNode temp = root;
        for(char c : word.toCharArray()) {
            if (temp.childeren.containsKey(c)) {
                temp = temp.childeren.get(c);
            } else {
                return false;
            }
        }
        return temp.isWord;
    }
    
    public boolean startsWith(String prefix) {
        if (prefix == null) return false;
        if (prefix.isEmpty()) return true;
        TrieNode temp = root;
        for(char c : prefix.toCharArray()) {
            if (temp.childeren.containsKey(c)) {
                temp = temp.childeren.get(c);
            } else {
                return false;
            }
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
