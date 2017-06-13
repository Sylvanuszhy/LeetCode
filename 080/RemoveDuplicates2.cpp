#include <iostream>
#include <vector>
using namespace std;

class Solution {
public:
    int removeDuplicates(vector<int>& nums) {
        if (nums.size() == 0)
            return 0;
        vector<int>::iterator itor = nums.begin();
        int prev = *itor-1, cnt = 0, s = 0;
        for (; itor != nums.end(); itor++) {
            if (*itor != prev) {
                nums[cnt++] = *itor;
                s = 1;
            } else {
                s++;
                if (s<3)
                    nums[cnt++] = *itor;
            }
            prev = *itor;
        }
        return cnt;
    }
};

int main() {
    Solution solu;
    vector<int> nums = {1,1,1,1,2,3,3,3,3,3};
    int res = solu.removeDuplicates(nums);
    cout<<res<<endl;
}
