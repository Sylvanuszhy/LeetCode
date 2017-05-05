#include <iostream>
#include <string>
using namespace std;

class Solution {
public:
    string convert(string s, int numRows) {
        int interval = 2*numRows-2;
        int leap = interval;
        int cnt = 0;
        string zigzag(s);
        for (int i = 0; i<numRows && interval>0; i++) {
            int j = i;
            while (j<s.size()) {
                zigzag[cnt++] = s[j];
                if (0<leap && leap<interval && j+leap<s.size()) {
                    zigzag[cnt++] = s[j+leap];
                }
                j += interval;
            }
            leap -= 2;
        }
        return zigzag;
    }
};

int main() {
    Solution solu;
    string s = "";
    int n = 1;
    string res = solu.convert(s, n);
    cout<<res<<endl;
}
