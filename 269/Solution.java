import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

class Solution {
    public String alienOrder(String[] words) {
        HashMap<Character, Integer> inDegree = new HashMap<Character, Integer>();
        HashMap<Character, HashSet<Character>> adjacency = new HashMap<Character, HashSet<Character>>();
        for (String word : words)
            for (int i = 0; i<word.length(); i++)
                inDegree.put(word.charAt(i), 0);
        for (int i = 1; i<words.length; i++) {
            String s = words[i-1];
            String t = words[i];
            int k = 0;
            while (k<s.length() && k<t.length()) {
                char cs = s.charAt(k);
                char ct = t.charAt(k);
                if (cs != ct) {
                    HashSet<Character> nodes;
                    if (adjacency.containsKey(cs))
                        nodes = adjacency.get(cs);
                    else
                        nodes = new HashSet<Character>();
                    if (!nodes.contains(ct)) {
                        inDegree.put(ct, inDegree.get(ct)+1);
                        nodes.add(ct);
                        adjacency.put(cs, nodes);
                    }
                    break;
                }
                k++;
            }
        }

        Queue<Character> q = new LinkedList<Character>();
        for (Map.Entry<Character, Integer> entry : inDegree.entrySet())
            if (entry.getValue() == 0)
                q.add(entry.getKey());
        String order = "";
        while (!q.isEmpty()) {
            char u = q.remove();
            order += u;
            if (adjacency.containsKey(u)) {
                for (char v : adjacency.get(u)) {
                    int d = inDegree.get(v)-1;
                    inDegree.put(v, d);
                    if (d == 0)
                        q.add(v);
                }
            }
        }
        if (order.length() != inDegree.size())
            return "";
        else
            return order;
    }
}
