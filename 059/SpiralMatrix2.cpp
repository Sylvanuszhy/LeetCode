#include <iostream>
#include <string>
using namespace std;

class Solution {
public:
    vector<vector<int>> generateMatrix(int n) {
        vector<vector<int>> res;
        vector<int> tmp(n);
        for (int k = 0; k<n; k++)
            res.push_back(tmp);
        int row = 1, col = 1;
        int i = 0, j = -1, cnt = 0;
        while (n>0) {
            for (int k = 0; k<n; k++) {
                j += col;
                res[i][j] = ++cnt;
            }
            n--;
            for (int k = 0; k<n; k++) {
                i += row;
                res[i][j] = ++cnt;
            }
            row = -row;
            col = -col;
        }
        return res;
    }
};
