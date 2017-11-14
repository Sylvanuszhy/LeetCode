class Solution {
    public int minCostII(int[][] costs) {
        int n = costs.length;
        if (n == 0)
            return 0;
        int k = costs[0].length;
        int[][] f = new int[n][k];
        int min1 = -1, min2 = -1;
        for (int j = 0; j<k; j++) {
            f[0][j] = costs[0][j];
            if (min1<0 || f[0][j]<f[0][min1]) {
                min2 = min1;
                min1 = j;
            } else if (min2<0 || f[0][j]<f[0][min2]) {
                min2 = j;
            }
        }
        for (int i = 1; i<n; i++) {
            for (int j = 0; j<k; j++) {
                if (j == min1)
                    f[i][j] = f[i-1][min2]+costs[i][j];
                else
                    f[i][j] = f[i-1][min1]+costs[i][j];
            }
            min1 = -1;
            min2 = -1;
            for (int j = 0; j<k; j++) {
                if (min1<0 || f[i][j]<f[i][min1]) {
                    min2 = min1;
                    min1 = j;
                } else if (min2<0 || f[i][j]<f[i][min2]) {
                    min2 = j;
                }
            }
        }
        return f[n-1][min1];
    }
}
