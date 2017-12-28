class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length();
        int n = s2.length();
        if (m+n != s3.length())
            return false;
        boolean[][] f = new boolean[m+1][n+1];
        for (int i = 0; i<=m; i++)
            for (int j = 0; j<=n; j++) {
                if (i == 0 && j == 0)
                    f[i][j] = true;
                else
                    f[i][j] = false;
                if (i>0 && s1.charAt(i-1) == s3.charAt(i+j-1))
                    f[i][j] = f[i][j] || f[i-1][j];
                if (j>0 && s2.charAt(j-1) == s3.charAt(i+j-1))
                    f[i][j] = f[i][j] || f[i][j-1];
            }
        return f[m][n];
    }
}
