#include <iostream>

class Solution {
public:
    int mySqrt(int x) {
        long k = x;
        while (k*k>x)
            k = (k+x/k)/2;
        return k;
    }
};

int main() {
    Solution solu;
    int x = 2147395599;
    int res = solu.mySqrt(x);
    std::cout<<res<<std::endl;
}
