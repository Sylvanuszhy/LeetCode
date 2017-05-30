#include <iostream>
#include <string>
#include <sstream>
using namespace std;

class Solution {
public:
    int lengthOfLastWord(string s) {
        istringstream is(s);
        string ss;
        int len = 0;
        while (is>>ss)
            len = ss.size();
        return len;
    }
};

int main() {
    Solution solu;
    string s = " ";
    int ans = solu.lengthOfLastWord(s);
    cout<<ans<<endl;
}
