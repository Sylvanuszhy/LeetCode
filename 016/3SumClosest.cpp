#include <iostream>
#include <vector>
using namespace std;

class Solution {
public:
    int threeSumClosest(vector<int>& nums, int target) {
        int ans = nums[0]+nums[1]+nums[2];
        sort(nums.begin(), nums.end());
        vector<int>::iterator base;
        for (base = nums.begin(); base<nums.end()-2; base++) {
            vector<int>::iterator p = base+1, q = nums.end()-1;
            while (p<q) {
                int sum = *base + *p + *q;
                if (abs(ans-target) > abs(sum-target))
                    ans = sum;

                if (sum < target)
                    p++;
                else if (sum > target)
                    q--;
                else
                    break;
            }
        }
        return ans;
    }
};

int main() {
    Solution solu;
    vector<int> nums = {-1, -1};
    int target = 1;
    int ans = solu.threeSumClosest(nums, target);
    cout<<ans<<endl;
}
