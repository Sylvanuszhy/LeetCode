import java.util.ArrayList;

class Solution {
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        ArrayList res = new ArrayList<Integer>();
        int[][] island = new int[m][n];
        ArrayList a = new ArrayList<Integer>();
        a.add(0);
        int s = 0, t = 0;
        for (int k = 0; k<positions.length; k++) {
            int i = positions[k][0], j = positions[k][1];
            s++;
            island[i][j] = s;
            a.add(s);
            HashSet set = new HashSet<Integer>();
            if (i-1>=0 && island[i-1][j]>0) {
                set.add(find(island[i-1][j], a));
                union(island[i][j], island[i-1][j], a);
            }
            if (j-1>=0 && island[i][j-1]>0) {
                set.add(find(island[i][j-1], a));
                union(island[i][j], island[i][j-1], a);
            }
            if (i+1<m && island[i+1][j]>0) {
                set.add(find(island[i+1][j], a));
                union(island[i][j], island[i+1][j], a);
            }
            if (j+1<n && island[i][j+1]>0) {
                set.add(find(island[i][j+1], a));
                union(island[i][j], island[i][j+1], a);
            }
            t = t-set.size()+1;
            res.add(t);
        }
        return res;
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
