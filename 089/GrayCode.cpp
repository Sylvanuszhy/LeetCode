#include <iostream>
#include <vector>
using namespace std;

class Solution {
public:
    vector<int> grayCode(int n) {
        int m = pow(2, n);
        vector<int> res(m);
        vector<bool> flag(m, false);
        int k = 0;
        res[0] = k;
        flag[k] = true;
        for (int i = 1; i<m; i++) {
            for (int j = 0; j<n; j++) {
                int t = k>>j;
                int s = 1<<j;
                if (t%2 == 0 && !flag[k+s]) {
                    res[i] = k+s;
                    flag[k+s] = true;
                    k = k+s;
                    break;
                }
                if (t%2 == 1 && !flag[k-s]) {
                    res[i] = k-s;
                    flag[k-s] = true;
                    k = k-s;
                    break;
                }
            }
        }
        return res;
    }
};
