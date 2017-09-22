class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if (n == 0)
            return 0;
        if (k>n/2) {
            int profit = 0;
            for (int i = 1; i<n; i++)
                if (prices[i]>prices[i-1])
                    profit += prices[i]-prices[i-1];
            return profit;
        }
        int[][] f = new int[n][k+1];
        for (int j = 1; j<=k; j++) {
            int checking = -prices[0];
            for (int i = 1; i<n; i++) {
                f[i][j] = Math.max(f[i-1][j], checking+prices[i]);
                checking = Math.max(checking, f[i-1][j-1]-prices[i]);
            }
        }
        return f[n-1][k];
    }
}
