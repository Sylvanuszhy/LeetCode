#include <iostream>
#include <string>
#include <vector>
using namespace std;

class Solution {
public:
    vector<string> generateParenthesis(int n) {
        this->n = n;
        if (n>0)
            dfs(0, 0, "");
        return this->ans;
    }
private:
    int n;
    vector<string> ans;

    void dfs(int k, int cnt, string str) {
        if (k >= 2*this->n) {
            this->ans.push_back(str);
        } else {
            if (cnt<this->n) {
                string tmp = str+string(1, '(');
                dfs(k+1, cnt+1, tmp);
            }
            if (k<2*cnt) {
                string tmp = str+string(1, ')');
                dfs(k+1, cnt, tmp);
            }
        }
    }
};

int main() {
    Solution solu;
    int n = 0;
    vector<string> ans = solu.generateParenthesis(n);
    for (int i = 0; i<ans.size(); i++) {
        cout<<ans[i]<<endl;
    }
}
