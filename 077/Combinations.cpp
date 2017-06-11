#include <iostream>
#include <vector>
using namespace std;

class Solution {
public:
    vector<vector<int>> combine(int n, int k) {
        this->n = n;
        this->k = k;
        dfs(1, 1);
        return this->res;
    }
private:
    int n, k;
    vector<int> combination;
    vector<vector<int>> res;

    void dfs(int j, int st) {
        if (j > this->k) {
            this->res.push_back(this->combination);
        } else {
            for (int i = st; i <= this->n; i++) {
                this->combination.push_back(i);
                dfs(j+1, i+1);
                this->combination.pop_back();
            }
        }
    }
};
