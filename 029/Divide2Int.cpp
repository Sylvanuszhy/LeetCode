#include <iostream>
#include <vector>
using namespace std;

class Solution {
public:
    int divide(int dividend, int divisor) {
        if (dividend == INT_MIN) {
            if (divisor == 1)
                return dividend;
            if (divisor == -1)
                return INT_MAX;
            if (divisor == INT_MIN)
                return 1;
        }
        if (divisor == INT_MIN)
            return 0;
        
        long div = dividend;
        bool isMinus = false;
        if (div<0) {
            div = -div;
            isMinus = !isMinus;
        }
        if (divisor<0) {
            divisor = -divisor;
            isMinus = !isMinus;
        }
        
        int cnt = 0;
        vector<long> magnif = {divisor};
        while (magnif[cnt]<div) {
            magnif.push_back(magnif[cnt]<<1);
            cnt++;
        }
        long ans = 0;
        while (cnt>0) {
            if (magnif[cnt]<=div) {
                div -= magnif[cnt];
                ans += 2<<(cnt-1);
            }
            cnt--;
        }
        if (div>=divisor)
            ans += 1;
        
        if (isMinus)
            ans = -ans;
        return ans;
    }
};

int main() {
    Solution solu;
    int dividend = -9;
    int divisor = 11;
    int ans = solu.divide(dividend, divisor);
    cout<<ans<<endl;
}
