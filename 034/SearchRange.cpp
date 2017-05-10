#include <iostream>
#include <vector>
using namespace std;

class Solution {
public:
    vector<int> searchRange(vector<int>& nums, int target) {
        vector<int> rang = {-1, -1};

        int i = 0, j = nums.size()-1;
        while (i<j) {
            int k = (i+j)/2;
            if (nums[k]<target)
                i = k+1;
            if (target<=nums[k])
                j = k-1;
        }
        if ((j>=0) && (nums[j] == target))
            rang[0] = j;
        else if ((j+1<nums.size()) && (nums[j+1] == target))
            rang[0] = j+1;
        
        i = 0, j = nums.size()-1;
        while (i<j) {
            int k = (i+j)/2;
            if (nums[k]<=target)
                i = k+1;
            if (target<nums[k])
                j = k-1;
        }
        if ((j>=0) && (nums[j] == target))
            rang[1] = j;
        else if ((j-1>=0) && (nums[j-1] == target))
            rang[1] = j-1;
        
        return rang;
    }
};

int main() {
    Solution solu;
    vector<int> nums = {-1};
    int target = 5;
    vector<int> res = solu.searchRange(nums, target);
    cout<<res[0]<<res[1]<<endl;
}
