#include <iostream>

class Solution {
public:
    int uniquePaths(int m, int n) {
        int f[100][100];
        if (m>n) {
            int tmp = m;
            m = n;
            n = tmp;
        }
        for (int j = 0; j<n; j++)
            f[0][j] = 1;
        for (int i = 1; i<m; i++) {
            f[i][i] = f[i-1][i]*2;
            for (int j = i+1; j<n; j++)
                f[i][j] = f[i][j-1]+f[i-1][j];
        }
        return f[m-1][n-1];
    }
};