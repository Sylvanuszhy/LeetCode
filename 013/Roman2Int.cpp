#include <iostream>
#include <string>
#include <vector>
#include <map>
using namespace std;

class Solution {
public:
    int romanToInt(string s) {
        map<char, int> dict = {{'I', 1}, {'V', 5}, {'X', 10}, {'L', 50}, {'C', 100}, {'D', 500}, {'M', 1000}};
        vector<int> digit(s.size());
        int cnt = 0;
        for (char c : s)
            digit[cnt++] = dict[c];
        for (int i = 0; i<digit.size()-1; i++) {
            if (digit[i]<digit[i+1])
                digit[i] = -digit[i];
        }
        int num = 0;
        for (int i = 0; i<digit.size(); i++)
            num += digit[i];
        return num;
    }
};

int main() {
    Solution solu;
    string s = {"DMVI"};
    int res = solu.romanToInt(s);
    cout<<res<<endl;
}
