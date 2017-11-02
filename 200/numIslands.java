import java.util.ArrayList;
import java.util.HashSet;

class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        if (m == 0)
            return 0;
        int n = grid[0].length;
        int[][] island = new int[m][n];
        ArrayList a = new ArrayList<Integer>();
        HashSet set = new HashSet<String>();
        int s = -1;
        if (grid[0][0] == '1') {
            s++;
            island[0][0] = s;
            a.add(s);
        }
        for (int i = 1; i<m; i++)
            if (grid[i][0] == '1')
                if (grid[i-1][0] == '1') {
                    island[i][0] = island[i-1][0];
                } else {
                    s++;
                    island[i][0] = s;
                    a.add(s);
                }
        for (int j = 1; j<n; j++)
            if (grid[0][j] == '1')
                if (grid[0][j-1] == '1') {
                    island[0][j] = island[0][j-1];
                } else {
                    s++;
                    island[0][j] = s;
                    a.add(s);
                }
        for (int i = 1; i<m; i++)
            for (int j = 1; j<n; j++)
                if (grid[i][j] == '1') {
                    if (grid[i-1][j] == '1')
                        island[i][j] = island[i-1][j];
                    if (grid[i][j-1] == '1')
                        island[i][j] = island[i][j-1];
                    if (grid[i-1][j] == '0' && grid[i][j-1] == '0') {
                        s++;
                        island[i][j] = s;
                        a.add(s);
                    }
                    if (grid[i-1][j] == '1' && grid[i][j-1] == '1' && island[i-1][j] != island[i][j-1]) {
                        union(island[i-1][j], island[i][j-1], a);
                    }
                }
        for (int i = 0; i<a.size(); i++) {
            int k = find(i, a);
            set.add(k);
        }
        return set.size();
    }

    public void union(int p, int q, ArrayList a) {
        int pid = find(p, a);
        int qid = find(q, a);
        if (pid == qid)
            return;
        else
            a.set(pid, qid);
    }

    public int find(int r, ArrayList a) {
        int rid = (int)a.get(r);
        if (r != rid)
            a.set(r, find(rid, a));
        return (int)a.get(r);
    }
}
