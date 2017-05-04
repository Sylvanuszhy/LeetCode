#include <iostream>
#include <string>
#include <vector>
#include <map>
using namespace std;

class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        map<char, int> dict;
        vector<int> maxlen(s.size());

        int cnt = 0;
        for (char c : s) {
            if (dict.find(c) == dict.end()) {
                dict[c] = cnt;
            } else {
                maxlen[cnt] = cnt-dict.at(c);
                dict[c] = cnt;
            }
            cnt++;
        }
        
        for (int i = 0; i<maxlen.size(); i++) {
            if (i == 0) {
                maxlen[i] = 1;
                continue;
            }
            if (maxlen[i] == 0) {
                maxlen[i] = maxlen[i-1]+1;
            } else {
                maxlen[i] = min(maxlen[i], maxlen[i-1]+1);
            }
        }

        int maxlength = 0;
        for (int i = 0; i<maxlen.size(); i++) {
            maxlength = max(maxlength, maxlen[i]);
        }

        return maxlength;
    }
};

int main() {
    Solution solu;
    string s = "abcbada";
    int res = solu.lengthOfLongestSubstring(s);
    cout<<res<<endl;
}
