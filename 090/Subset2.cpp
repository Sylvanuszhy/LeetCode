#include <iostream>
#include <vector>
#include <map>
using namespace std;

class Solution {
public:
    vector<vector<int>> subsetsWithDup(vector<int>& nums) {
        map<int, int> cnt;
        for (int i = 0; i<nums.size(); i++)
            if (cnt.count(nums[i]) == 0)
                cnt[nums[i]] = 1;
            else
                cnt[nums[i]]++;
        
        vector<vector<int>> res;
        vector<int> add;
        res.push_back(add);
        map<int, int>::iterator itor;
        for (itor = cnt.begin(); itor != cnt.end(); itor++) {
            add.clear();
            int n = res.size();
            for (int i = 0; i<itor->second; i++) {
                add.push_back(itor->first);
                for (int j = 0; j<n; j++) {
                    vector<int> tmp = res[j];
                    tmp.insert(tmp.end(), add.begin(), add.end());
                    res.push_back(tmp);
                }
            }
        }
        return res;
    }
};
