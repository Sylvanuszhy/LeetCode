#include <iostream>
#include <vector>
using namespace std;

class Solution {
public:
    vector<vector<int>> permute(vector<int>& nums) {
        this->nums = nums;
        vector<bool> isPicked(nums.size(), false);
        this->isPicked = isPicked;
        dfs(0);
        return this->ans;
    }
private:
    vector<int> nums;
    vector<bool> isPicked;
    vector<int> permutation;
    vector<vector<int>> ans;

    void dfs(int k) {
        if (k>=this->nums.size()) {
            this->ans.push_back(this->permutation);
        } else {
            for (int i = 0; i<this->nums.size(); i++)
                if (!this->isPicked[i]) {
                    this->permutation.push_back(this->nums[i]);
                    this->isPicked[i] = true;
                    dfs(k+1);
                    this->permutation.pop_back();
                    this->isPicked[i] = false;
                }
        }
    }
};
