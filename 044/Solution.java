class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        boolean[][] f = new boolean[m+1][n+1];
        f[0][0] = true;
        for (int i = 0; i<m; i++)
            f[i+1][0] = false;
        for (int j = 0; j<n; j++)
            if (p.charAt(j) == '*')
                f[0][j+1] = f[0][j];
            else
                f[0][j+1] = false;
        for (int i = 0; i<m; i++)
            for (int j = 0; j<n; j++)
                if (p.charAt(j) == '*')
                    f[i+1][j+1] = f[i+1][j] || f[i][j+1];
                else
                    f[i+1][j+1] = f[i][j] && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?');
        return f[m][n];
    }
}
