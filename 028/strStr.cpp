#include <iostream>
#include <string>
#include <vector>
using namespace std;

class Solution {
public:
    int strStr(string haystack, string needle) {
        if (needle.empty())
            return 0;
            
        vector<int> next(needle.size(), 0);
        for (int k = 0, i = 1; i<needle.size(); i++) {
            while ((k>0) && (needle[i] != needle[k]))
                k = next[k-1];
            if (needle[i] == needle[k])
                k++;
            next[i] = k;
        }

        for (int k = 0, i = 0; i<haystack.size(); i++) {
            while ((k>0) && (haystack[i] != needle[k]))
                k = next[k-1];
            if (haystack[i] == needle[k]) {
                k++;
                if (k == needle.size())
                    return i-k+1;
            }
        }
        return -1;
    }
};

int main() {
    Solution solu;
    string a = "aabcabcc";
    string b = "abc";
    int ans = solu.strStr(a, b);
    cout<<ans<<endl;
}