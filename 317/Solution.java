import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int shortestDistance(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dist = new int[m][n];
        int[][] visit = new int[m][n];
        for (int i = 0; i<m; i++)
            for (int j = 0; j<n; j++)
                if (grid[i][j] == 0)
                    visit[i][j] = 1;
                else
                    visit[i][j] = -1;
        int travel = 0;
        for (int i = 0; i<m; i++)
            for (int j = 0; j<n; j++)
                if (grid[i][j] == 1) {
                    int st = compress(i, j, n);
                    travel++;
                    Queue<Integer> q = new LinkedList<Integer>();
                    q.add(st);
                    int count = 1;
                    int k = 0;
                    while (!q.isEmpty()) {
                        int t = q.remove();
                        int x = t/n, y = t%n;
                        dist[x][y] += k;
                        if (x-1>=0 && visit[x-1][y] == travel) {
                            q.add(compress(x-1, y, n));
                            visit[x-1][y]++;
                        }
                        if (y-1>=0 && visit[x][y-1] == travel) {
                            q.add(compress(x, y-1, n));
                            visit[x][y-1]++;
                        }
                        if (x+1<m && visit[x+1][y] == travel) {
                            q.add(compress(x+1, y, n));
                            visit[x+1][y]++;
                        }
                        if (y+1<n && visit[x][y+1] == travel) {
                            q.add(compress(x, y+1, n));
                            visit[x][y+1]++;
                        }
                        count--;
                        if (count == 0) {
                            count = q.size();
                            k += 1;
                        }
                    }
                }
        int minDist = -1;
        for (int i = 0; i<m; i++)
            for (int j = 0; j<n; j++)
                if (visit[i][j]>travel) {
                    if (minDist == -1)
                        minDist = dist[i][j];
                    else
                        minDist = Math.min(minDist, dist[i][j]);
                }
                    
        return minDist;
    }

    public int compress(int row, int col, int n) {
        return n*row+col;
    }
}
