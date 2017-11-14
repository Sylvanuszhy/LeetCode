import java.util.ArrayList;

class Solution {
    public List<String> generatePossibleNextMoves(String s) {
        ArrayList res = new ArrayList<String>();
        for (int i = 1; i<s.length(); i++)
            if (s.charAt(i-1) == '+' && s.charAt(i) == '+') {
                StringBuilder t = new StringBuilder(s);
                t.setCharAt(i-1, '-');
                t.setCharAt(i, '-');
                res.add(t.toString());
            }
        return res;
    }
}
