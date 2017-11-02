import java.util.Arrays;

class Solution {
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        if (m == 0)
            return 0;
        int n = matrix[0].length;
        int[] height = new int[n];
        int[] left = new int[n];
        int[] right = new int[n];
        Arrays.fill(height, 0);
        Arrays.fill(left, -1);
        Arrays.fill(right, n);
        int res = 0;
        for (int i = 0; i<m; i++) {
            int rLeft = -1;
            for (int j = 0; j<n; j++)
                if (matrix[i][j] == '1') {
                    height[j] = height[j]+1;
                    left[j] = Math.max(left[j], rLeft);
                } else {
                    height[j] = 0;
                    left[j] = -1;
                    rLeft = j;
                }
            int rRight = n;
            for (int j = n-1; j>=0; j--)
                if (matrix[i][j] == '1') {
                    right[j] = Math.min(right[j], rRight);
                } else {
                    right[j] = n;
                    rRight = j;
                }
            for (int j = 0; j<n; j++) {
                int a = (right[j]-left[j]-1)*height[j];
                res = Math.max(res, a);
            }
        }
        return res;
    }
}
