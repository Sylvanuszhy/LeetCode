class NumMatrix {

    public int m, n;
    public int[][] tree;

    public NumMatrix(int[][] matrix) {
        m = matrix.length;
        if (m == 0)
            return;
        n = matrix[0].length;
        int[][] s = new int[m+1][n+1];
        for (int i = 0; i<=m; i++)
            s[i][0] = 0;
        for (int j = 0; j<=n; j++)
            s[0][j] = 0;
        for (int i = 0; i<m; i++)
            for (int j = 0; j<n; j++)
                s[i+1][j+1] = matrix[i][j]+s[i][j+1]+s[i+1][j]-s[i][j];
        tree = new int[m+1][n+1];
        for (int i = 1; i<=m; i++) {
            int x = i - (i & -i);
            for (int j = 1; j<=n; j++) {
                int y = j - (j & -j);
                tree[i][j] = s[i][j]-s[x][j]-s[i][y]+s[x][y];
            }
        }
    }
    
    public void update(int row, int col, int val) {
        int i = row+1, j = col+1;
        int ori = getSingle(row, col);
        int inc = val-ori;
        while (i<=m) {
            int k = j;
            while (k<=n) {
                tree[i][k] += inc;
                k += (k & -k);
            }
            i += (i & -i);
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        return getSum(row2+1, col2+1)-getSum(row1, col2+1)-getSum(row2+1, col1)+getSum(row1, col1);
    }

    public int getSum(int i, int j) {
        int s = 0;
        while (i>0) {
            int k = j;
            while (k>0) {
                s += tree[i][k];
                k -= (k & -k);
            }
            i -= (i & -i);
        }
        return s;
    }

    public int getSingle(int row, int col) {
        return sumRegion(row, col, row, col);
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * obj.update(row,col,val);
 * int param_2 = obj.sumRegion(row1,col1,row2,col2);
 */