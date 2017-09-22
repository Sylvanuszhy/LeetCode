import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> res = new ArrayList<String>();
        if (s.length()<10)
            return res;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('A', 0);
        map.put('C', 1);
        map.put('G', 2);
        map.put('T', 3);
        HashMap<Integer, Integer> dict = new HashMap<Integer, Integer>();
        int n = 0;
        for (int i = 0; i<10; i++) {
            n = (n<<2)+map.get(s.charAt(i));
        }
        dict.put(n, 1);
        for (int i = 10; i<s.length(); i++) {
            n = ((n<<2)+map.get(s.charAt(i))) & 0xFFFFF;
            Integer val = dict.get(n);
            if (val == null)
                dict.put(n, 1);
            else
                dict.put(n, val+1);
        }
        for (Map.Entry<Integer,Integer> e : dict.entrySet()) {
            Integer val = e.getValue();
            if (val>1) {
                Integer key = e.getKey();
                StringBuilder tmp = new StringBuilder();
                for (int i = 0; i<10; i++) {
                    int m = (key>>(2*i)) & 0x3;
                    switch (m) {
                        case 0: tmp.insert(0, "A"); break;
                        case 1: tmp.insert(0, "C"); break;
                        case 2: tmp.insert(0, "G"); break;
                        case 3: tmp.insert(0, "T"); break;
                    };
                }
                res.add(tmp.toString());
            }
        }
        return res;
    }
}
