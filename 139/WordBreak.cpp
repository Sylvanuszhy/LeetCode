#include <iostream>
#include <vector>
#include <queue>
#include <set>
using namespace std;

class Solution {
public:
    bool wordBreak(string s, vector<string>& wordDict) {
        queue<int> q;
        set<int> pos;
        q.push(0);
        pos.insert(0);
        while (!q.empty()) {
            int k = q.front();
            for (int i = 0; i<wordDict.size(); i++) {
                string w = wordDict[i];
                if (pos.find(k+w.size()) == pos.end() && isPrefix(s, k, w)) {
                    q.push(k+w.size());
                    pos.insert(k+w.size());
                    if (k+w.size() == s.size())
                        return true;
                }
            }
            q.pop();
        }
        return false;
    }
private:
    bool isPrefix(string s, int k, string w) {
        for (int i = 0; i<w.size(); i++)
            if (s[k+i] != w[i])
                return false;
        return true;
    }
};
