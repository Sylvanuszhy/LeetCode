#include <iostream>
#include <string>
#include <vector>
#include <map>
using namespace std;

class Solution {
public:
    vector<string> letterCombinations(string digits) {
        this->digits = digits;
        if (!digits.empty())
            dfs(0, "");
        return this->strs;
    }
private:
    map<char, string> dict = {{'1', ""}, {'2', "abc"}, {'3', "def"}, 
                            {'4', "ghi"}, {'5', "jkl"}, {'6', "mno"}, 
                            {'7', "pqrs"}, {'8', "tuv"}, {'9', "wxyz"}, {'0', ""}};
    string digits;
    vector<string> strs;

    void dfs(int k, string str) {
        if (k>=this->digits.size()) {
            this->strs.push_back(str);
        } else {
            for (char c : dict.at(this->digits[k])) {
                string tmp = str+string(1, c);
                dfs(k+1, tmp);
            }
        }
    }
};

int main() {
    Solution solu;
    string str = "120";
    vector<string> ans = solu.letterCombinations(str);
    for (int i = 0; i<ans.size(); i++) {
        cout<<ans[i]<<endl;
    }
}
