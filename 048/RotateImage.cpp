#include <iostream>
#include <vector>
using namespace std;

class Solution {
public:
    void rotate(vector<vector<int>>& matrix) {
        int n = matrix.size();
        int m = n/2+n%2;
        for (int i = 0; i<m; i++)
            for (int j = 0; j<n/2; j++) {
                int x = n-1-i, y = n-1-j;
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[y][i];
                matrix[y][i] = matrix[x][y];
                matrix[x][y] = matrix[j][x];
                matrix[j][x] = tmp;
            }
    }
};
