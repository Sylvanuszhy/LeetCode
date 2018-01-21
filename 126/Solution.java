class Solution {

    String[] words;
    HashMap<String, Integer> map;
    HashMap<Integer, ArrayList<Integer>> graph;
    String[] path;
    List<List<String>> res;

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        wordList.add(beginWord);
        HashSet<String> set = new HashSet<String>(wordList);
        words = set.toArray(new String[0]);
        int n = words.length;
        int m = words[0].length();
        map = new HashMap<String, Integer>();
        for (int i = 0; i<n; i++)
            map.put(words[i], i);

        res = new ArrayList<List<String>>();
        int st = map.get(beginWord);
        if (!map.containsKey(endWord))
            return res;
        int ed = map.get(endWord);

        Queue<Integer> q = new LinkedList<Integer>();
        q.add(st);
        boolean[] isVisited = new boolean[n];
        isVisited[st] = true;
        int[] level = new int[n];
        level[st] = 0;
        graph = new HashMap<Integer, ArrayList<Integer>>();
        int len = n;
        while (!q.isEmpty()) {
            int u = q.remove();
            if (level[u]>=len)
                break;
            char[] chs = words[u].toCharArray();
            for (int i = 0; i<m; i++) {
                char ch = chs[i];
                for (char j = 'a'; j<='z'; j++) {
                    if (ch == j)
                        continue;
                    chs[i] = j;
                    String ns = new String(chs);
                    if (map.containsKey(ns)) {
                        int v = map.get(ns);
                        if (!isVisited[v] || level[v] == level[u]+1) {
                            if (!isVisited[v]) {
                                q.add(v);
                                isVisited[v] = true;
                                level[v] = level[u]+1;
                            }
                            if (v == ed)
                                len = level[v];
                            ArrayList<Integer> e;
                            if (graph.containsKey(v))
                                e = graph.get(v);
                            else
                                e = new ArrayList<Integer>();
                            e.add(u);
                            graph.put(v, e);
                        }
                    }
                }
                chs[i] = ch;
            }
        }

        path = new String[n];
        path[0] = endWord;
        if (len<n)
            dfs(1, ed, st);
        return res;
    }

    public void dfs(int k, int v, int st) {
        if (v == st) {
            ArrayList<String> tmp = new ArrayList<String>();
            for (int i = k-1; i>=0; i--)
                tmp.add(path[i]);
            res.add(tmp);
        } else {
            ArrayList<Integer> e = graph.get(v);
            for (int u : e) {
                path[k] = words[u];
                dfs(k+1, u, st);
            }
        }
    }
}
