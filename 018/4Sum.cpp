#include <iostream>
#include <vector>
using namespace std;

class Solution {
public:
    vector<vector<int> > fourSum(vector<int>& nums, int target) {
        vector<vector<int> > ans;
        if (nums.size()<4)
            return ans;
        sort(nums.begin(), nums.end());
        vector<int>::iterator num1, num2;
        for (num1 = nums.begin(); num1 != nums.end()-3; num1++) {
            for (num2 = num1+1; num2 != nums.end()-2; num2++) {
                vector<int>::iterator p = num2+1, q = nums.end()-1;
                while (p<q) {
                    int sum = *p + *q;
                    if (sum < (target - *num1 - *num2)) {
                        p++;
                    } else if (sum > (target - *num1 - *num2)) {
                        q--;
                    } else {
                        vector<int> quadruplet = {*num1, *num2, *p, *q};
                        ans.push_back(quadruplet);
                        while ((p<q) && (*q == *(q-1)))
                            q--;
                        while ((p<q) && (*p == *(p+1)))
                            p++;
                        p++;
                        q--;
                    }
                }
                while ((num2 != nums.end()-3) && (*num2 == *(num2+1)))
                    num2++;
            }
            while ((num1 != nums.end()-4) && (*num1 == *(num1+1)))
                    num1++;
        }
        return ans;
    }
};

int main() {
    Solution solu;
    vector<int> nums = {1,0,-1,0,-2,2};
    int target = 0;
    solu.fourSum(nums, target);
}
