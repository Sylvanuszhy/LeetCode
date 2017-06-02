#include <iostream>
#include <vector>
using namespace std;

class Solution {
public:
    int climbStairs(int n) {
        vector<int> f(n+1);
        f[0] = 1;
        f[1] = 1;
        for (int i = 2; i<=n; i++)
            f[i] = f[i-2]+f[i-1];
        return f[n];
    }
};
