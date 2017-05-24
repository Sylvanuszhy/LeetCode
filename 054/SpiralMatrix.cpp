#include <iostream>
#include <vector>
using namespace std;

class Solution {
public:
    vector<int> spiralOrder(vector<vector<int>>& matrix) {
        int m = matrix.size(), n = 0;
        if (m>0)
            n = matrix[0].size();
        int row = 1, col = 1;
        int i = 0, j = -1;
        vector<int> res;
        m -= 1;
        while (m>=0 && n>0) {
            for (int k = 0; k<n; k++) {
                j += col;
                res.push_back(matrix[i][j]);
            }
            for (int k = 0; k<m; k++) {
                i += row;
                res.push_back(matrix[i][j]);
            }
            n--, m--;
            row = -row;
            col = -col;
        }
        return res;
    }
};

int main() {
    Solution solu;
}