#include <iostream>
#include <vector>
using namespace std;

class Solution {
public:
    int search(vector<int>& nums, int target) {
        int i = 0, j = nums.size()-1;
        while (i<=j) {
            int k = (i+j)/2;
            if (target == nums[k])
                return k;
            if (nums[i]<=nums[j]) {
                if (nums[k]<target)
                    i = k+1;
                if (target<nums[k])
                    j = k-1;
            } else {
                if ((target<nums[i]) && (target>nums[j]))
                    break;
                if (nums[i]<=nums[k]) {
                    if ((nums[i]<=target) && (target<nums[k]))
                        j = k-1;
                    else if ((nums[k]<target) || (target<=nums[j]))
                        i = k+1;
                }
                if (nums[k]<=nums[j]) {
                    if ((nums[k]<target) && (target<=nums[j]))
                        i = k+1;
                    else if ((nums[i]<=target) || (target<nums[k]))
                        j = k-1;
                }
            }
        }
        return -1;
    }
};

int main() {
    Solution solu;
    vector<int> nums = {3,1};
    int target = 1;
    int res = solu.search(nums, target);
    cout<<res<<endl;
}
