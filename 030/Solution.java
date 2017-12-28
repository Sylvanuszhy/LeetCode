import java.util.ArrayList;
import java.util.HashMap;

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        int n = words.length;
        HashMap<String, Integer> map = new HashMap<String, Integer>(n);
        for (String word : words) {
            if (map.containsKey(word))
                map.put(word, map.get(word)+1);
            else
                map.put(word, 1);
        }
        ArrayList<Integer> res = new ArrayList<Integer>();
        int len = words[0].length();
        for (int i = 0; i<len; i++) {
            HashMap<String, Integer> count = new HashMap<String, Integer>(map);
            int m = 0, st = i;
            for (int j = i; j<=s.length()-len; j += len) {
                String t = s.substring(j, j+len);
                if (count.containsKey(t)) {
                    while (count.get(t) == 0) {
                        String w = s.substring(st, st+len);
                        count.put(w, count.get(w)+1);
                        m--;
                        st += len;
                    }
                    m++;
                    count.put(t, count.get(t)-1);
                    if (m == n) {
                        res.add(st);
                        String w = s.substring(st, st+len);
                        count.put(w, count.get(w)+1);
                        m--;
                        st += len;
                    }
                } else {
                    count = new HashMap<String, Integer>(map);
                    m = 0;
                    st = j+len;
                }
            }
        }
        return res;
    }
}
