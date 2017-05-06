#include <iostream>
#include <vector>
using namespace std;

class Solution {
public:
    vector<vector<int> > threeSum(vector<int>& nums) {
        vector<vector<int> > ans;
        if (nums.size()<3)
            return ans;
        sort(nums.begin(), nums.end());
        vector<int>::iterator target;
        for (target = nums.begin(); target != nums.end()-1; target++) {
            vector<int>::iterator p = target+1, q = nums.end()-1;
            while (p<q) {
                int sum = *p + *q;
                if (sum < -(*target)) {
                    p++;
                } else if (sum > -(*target)) {
                    q--;
                } else {
                    vector<int> triplet = {*target, *p, *q};
                    ans.push_back(triplet);
                    while ((p<q) && (*q == *(q-1)))
                        q--;
                    while ((p<q) && (*p == *(p+1)))
                        p++;
                    p++;
                    q--;
                }
            }
            while ((target != nums.end()-2) && (*target == *(target+1)))
                target++;
        }
        return ans;
    }
};

int main() {
    Solution solu;
    vector<int> nums = {0, 1, 1};
    solu.threeSum(nums);
}
