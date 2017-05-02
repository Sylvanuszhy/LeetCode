#include <iostream>
#include <vector>
#include <map>
using namespace std;

class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        map<int, int> dict;

        int cnt = 0;
        vector<int>::iterator itorVec;
        for (itorVec=nums.begin(); itorVec!=nums.end(); itorVec++) {
            int num = target - (*itorVec);
            if (dict.find(num) == dict.end()) {
                dict[*itorVec] = cnt;
            } else {
                vector<int> res = {dict.at(num), cnt};
                return res;
            }
            cnt++;
        }
    }
};

int main() {
    Solution solu;
    vector<int> nums = {3, 2, 4};
    int target = 6;
    vector<int> res = solu.twoSum(nums, target);
    cout<<res[0]<<" "<<res[1]<<endl;
}
