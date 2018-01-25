class Solution {

    class Trie {

        TrieNode root;

        class TrieNode {

            TrieNode[] children;
            String word;
    
            public TrieNode() {
                children = new TrieNode[26];
            }

            public boolean hasNode(char c) {
                return children[c-'a'] != null;
            }

            public TrieNode getNode(char c) {
                return children[c-'a'];
            }

            public TrieNode createNode(char c) {
                children[c-'a'] = new TrieNode();
                return getNode(c);
            }
        }

        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode node = root;
            for (int i = 0; i<word.length(); i++) {
                char c = word.charAt(i);
                if (node.hasNode(c))
                    node = node.getNode(c);
                else
                    node = node.createNode(c);
            }
            node.word = word;
        }

        public String findRoot(String word) {
            TrieNode node = root;
            for (int i = 0; i<word.length(); i++) {
                char c = word.charAt(i);
                if (node.hasNode(c)) {
                    node = node.getNode(c);
                    if (node.word != null)
                        return node.word;
                } else {
                    break;
                }
            }
            return word;
        }
    }
    
    public String replaceWords(List<String> dict, String sentence) {
        Trie trie = new Trie();
        for (String word : dict) {
            trie.insert(word);
        }
        String[] words = sentence.split(" ");
        for (int i = 0; i<words.length; i++) {
            words[i] = trie.findRoot(words[i]);
        }
        StringBuilder sb = new StringBuilder(words[0]);
        for (int i = 1; i<words.length; i++) {
            sb.append(' ');
            sb.append(words[i]);
        }
        return sb.toString();
    }
}
