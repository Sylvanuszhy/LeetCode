class Solution {
    public int maxKilledEnemies(char[][] grid) {
        int m = grid.length;
        if (m == 0)
            return 0;
        int n = grid[0].length;
        int[] row = new int[m];
        int[] col = new int[n];
        int maxKill = 0;
        for (int i = 0; i<m; i++)
            for (int j = 0; j<n; j++) {
                if (i == 0 || grid[i-1][j] == 'W') {
                    col[j] = 0;
                    for (int k = i; k<m && grid[k][j] != 'W'; k++)
                        if (grid[k][j] == 'E')
                            col[j] += 1;
                }
                if (j == 0 || grid[i][j-1] == 'W') {
                    row[i] = 0;
                    for (int k = j; k<n && grid[i][k] != 'W'; k++)
                        if (grid[i][k] == 'E')
                            row[i] += 1;
                }
                if (grid[i][j] == '0')
                    maxKill = Math.max(maxKill, row[i]+col[j]);
            }
        return maxKill;
    }
}
