import java.util.ArrayList;
import java.util.Arrays;

class Solution {

    public int n;
    public int[] board;
    public boolean[] col;
    public int res;

    public int totalNQueens(int n) {
        this.n = n;
        board = new int[n];
        col = new boolean[n];
        Arrays.fill(col, true);
        res = 0;
        dfs(0);
        return res;
    }

    public void dfs(int k) {
        if (k>=n) {
            res++;
        } else {
            for (int i = 0; i<n; i++)
                if (col[i] && check(i, k)) {
                    col[i] = false;
                    board[k] = i;
                    dfs(k+1);
                    col[i] = true;
                }
        }
    }

    public boolean check(int i, int k) {
        for (int j = 0; j<k; j++)
            if (k-j == Math.abs(i-board[j]))
                return false;
        return true;
    }
}
