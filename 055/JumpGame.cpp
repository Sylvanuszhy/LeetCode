#include <iostream>
#include <vector>
using namespace std;

class Solution {
public:
    bool canJump(vector<int>& nums) {
        int reach = 0;
        for (int i = 0; i<nums.size() && i<=reach; i++)
            reach = max(reach, i+nums[i]);
        if (reach>=nums.size()-1)
            return true;
        else
            return false;
    }
};

int main() {
    Solution solu;
    vector<int> nums = {0,1};
    bool res = solu.canJump(nums);
    cout<<res<<endl;
}
