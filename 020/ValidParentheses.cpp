#include <iostream>
#include <vector>
using namespace std;

class Solution {
public:
    bool isValid(string s) {
        vector<char> stack;
        for (char c : s) {
            switch (c) {
                case ')':
                    if (!stack.empty() && stack.back() == '(')
                        stack.pop_back();
                    else
                        return false;
                    break;
                case ']':
                    if (!stack.empty() && stack.back() == '[')
                        stack.pop_back();
                    else
                        return false;
                    break;
                case '}':
                    if (!stack.empty() && stack.back() == '{')
                        stack.pop_back();
                    else
                        return false;
                    break;
                default:
                    stack.push_back(c);
            }
        }
        if (stack.empty())
            return true;
        else
            return false;
    }
};

int main() {
    Solution solu;
    string str = {")"};
    bool res = solu.isValid(str);
    cout<<res<<endl;
}
