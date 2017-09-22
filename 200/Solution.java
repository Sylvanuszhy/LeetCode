class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length, m = 0;
        if (n>0)
            m = grid[0].length;
        int cnt = 0;
        for (int i = 0; i<n; i++)
            for (int j = 0; j<m; j++)
                if (grid[i][j] == '1') {
                    cnt++;
                    dfs(i, j, n, m, grid);
                }
        return cnt;
    }

    public void dfs(int i, int j, int n, int m, char[][] grid) {
        grid[i][j] = '.';
        if (i-1>=0 && grid[i-1][j] == '1')
            dfs(i-1, j, n, m, grid);
        if (j-1>=0 && grid[i][j-1] == '1')
            dfs(i, j-1, n, m, grid);
        if (i+1<n && grid[i+1][j] == '1')
            dfs(i+1, j, n, m, grid);
        if (j+1<m && grid[i][j+1] == '1')
            dfs(i, j+1, n, m, grid);
    }
}
