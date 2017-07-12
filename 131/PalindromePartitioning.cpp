#include <iostream>
#include <string>
#include <vector>
using namespace std;

class Solution {
public:
    vector<vector<string>> partition(string s) {
        vector<vector<bool>> palindrome(s.size(), vector<bool>(s.size(), false));
        for (int i = 0; i<s.size(); i++) {
            int j = 0;
            while ((i-j>=0) && (i+j<s.size())) {
                if (s[i-j] == s[i+j]) {
                    palindrome[i-j][i+j] = true;
                    j++;
                } else {
                    break;
                }
            }

            int k = 0;
            while ((i-k>=0) && (i+1+k<s.size())) {
                if (s[i-k] == s[i+1+k]) {
                    palindrome[i-k][i+1+k] = true;
                    k++;
                } else {
                    break;
                }
            }
        }

        this->s = s;
        dfs(0, palindrome);
        return res;
    }
private:
    string s;
    vector<int> pos;
    vector<vector<string>> res;

    void dfs(int k, vector<vector<bool>> &palindrome) {
        if (k >= this->s.size()) {
            vector<string> tmp;
            vector<int>::iterator itor = this->pos.begin();
            tmp.push_back(this->s.substr(0, *itor));
            for (itor++; itor != this->pos.end(); itor++) {
                int st = *(itor-1);
                tmp.push_back(this->s.substr(st, *itor-st));
            }
            this->res.push_back(tmp);
        } else {
            for (int i = k; i<this->s.size(); i++)
                if (palindrome[k][i]) {
                    this->pos.push_back(i+1);
                    dfs(i+1, palindrome);
                    this->pos.pop_back();
                }
        }
    }
};
