#include <iostream>
#include <vector>
using namespace std;

class Solution {
public:
    int uniquePathsWithObstacles(vector<vector<int>>& obstacleGrid) {
        int m = obstacleGrid.size();
        int n = obstacleGrid[0].size();
        vector<vector<int>> f(m, vector<int>(n));
        f[0][0] = obstacleGrid[0][0] ? 0 : 1;
        for (int j = 1; j<n; j++)
            f[0][j] = obstacleGrid[0][j] ? 0 : f[0][j-1];
        for (int i = 1; i<m; i++) {
            f[i][0] = obstacleGrid[i][0] ? 0 : f[i-1][0];
            for (int j = 1; j<n; j++)
                f[i][j] = obstacleGrid[i][j] ? 0 : f[i-1][j]+f[i][j-1];
        }
        return f[m-1][n-1];
    }
};

int main() {
    Solution solu;
    vector<vector<int>> obstacleGrid(3, vector<int>(3, 0));
    int res = solu.uniquePathsWithObstacles(obstacleGrid);
    cout<<res<<endl;
}
