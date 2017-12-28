import java.awt.List;
import java.util.ArrayList;

class Solution {
    
    public int k, n;
    public List<Integer> tmp = new ArrayList<Integer>();
    public List<List<Integer>> res = new ArrayList<List<Integer>>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        this.k = k;
        this.n = n;
        dfs(1, 1, 0);
        return res;
    }

    public void dfs(int t, int m, int s) {
        if (m>k) {
            if (s == n)
                res.add(new ArrayList<Integer>(tmp));           // why?
        } else {
            for (int i = t; i<=9; i++)
                if (s+i<=n) {
                    tmp.add(i);
                    dfs(i+1, m+1, s+i);
                    tmp.remove(tmp.size()-1);
                }
        }
    }
}
