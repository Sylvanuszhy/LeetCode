class Solution {

    public int count;
    public boolean[] used;

    public int numberOfPatterns(int m, int n) {
        count = 0;
        used = new boolean[10];
        dfs(1, 0, m, n);
        return count;
    }

    public void dfs(int k, int last, int m, int n) {
        if (k>m)
            count++;
        if (k>n) {
            return;
        } else {
            for (int i = 1; i<=9; i++)
                if (!used[i] && isValid(last, i) && isValid(i, last)) {
                    used[i] = true;
                    dfs(k+1, i, m, n);
                    used[i] = false;
                }
        }
    }

    public boolean isValid(int x, int y) {
        if (x == 1 && y == 3 && used[2] == false)
            return false;
        if (x == 4 && y == 6 && used[5] == false)
            return false;
        if (x == 7 && y == 9 && used[8] == false)
            return false;
        if (x == 1 && y == 7 && used[4] == false)
            return false;
        if (x == 2 && y == 8 && used[5] == false)
            return false;
        if (x == 3 && y == 9 && used[6] == false)
            return false;
        if (x == 1 && y == 9 && used[5] == false)
            return false;
        if (x == 3 && y == 7 && used[5] == false)
            return false;
        return true;
    }
}
