import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public void wallsAndGates(int[][] rooms) {
        Queue<Integer> q = new LinkedList<Integer>();
        int m = rooms.length;
        if (m == 0)
            return;
        int n = rooms[0].length;
        for (int i = 0; i<m; i++)
            for (int j = 0; j<n; j++)
                if (rooms[i][j] == 0)
                    q.add(encode(i, j, n));
        while (!q.isEmpty()) {
            int idx = (int)q.remove();
            int i = idx/n, j = idx%n;
            int dist = rooms[i][j];
            if (i-1>=0 && rooms[i-1][j]>dist+1) {
                rooms[i-1][j] = dist+1;
                q.add(encode(i-1, j, n));
            }
            if (j-1>=0 && rooms[i][j-1]>dist+1) {
                rooms[i][j-1] = dist+1;
                q.add(encode(i, j-1, n));
            }
            if (i+1<m && rooms[i+1][j]>dist+1) {
                rooms[i+1][j] = dist+1;
                q.add(encode(i+1, j, n));
            }
            if (j+1<n && rooms[i][j+1]>dist+1) {
                rooms[i][j+1] = dist+1;
                q.add(encode(i, j+1, n));
            }
        }
    }

    public int encode(int row, int col, int n) {
        return row*n+col;
    }
}
