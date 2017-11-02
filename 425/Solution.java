import java.util.ArrayList;
import java.util.Arrays;

class Solution {

    class TrieNode {
        
        public TrieNode[] children;
        ArrayList<String> candidates;

        public TrieNode() {
            children = new TrieNode[26];
            candidates = new ArrayList<String>();
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

    class Trie {

        TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode node = root;
            node.candidates.add(word);
            for (int i = 0; i<word.length(); i++) {
                char c = word.charAt(i);
                if (node.hasNode(c))
                    node = node.getNode(c);
                else
                    node = node.createNode(c);
                node.candidates.add(word);
            }
        }
    }

    public int n;
    public Trie trie;
    public String[] wordSquare;
    public List<List<String>> res;

    public List<List<String>> wordSquares(String[] words) {
        trie = new Trie();
        for (int i = 0; i<words.length; i++)
            trie.insert(words[i]);
        n = words[0].length();
        wordSquare = new String[n];
        res = new ArrayList<>();
        dfs(0);
        return res;
    }

    public void dfs(int k) {
        if (k == n) {
            res.add(new ArrayList<String>(Arrays.asList(wordSquare)));
        } else {
            ArrayList<String> candidates = findCandidates(k);
            for (int i = 0; i<candidates.size(); i++) {
                wordSquare[k] = (String)candidates.get(i);
                dfs(k+1);
            }
        }
    }

    public ArrayList<String> findCandidates(int k) {
        TrieNode node = trie.root;
        for (int i = 0; i<k; i++) {
            char c = wordSquare[i].charAt(k);
            if (node.hasNode(c))
                node = node.getNode(c);
            else
                return new ArrayList<String>();
        }
        return node.candidates;
    }
}
