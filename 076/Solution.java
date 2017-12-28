import java.util.HashMap;

class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int n = t.length();
        for (int i = 0; i<n; i++) {
            char c = t.charAt(i);
            if (map.containsKey(c))
                map.put(c, map.get(c)+1);
            else
                map.put(c, 1);
        }
        String minWin = "";
        int p = 0, q = 0;
        int m = 0;
        while (q<s.length()) {
            while (q<s.length() && !map.containsKey(s.charAt(q)))
                q++;
            if (q>=s.length())
                break;
            char c = s.charAt(q);
            map.put(c, map.get(c)-1);
            if (map.get(c) == 0)
                m++;
            if (m == map.size()) {
                c = s.charAt(p);
                while (!map.containsKey(c) || map.get(c)<0) {
                    if (map.containsKey(c) && map.get(c)<0)
                        map.put(c, map.get(c)+1);
                    p++;
                    c = s.charAt(p);
                }
                if (minWin == "" || minWin.length()>q-p+1)
                    minWin = s.substring(p, q+1);
            }
            q++;
        }
        return minWin;
    }
}
