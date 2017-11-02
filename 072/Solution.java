class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        if (m == 0 || n == 0)
            return Math.max(m, n);
        int[][] f = new int[m][n];
        f[0][0] = word1.charAt(0) == word2.charAt(0) ? 0 : 1;
        for (int i = 1; i<m; i++)
            if (word1.charAt(i) == word2.charAt(0))
                f[i][0] = i;
            else
                f[i][0] = f[i-1][0]+1;
        for (int j = 1; j<n; j++)
            if (word1.charAt(0) == word2.charAt(j))
                f[0][j] = j;
            else
                f[0][j] = f[0][j-1]+1;
        for (int i = 1; i<m; i++)
            for (int j = 1; j<n; j++) {
                f[i][j] = Math.min(Math.min(f[i-1][j], f[i][j-1]), f[i-1][j-1])+1;
                if (word1.charAt(i) == word2.charAt(j))
                    f[i][j] = Math.min(f[i][j], f[i-1][j-1]);
            }
        return f[m-1][n-1];
    }
}
