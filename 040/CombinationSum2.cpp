#include <iostream>
#include <vector>
using namespace std;

class Solution {
public:
    vector<vector<int>> combinationSum2(vector<int>& candidates, int target) {
        sort(candidates.begin(), candidates.end());
        this->target = target;
        this->candidates = candidates;
        dfs(0, {}, 0);
        return this->ans;
    }
private:
    int target;
    vector<int> candidates;
    vector<vector<int>> ans;

    void dfs(int k, vector<int> picked, int sum) {
        if (sum == this->target) {
            this->ans.push_back(picked);
        } else {
            for (int i = k; i<this->candidates.size(); i++)
                if (sum + this->candidates[i] <= this->target) {
                    picked.push_back(this->candidates[i]);
                    dfs(i+1, picked, sum + this->candidates[i]);
                    picked.pop_back();
                    while ((i+1<this->candidates.size()) && (this->candidates[i] == this->candidates[i+1]))
                        i++;
                }
        }
    }
};
