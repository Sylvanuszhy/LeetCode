import java.util.ArrayList;
import java.util.Arrays;

class Solution {

    public int n;
    public int[] board;
    public boolean[] col;
    public List<List<String>> res;

    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        board = new int[n];
        col = new boolean[n];
        Arrays.fill(col, true);
        res = new ArrayList<List<String>>();
        dfs(0);
        return res;
    }

    public void dfs(int k) {
        if (k>=n) {
            String s = new String(new char[n]).replace('\0', '.');
            List<String> tmp = new ArrayList<String>();
            for (int j = 0; j<n; j++) {
                StringBuilder sb = new StringBuilder(s);
                sb.setCharAt(board[j], 'Q');
                tmp.add(sb.toString());
            }
            res.add(tmp);
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
