#include <iostream>
#include <string>
#include <vector>
using namespace std;

class Solution {
public:
    int numDecodings(string s) {
        int n = s.size();
        vector<int> cnt(n+1);
        if (n != 0)
            cnt[0] = 1;
        if (s[0] != '0')
            cnt[1] = 1;
        for (int i = 2; i<=n; i++) {
            if (s[i-1] != '0')
                cnt[i] += cnt[i-1];
            int two = (s[i-2]-48)*10+(s[i-1]-48);
            if (10<=two && two<=26)
                cnt[i] += cnt[i-2];
        }
        return cnt[n];
    }
};

int main() {
    Solution solu;
    string s = "";
    int res = solu.numDecodings(s);
    cout<<res<<endl;
}
