#include <iostream>

class Solution {
public:
    bool isPalindrome(int x) {
        if (x<0)
            return false;
        
        int z = x;
        long y = 0;
        while (z != 0) {
            y = y*10+z%10;
            z = z/10;
            if (y<INT_MIN || y>INT_MAX)
                return false;
        }

        if (x == y)
            return true;
        else
            return false;
    }
};

int main() {
    Solution solu;
    int n = -2;
    bool res = solu.isPalindrome(n);
    std::cout<<res<<std::endl;
}
