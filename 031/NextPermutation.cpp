#include <iostream>
#include <vector>
using namespace std;

class Solution {
public:
    void nextPermutation(vector<int>& nums) {
        int i = nums.size()-2;
        while ((i>=0) && (nums[i]>=nums[i+1]))
            i--;
        if (i>=0) {
            int j = nums.size()-1;
            while (nums[i]>=nums[j])
                j--;
            swap(nums[i], nums[j]);
        }
        int p = i+1, q = nums.size()-1;
        while (p<q) {
            swap(nums[p], nums[q]);
            p++;
            q--;
        }
    }
};

int main() {
    Solution solu;
    vector<int> nums = {};
    solu.nextPermutation(nums);
    for (int i = 0; i<nums.size(); i++)
        cout<<nums[i];
}