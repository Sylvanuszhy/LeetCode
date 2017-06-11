#include <iostream>
#include <vector>
using namespace std;

class Solution {
public:
    vector<vector<int>> subsets(vector<int>& nums) {
        int n = nums.size();
        int m = pow(2, n);
        vector<vector<int>> res(m);
        vector<int> blank;
        res[0] = blank;
        for (int i = 1; i<m; i++)
            for (int j = 0; j<n; j++)
                if (i >> j & 1) {
                    int father = (i >> (j+1)) << (j+1);
                    vector<int> subS(res[father]);
                    subS.push_back(nums[n-1-j]);
                    res[i] = subS;
                    break;
                }
        return res;
    }
};
