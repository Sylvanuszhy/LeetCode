#include <iostream>
#include <vector>
using namespace std;

class Solution {
public:
    bool exist(vector<vector<char>>& board, string word) {
        this->word = word;
        this->board = board;
        for (int i = 0; i<board.size(); i++)
            for (int j = 0; j<board[0].size(); j++)
                if (board[i][j] == word[0]) {
                    this->board[i][j] = '#';
                    dfs(1, i, j);
                    this->board[i][j] = this->word[0];
                    if (this->isExist)
                        return true;
                }
        return false;
    }
private:
    bool isExist = false;
    string word;
    vector<vector<char>> board;

    void dfs(int k, int i, int j) {
        if (this->isExist)
            return;
        if (k == this->word.size()) {
            this->isExist = true;
        } else {
            if (i-1>=0 && this->board[i-1][j] == this->word[k]) {
                this->board[i-1][j] = '#';
                dfs(k+1, i-1, j);
                this->board[i-1][j] = this->word[k];
            }
            if (j-1>=0 && this->board[i][j-1] == this->word[k]) {
                this->board[i][j-1] = '#';
                dfs(k+1, i, j-1);
                this->board[i][j-1] = this->word[k];
            }
            if (i+1<board.size() && this->board[i+1][j] == this->word[k]) {
                this->board[i+1][j] = '#';
                dfs(k+1, i+1, j);
                this->board[i+1][j] = this->word[k];
            }
            if (j+1<board[0].size() && this->board[i][j+1] == this->word[k]) {
                this->board[i][j+1] = '#';
                dfs(k+1, i, j+1);
                this->board[i][j+1] = this->word[k];
            }
        }
    }
};
