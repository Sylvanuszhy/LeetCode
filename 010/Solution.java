class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] f = new boolean[m+1][n+1];
        f[0][0] = true;
        for (int i = 1; i<=m; i++)
            f[i][0] = false;
        for (int j = 0; j<n; j++)
            if (j>0 && p.charAt(j) == '*')
                f[0][j+1] = f[0][j-1];
            else
                f[0][j+1] = false;
        for (int i = 0; i<m; i++)
            for (int j = 0; j<n; j++)
                if (j>0 && p.charAt(j) == '*')
                    f[i+1][j+1] = f[i+1][j-1] || f[i][j+1] && isEqual(s.charAt(i), p.charAt(j-1));
                else
                    f[i+1][j+1] = f[i][j] && isEqual(s.charAt(i), p.charAt(j));
        return f[m][n];
    }

    public boolean isEqual(char a, char b) {
        return a == b || b == '.';
    }
}
