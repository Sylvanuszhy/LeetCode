#include <iostream>
#include <string>
using namespace std;

class Solution {
public:
    string getPermutation(int n, int k) {
        int factorial[10];
        factorial[1] = 1;
        for (int i = 2; i<=n; i++)
            factorial[i] = factorial[i-1]*i;
        
        string res(n, '0');
        bool used[10];
        memset(used, false, sizeof(used));
        for (int i = n; i>=1; i--) {
            int m = (k-1)/factorial[i-1];
            k = k-m*factorial[i-1];
            int j = 0;
            while (m>=0) {
                j++;
                if (!used[j])
                    m--;
            }
            res[n-i] = j+48;
            used[j] = true;
        }

        return res;
    }
};

int main() {
    Solution solu;
    int n = 4, k = 24;
    string res = solu.getPermutation(n, k);
    cout<<res<<endl;
}
