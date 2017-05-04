#include <iostream>

class Solution {
public:
    int reverse(int x) {
        long y = 0;
        while (x != 0) {
            y = y*10+x%10;
            x = x/10;
        }

        if (y<INT_MIN || y>INT_MAX)
            y = 0;
        return y;
    }
};

int main() {
    Solution solu;
    int n = 1534236469;
    int res = solu.reverse(n);
    std::cout<<res<<std::endl;
}
