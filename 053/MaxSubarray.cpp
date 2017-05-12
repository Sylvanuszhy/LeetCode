#include <iostream>
#include <vector>
using namespace std;

class Solution {
public:
    int maxSubArray(vector<int>& nums) {
        vector<int> maxSum(nums.size());
        maxSum[0] = nums[0];
        for (int i = 1; i<nums.size(); i++)
            maxSum[i] = max(maxSum[i-1]+nums[i], nums[i]);
        int maxS = maxSum[0];
        for (int i = 1; i<maxSum.size(); i++)
            maxS = max(maxS, maxSum[i]);
        return maxS;
    }
};

int main() {
    Solution solu;
    vector<int> nums = {-2,1,-3,4,-1,2,1,-5,4};
    int ans = solu.maxSubArray(nums);
    cout<<ans<<endl;
}
