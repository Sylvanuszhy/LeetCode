#include <iostream>
#include <vector>
using namespace std;

class Solution {
public:
    int minimumTotal(vector<vector<int>>& triangle) {
        vector<vector<int>> f(2, vector<int>());
        int t = 0;
        f[0] = triangle[0];
        for (int i = 1; i<triangle.size(); i++) {
            t = 1-t;
            f[t] = triangle[i];
            int m = f[t].size();
            f[t][0] += f[1-t][0];
            for (int j = 1; j<m-1; j++)
                f[t][j] += min(f[1-t][j-1], f[1-t][j]);
            f[t][m-1] += f[1-t][m-2];
        }
        int val = f[t][0];
        for (int i = 1; i<f[t].size(); i++)
            val = min(val, f[t][i]);
        return val;
    }
};
