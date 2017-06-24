#include <iostream>
#include <vector>
using namespace std;

class Solution {
public:
    vector<vector<int>> generate(int numRows) {
        vector<vector<int>> res;
        if (numRows>0)
            res.push_back(vector<int>(1, 1));
        if (numRows>1)
            res.push_back(vector<int>(2, 1));
        for (int i = 3; i<=numRows; i++) {
            vector<int> row(i, 1);
            vector<int> last = res.back();
            for (int j = 1; j<i-1; j++)
                row[j] = last[j-1]+last[j];
            res.push_back(row);
        }
        return res;
    }
};

int main() {
    Solution solu;
    int n = 4;
    vector<vector<int>> res = solu.generate(n);
    cout<<res[n-1][n-1]<<endl;
}
