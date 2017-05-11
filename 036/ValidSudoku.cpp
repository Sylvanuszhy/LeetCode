#include <iostream>
#include <vector>
#include <map>
using namespace std;

class Solution {
public:
    bool isValidSudoku(vector<vector<char>>& board) {
        bool isValid = true;
        for (int i = 0; i<9; i++) {
            map<char, int> dictRow(this->dict);
            map<char, int> dictCol(this->dict);
            for (int j = 0; j<9; j++) {
                char cRow = board[i][j];
                char cCol = board[j][i];
                dictRow[cRow] += 1;
                dictCol[cCol] += 1;
            }
            for (char k = '1'; k<='9'; k++) {
                if (dictRow[k]>1)
                    isValid = false;
                if (dictCol[k]>1)
                    isValid = false;
            }
        }

        this->board = board;
        isValid = isValid && sudoku(0, 0);
        isValid = isValid && sudoku(0, 3);
        isValid = isValid && sudoku(0, 6);
        isValid = isValid && sudoku(3, 0);
        isValid = isValid && sudoku(3, 3);
        isValid = isValid && sudoku(3, 6);
        isValid = isValid && sudoku(6, 0);
        isValid = isValid && sudoku(6, 3);
        isValid = isValid && sudoku(6, 6);

        return isValid;
    }
private:
    vector<vector<char>> board;
    map<char, int> dict = {{'1', 0}, {'2', 0}, {'3', 0}, 
                            {'4', 0}, {'5', 0}, {'6', 0}, 
                            {'7', 0}, {'8', 0}, {'9', 0}, {'.', 0}};

    bool sudoku(int row, int col) {
        map<char, int> one2nine(this->dict);
        for (int i = 0; i<3; i++)
            for (int j = 0; j<3; j++) {
                char c = this->board[row+i][col+j];
                one2nine[c] += 1;
            }
        for (char k = '1'; k<='9'; k++)
            if (one2nine[k]>1)
                return false;
        return true;
    }
};

int main() {
    Solution solu;
    vector<vector<char>> board;
    bool isValid = solu.isValidSudoku(board);
}
