import java.util.ArrayList;

class Solution {

    class TrieNode {
        
        public TrieNode[] children;
        String word;
    
        public TrieNode() {
            children = new TrieNode[26];
            word = null;
        }
    
        public boolean hasNode(char c) {
            if (c == '#')
                return false;
            else
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
    
    class Trie {
        
        TrieNode root;
        
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
    }

    Trie trie;
    int m, n;
    char[][] board;
    List<String> res;

    public List<String> findWords(char[][] board, String[] words) {
        trie = new Trie();
        for (int i = 0; i<words.length; i++)
            trie.insert(words[i]);

        m = board.length;
        n = board[0].length;
        this.board = board;
        res = new ArrayList<String>();
        for (int i = 0; i<m; i++)
            for (int j = 0; j<n; j++)
                dfs(i, j, trie.root);
        return res;
    }

    public void dfs(int i, int j, TrieNode node) {
        char c = board[i][j];
        if (node.hasNode(c))
            node = node.getNode(c);
        else
            return;
        if (node.word != null) {
            res.add(node.word);
            node.word = null;
        }

        board[i][j] = '#';
        if (i>0)
            dfs(i-1, j, node);
        if (j>0)
            dfs(i, j-1, node);
        if (i<m-1)
            dfs(i+1, j, node);
        if (j<n-1)
            dfs(i, j+1, node);
        board[i][j] = c;
    }
}
