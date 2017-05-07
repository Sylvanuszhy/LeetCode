#include <iostream>
#include <vector>
using namespace std;

class Solution {
public:
    int removeElement(vector<int>& nums, int val) {
        vector<int>::iterator itor;
        int cnt = 0;
        for (itor = nums.begin(); itor != nums.end(); itor++) {
            if (*itor != val)
                nums[cnt++] = *itor;
        }
        return cnt;
    }
};

int main() {
    Solution solu;
    vector<int> nums = {3,2,2,3};
    int val = 3;
    int len = solu.removeElement(nums, val);
    cout<<len<<endl;
}
