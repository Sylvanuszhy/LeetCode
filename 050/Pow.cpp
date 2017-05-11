#include <iostream>

class Solution {
public:
    double myPow(double x, int n) {
        bool isMinus = false;
        long m = n;
        if (n<0) {
            isMinus = true;
            m = -m;
        }

        double ans = 1, base = x;
        while (m>0) {
            if ((m&1) == 1) {
                if (isMinus)
                    ans /= base;
                else
                    ans *= base;
            }
            base *= base;
            m = m>>1;
        }
        
        return ans;
    }
};

int main() {
    Solution solu;
    double x = 2;
    int n = -2147483648;
    double ans = solu.myPow(x, n);
    std::cout<<ans<<std::endl;
}