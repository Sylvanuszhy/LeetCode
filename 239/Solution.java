class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if (n == 0)
            return new int[0];
        int m = (int)Math.floor(Math.log(k)/Math.log(2));
        int[][] f = new int[n][m+1];
        for (int i = 0; i<n; i++)
            f[i][0] = nums[i];
        for (int j = 1; j<=m; j++)
            for (int i = 0; i+(1<<j)-1<n; i++)
                f[i][j] = Math.max(f[i][j-1], f[i+(1<<(j-1))][j-1]);
        int[] maxVal = new int[n-k+1];
        for (int i = 0; i<n-k+1; i++)
            maxVal[i] = Math.max(f[i][m], f[i+k-(1<<m)][m]);
        return maxVal;
    }
}
