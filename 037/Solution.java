import java.util.ArrayList;

class Solution {

    public boolean flag;
    public boolean[][] row, col, sqr;
    public ArrayList<Integer> blank;

    public void solveSudoku(char[][] board) {
        row = new boolean[9][10];
        col = new boolean[9][10];
        sqr = new boolean[9][10];
        blank = new ArrayList<Integer>();
        for (int i = 0; i<9; i++)
            for (int j = 0; j<9; j++) {
                char c = board[i][j];
                if (c == '.') {
                    blank.add(i*9+j);
                } else {
                    int val = c-48;
                    row[i][val] = true;
                    col[j][val] = true;
                    int k = (i/3)*3+(j/3);
                    sqr[k][val] = true;
                }
            }
        flag = false;
        dfs(0, board);
    }

    public void dfs(int k, char[][] board) {
        if (k == blank.size() || flag) {
            flag = true;
            return;
        }
        int i = blank.get(k)/9;
        int j = blank.get(k)%9;
        for (int l = 1; l<=9; l++)
            if (!row[i][l] && !col[j][l] && !sqr[(i/3)*3+(j/3)][l] && !flag) {
                row[i][l] = true;
                col[j][l] = true;
                sqr[(i/3)*3+(j/3)][l] = true;
                board[i][j] = (char)(l+48);
                dfs(k+1, board);
                row[i][l] = false;
                col[j][l] = false;
                sqr[(i/3)*3+(j/3)][l] = false;
            }
    }
}
