class Solution {
    public int numWays(int n, int k) {
        if (n == 0 || k == 0)
            return 0;
        int[][] f = new int[n][2];
        f[0][0] = k;
        f[0][1] = 0;
        for (int i = 1; i<n; i++) {
            f[i][0] = (f[i-1][0]+f[i-1][1])*(k-1);
            f[i][1] = f[i-1][0];
        }
        return f[n-1][0]+f[n-1][1];
    }
}
