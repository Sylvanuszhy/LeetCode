#include <iostream>
#include <string>
using namespace std;

class Solution {
public:
    string countAndSay(int n) {
        string s = "1";
        for (int k = 1; k<n; k++) {
            string sNext = "";
            int i, rep = 1;
            for (i = 1; i<s.size(); i++) {
                if (s[i-1] == s[i]) {
                    rep++;
                } else {
                    sNext += to_string(rep)+to_string(s[i-1]-48);
                    rep = 1;
                }
            }
            s = sNext+to_string(rep)+to_string(s[i-1]-48);
        }
        return s;
    }
};

int main() {
    Solution solu;
    string s = solu.countAndSay(5);
    cout<<s<<endl;
}
