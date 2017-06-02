#include <iostream>
#include <string>
using namespace std;

class Solution {
public:
    string addBinary(string a, string b) {
        string one = "1", zero = "0", res = "";
        int i = a.size()-1, j = b.size()-1, carry = 0;
        while (i>=0 || j>=0) {
            int x = (i>=0) ? a[i]-48 : 0;
            int y = (j>=0) ? b[j]-48 : 0;
            int s = x+y+carry;
            if (s%2 == 0)
                res = zero+res;
            else
                res = one+res;
            carry = s/2;
            i--, j--;
        }
        if (carry>0)
            res = one+res;
        return res;
    }
};

int main() {
    Solution solu;
    string a = "1", b = "10";
    string res = solu.addBinary(a, b);
    cout<<res<<endl;
}
