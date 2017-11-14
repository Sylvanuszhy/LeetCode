import java.util.ArrayList;

class Solution {

    public String word;
    public ArrayList<String> res;

    public List<String> generateAbbreviations(String word) {
        this.word = word;
        res = new ArrayList<String>();
        dfs(0, "", 0);
        return res;
    }

    public void dfs(int k, String s, int t) {
        if (k == word.length()) {
            String cnt = (t == 0) ? "" : String.valueOf(t);
            res.add(s+cnt);
        } else {
            dfs(k+1, s, t+1);
            String cnt = (t == 0) ? "" : String.valueOf(t);
            dfs(k+1, s+cnt+String.valueOf(word.charAt(k)), 0);
        }
    }
}
