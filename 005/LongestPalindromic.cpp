#include <iostream>
#include <string>
#include <vector>
using namespace std;

class Solution {
public:
    string longestPalindrome(string s) {
        vector<int> maxlen1(s.size(), 1);
        vector<int> maxlen2(s.size(), 0);
        for (int i = 0; i<s.size(); i++) {
            int j = 1;
            while ((i-j>=0) && (i+j<s.size())) {
                if (s[i-j] == s[i+j]) {
                    maxlen1[i] += 2;
                    j++;
                } else {
                    break;
                }
            }

            int k = 0;
            while ((i-k>=0) && (i+1+k<s.size())) {
                if (s[i-k] == s[i+1+k]) {
                    maxlen2[i] += 2;
                    k++;
                } else {
                    break;
                }
            }
        }

        int maxlength = 0;
        string str;
        for (int i = 0; i<s.size(); i++) {
            if (maxlen1[i]>maxlength) {
                maxlength = maxlen1[i];
                str = s.substr(i-maxlength/2, maxlength);
            }
            if (maxlen2[i]>maxlength) {
                maxlength = maxlen2[i];
                str = s.substr(i-maxlength/2+1, maxlength);
            }
        }

        return str;
    }
};

int main() {
    Solution solu;
    string s = "cbbd";
    string res = solu.longestPalindrome(s);
    cout<<res<<endl;
}
