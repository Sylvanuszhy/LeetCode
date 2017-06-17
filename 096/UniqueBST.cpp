#include <iostream>
#include <vector>
using namespace std;

class Solution {
public:
    int numTrees(int n) {
        vector<int> f(n+1);
        f[0] = f[1] = 1;
        for (int i = 2; i<=n; i++) {
            f[i] = 0;
            for (int j = 0; j<i; j++)
                f[i] += f[j]*f[i-1-j];
        }
        return f[n];
    }
};
