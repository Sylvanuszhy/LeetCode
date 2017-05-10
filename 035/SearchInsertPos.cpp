#include <iostream>
#include <vector>
using namespace std;

class Solution {
public:
    int searchInsert(vector<int>& nums, int target) {
        int i = 0, j = nums.size()-1;
        while (i<j) {
            int k = (i+j)/2;
            if (nums[k]<target)
                i = k+1;
            if (target<=nums[k])
                j = k-1;
        }
        if (j<0)
            return 0;
        if (nums[j]<target)
            return j+1;
        else
            return j;
    }
};

int main() {
    Solution solu;
    vector<int> nums = {1,2};
    int target = 0;
    int res = solu.searchInsert(nums, target);
    cout<<res<<endl;
}
