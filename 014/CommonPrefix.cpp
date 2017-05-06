#include <iostream>
#include <string>
#include <vector>
using namespace std;

class Solution {
public:
    string longestCommonPrefix(vector<string>& strs) {
        string prefix = "";
        if (strs.size() == 0)
            return prefix;
        
        int i;
        for (i = 0; i<strs[0].size(); i++) {
            char c = strs[0][i];
            int j;
            for (j = 1; j<strs.size(); j++) {
                if (strs[j].size()>i && strs[j][i] == c)
                    ;
                else
                    break;
            }
            if (j != strs.size())
                break;
        }
        return strs[0].substr(0, i);
    }
};

int main() {
    Solution solu;
    vector<string> strs = {"cba"};
    string res = solu.longestCommonPrefix(strs);
    cout<<res<<endl;
}
