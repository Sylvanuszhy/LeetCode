#include <iostream>
#include <vector>
using namespace std;

class Solution {
public:
    bool search(vector<int>& nums, int target) {
        int i = 0, j = nums.size()-1;
        while (i<=j) {
            int k = (i+j)/2;
            if (target == nums[k])
                return true;
            if (nums[i]<nums[j]) {
                if (nums[k]<target)
                    i = k+1;
                if (target<nums[k])
                    j = k-1;
            } else {
                if ((target<nums[i]) && (target>nums[j]))
                    break;
                if (nums[i]<nums[k]) {
                    if ((nums[i]<=target) && (target<nums[k]))
                        j = k-1;
                    else if ((nums[k]<target) || (target<=nums[j]))
                        i = k+1;
                    continue;
                }
                if (nums[k]<nums[j]) {
                    if ((nums[k]<target) && (target<=nums[j]))
                        i = k+1;
                    else if ((nums[i]<=target) || (target<nums[k]))
                        j = k-1;
                    continue;
                }
                if (nums[i] == nums[k] || nums[k]==nums[j]) {
                    if (nums[i]>nums[k]) {
                        j = k-1;
                        continue;
                    }
                    if (nums[k]>nums[j]) {
                        i = k+1;
                        continue;
                    }
                    if (nums[i] == nums[j]) {
                        i++;
                        j--;
                    }
                }
            }
        }
        return false;
    }
};

int main() {
    Solution solu;
    vector<int> nums = {3,1};
    int target = 1;
    bool res = solu.search(nums, target);
    cout<<res<<endl;
}
