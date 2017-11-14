import java.util.ArrayList;
import java.util.List;

public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder t = new StringBuilder();
        for (int i = 0; i<strs.size(); i++) {
            String s = strs.get(i);
            int len = s.length();
            t.append(len).append('#').append(s);
        }
        return t.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        ArrayList strs = new ArrayList<String>();
        int st = 0, pos = s.indexOf('#');
        while (pos != -1) {
            int len = Integer.valueOf(s.substring(st, pos));
            strs.add(s.substring(pos+1, pos+len+1));
            st = pos+len+1;
            pos = s.indexOf('#', st);
        }
        return strs;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));