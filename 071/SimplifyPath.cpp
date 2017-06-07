#include <iostream>
#include <string>
#include <sstream>
#include <vector>
using namespace std;

class Solution {
public:
    string simplifyPath(string path) {
        vector<string> folders;
        string s;
        stringstream ss;
        ss.str(path);
        while (getline(ss, s, '/')) {
            if (s == "." || s == "")
                continue;
            if (s == "..") {
                if (!folders.empty())
                    folders.pop_back();
                continue;
            }
            folders.push_back(s);
        }

        string res;
        vector<string>::iterator itor;
        for (itor = folders.begin(); itor != folders.end(); itor++)
            res += "/"+(*itor);
        if (res == "")
            res = "/";
        return res;
    }
};

int main() {
    Solution solu;
    string path = "/home//foo/";
    string res = solu.simplifyPath(path);
    cout<<res<<endl;
}
