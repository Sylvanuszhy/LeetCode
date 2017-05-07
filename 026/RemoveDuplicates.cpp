#include <iostream>
#include <vector>
using namespace std;

class Solution {
public:
    int removeDuplicates(vector<int>& nums) {
        if (nums.size() == 0)
            return 0;
        vector<int>::iterator itor = nums.begin();
        int prev = *itor-1, cnt = 0;
        for (; itor != nums.end(); itor++) {
            if (*itor != prev)
                nums[cnt++] = *itor;
            prev = *itor;
        }
        return cnt;
    }
};

int main() {
    Solution solu;
    vector<int> nums = {1};
    int len = solu.removeDuplicates(nums);
    cout<<len<<endl;
}
