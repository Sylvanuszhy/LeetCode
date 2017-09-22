class Trie {

    TrieNode root;

    class TrieNode {
        
        boolean isEnd;
        public TrieNode[] children;
    
        public TrieNode() {
            children = new TrieNode[26];
            isEnd = false;
        }
    
        public boolean hasNode(char c) {
            return children[c-'a'] != null;
        }
    
        public TrieNode createNode(char c) {
            children[c-'a'] = new TrieNode();
            return getNode(c);
        }
    
        public TrieNode getNode(char c) {
            return children[c-'a'];
        }
    }
    
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode node = root;
        for (int i = 0; i<word.length(); i++) {
            char c = word.charAt(i);
            if (node.hasNode(c))
                node = node.getNode(c);
            else
                node = node.createNode(c);
        }
        node.isEnd = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node = root;
        for (int i = 0; i<word.length(); i++) {
            char c = word.charAt(i);
            if (node.hasNode(c))
                node = node.getNode(c);
            else
                return false;
        }
        return node.isEnd;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for (int i = 0; i<prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (node.hasNode(c))
                node = node.getNode(c);
            else
                return false;
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