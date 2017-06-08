#include <iostream>
#include <vector>
using namespace std;

class Solution {
public:
    void sortColors(vector<int>& nums) {
        int i = 0, j = nums.size()-1;
        for (int k = 0; k<=j; k++) {
            switch (nums[k]) {
                case 0: swap(nums[i++], nums[k]); break;
                case 2: swap(nums[j--], nums[k--]); break;
            }
        }
    }
};
