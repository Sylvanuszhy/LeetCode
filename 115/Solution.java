class Solution {
    public int numDistinct(String s, String t) {
        int n = s.length(), m = t.length();
        int[][] f = new int[n+1][m+1];
        for (int i = 0; i<n; i++) {
            f[i][0] = 1;
            for (int j = 0; j<m; j++) {
                f[i+1][j+1] = f[i][j+1];
                if (s.charAt(i) == t.charAt(j))
                    f[i+1][j+1] += f[i][j];
            }
        }
        return f[n+1][m+1];
    }
}
