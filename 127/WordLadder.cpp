#include <iostream>
#include <string>
#include <vector>
#include <queue>
using namespace std;

class Solution {
public:
    int ladderLength(string beginWord, string endWord, vector<string>& wordList) {
        vector<bool> isUsed(wordList.size(), false);
        queue<string> q;
        q.push(beginWord);
        bool flag = false;
        int k = 1, level = 1;
        while (!q.empty()) {
            int cnt = 0;
            for (int i = 0; i<k; i++) {
                string word = q.front();
                for (int j = 0; j<wordList.size(); j++)
                    if (!isUsed[j] && diff(word, wordList[j])) {
                        cnt++;
                        q.push(wordList[j]);
                        isUsed[j] = true;
                        if (wordList[j] == endWord)
                            flag = true;
                    }
                q.pop();
            }
            level++;
            k = cnt;
            if (flag)
                break;
        }
        if (flag)
            return level;
        else
            return 0;
    }
private:
    bool diff(string w1, string w2) {
        int cnt = 0;
        for (int i = 0; i<w1.size(); i++)
            if (w1[i] != w2[i])
                cnt++;
        if (cnt == 1)
            return true;
        else
            return false;
    }
};

int main() {
    Solution solu;
    string beginWord = "teach", endWord = "place";
    vector<string> wordList = {"peale","wilts","place","fetch","purer","pooch","peace","poach","berra","teach","rheum","peach"};
    int res = solu.ladderLength(beginWord, endWord, wordList);
    cout<<res<<endl;
}
