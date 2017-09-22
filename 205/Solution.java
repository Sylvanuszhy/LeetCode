import java.util.Arrays;

class Solution {
    public boolean isIsomorphic(String s, String t) {
        int[] s2t = new int[256];
        int[] t2s = new int[256];
        Arrays.fill(s2t, -1);
        Arrays.fill(t2s, -1);
        if (s.length() != t.length())
            return false;
        for (int i = 0; i<s.length(); i++) {
            char cs = s.charAt(i);
            char ct = t.charAt(i);
            if (s2t[(int)cs] != -1) {
                if (s2t[(int)cs] == (int)ct)
                    continue;
                else
                    return false;
            }
            if (t2s[(int)ct] != -1) {
                if (t2s[(int)ct] == (int)cs)
                    continue;
                else
                    return false;
            }
            if (s2t[(int)cs] == -1 && t2s[(int)ct] == -1) {
                s2t[(int)cs] = (int)ct;
                t2s[(int)ct] = (int)cs;
            }
        }
        return true;
    }
}
