class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n-1)
            return false;
        int[] a = new int[n];
        for (int i = 0; i<n; i++)
            a[i] = i;
        for (int i = 0; i<edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int fu = find(u, a);
            int fv = find(v, a);
            if (fu == fv)
                return false;
            else
                a[fu] = fv;
        }
        return true;
    }

    public int find(int k, int[] a) {
        if (k != a[k])
            a[k] = find(a[k], a);
        return a[k];
    }
}
