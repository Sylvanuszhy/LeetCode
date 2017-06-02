#include <iostream>
#include <vector>
using namespace std;

class Solution {
public:
    vector<int> plusOne(vector<int>& digits) {
        vector<int> res(digits.size()+1);
        int carry = 1;
        for (int i = digits.size()-1; i>=0; i--) {
            res[i] = digits[i]+carry;
            carry = res[i]/10;
            res[i] = res[i]%10;
        }
        if (carry>0) {
            for (int i = digits.size(); i>0; i--)
                res[i] = res[i-1];
            res[0] = carry;
        } else {
            res.pop_back();
        }
        return res;
    }
};

int main() {
    Solution solu;
    vector<int> digits = {9,9,9,8};
    vector<int> res = solu.plusOne(digits);
    for (int i = 0; i<res.size(); i++)
        cout<<res[i];
}
