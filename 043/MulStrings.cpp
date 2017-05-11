#include <iostream>
#include <string>
#include <vector>
using namespace std;

class Solution {
public:
    string multiply(string num1, string num2) {
        int m1 = num1.size(), m2 = num2.size();
        vector<int> num(m1+m2, 0);
        for (int i = m1-1; i>=0; i--)
            for (int j = m2-1; j>=0; j--)
                num[(m1-i)+(m2-j)-2] += (num1[i]-48)*(num2[j]-48);
        int carry = 0;
        for (int i = 0; i<m1+m2; i++) {
            num[i] += carry;
            carry = num[i]/10;
            num[i] %= 10;
        }
        int i = m1+m2-1;
        while ((i>=0) && (num[i] == 0))
            i--;
        string ans = "";
        if (i<0)
            ans = "0";
        for (int j = i; j>=0; j--)
            ans += to_string(num[j]);
        return ans;
    }
};

int main() {
    Solution solu;
    string num1 = "123";
    string num2 = "456";
    string ans = solu.multiply(num1, num2);
    cout<<ans<<endl;
}
