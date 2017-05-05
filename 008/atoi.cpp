#include <iostream>
#include <string>
using namespace std;

class Solution {
public:
    int myAtoi(string str) {
        int i = 0;
        while (isspace(str[i]) && i<str.size())
            i++;

        bool isMinus = false;
        if (str[i] == '-') {
            isMinus = true;
            i++;
        } else if (str[i] == '+') {
            isMinus = false;
            i++;
        }

        long num = 0;
        for (; i<str.size(); i++) {
            if (isdigit(str[i])) {
                int digit = str[i]-48;
                num = num*10+digit;
                if (num<INT_MIN || num>INT_MAX)
                    break;
            } else {
                break;
            }
        }
        if (isMinus)
            num = -num;
        
        if (num<INT_MIN)
            num = INT_MIN;
        if (num>INT_MAX)
            num = INT_MAX;
        return num;
    }
};

int main() {
    Solution solu;
    string s = "9223372036854775809";
    int res = solu.myAtoi(s);
    cout<<res<<endl;
}
