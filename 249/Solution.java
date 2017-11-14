import java.util.ArrayList;
import java.util.HashMap;

class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        HashMap map = new HashMap<String, ArrayList<String>>();
        for (int i = 0; i<strings.length; i++) {
            String s = strings[i];
            StringBuilder t = new StringBuilder();
            for (int j = 1; j<s.length(); j++) {
                int c = (s.charAt(j)-s.charAt(j-1)+26)%26;
                t.append((char)c);
            }
            String key = t.toString();
            ArrayList a;
            if (map.containsKey(key)) {
                a = (ArrayList)map.get(key);
            } else {
                a = new ArrayList<String>();
            }
            a.add(s);
            map.put(key, a);
        }
        ArrayList res = new ArrayList<ArrayList<String>>(map.values());
        return res;
    }
}
