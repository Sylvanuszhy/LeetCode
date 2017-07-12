#include <iostream>
#include <vector>
using namespace std;

class Solution {
public:
    void solve(vector<vector<char>>& board) {
        m = board.size();
        if (m>0)
            n = board[0].size();
        else
            return;
        for (int i = 0; i<n; i++) {
            if (board[0][i] == 'O')
                dfs(0, i, board);
            if (board[m-1][i] == 'O')
                dfs(m-1, i, board);
        }
        for (int i = 1; i<m; i++) {
            if (board[i][0] == 'O')
                dfs(i, 0, board);
            if (board[i][n-1] == 'O')
                dfs(i, n-1, board);
        }
        for (int i = 0; i<m; i++)
            for (int j = 0; j<n; j++)
                if (board[i][j] == '.')
                    board[i][j] = 'O';
                else
                    board[i][j] = 'X';
    }
private:
    int m, n;
    
    void dfs(int x, int y, vector<vector<char>>& board) {
        board[x][y] = '.';
        if (x-1>0 && board[x-1][y] == 'O')
            dfs(x-1, y, board);
        if (x+1<m-1 && board[x+1][y] == 'O')
            dfs(x+1, y, board);
        if (y-1>0 && board[x][y-1] == 'O')
            dfs(x, y-1, board);
        if (y+1<n-1 && board[x][y+1] == 'O')
            dfs(x, y+1, board);
    }
};
