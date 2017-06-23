#include <iostream>
#include <string>
using namespace std;

class Solution {
public:
    bool isPalindrome(string s) {
        int i = 0, j = s.size()-1;
        while (i<j) {
            while (i<s.size() && !isValid(s[i]))
                i++;
            while (j>=0 && !isValid(s[j]))
                j--;
            if (i<s.size() && j>=0 && isEqual(s[i], s[j])) {
                i++;
                j--;
            } else {
                break;
            }
        }
        if (i<j)
            return false;
        else
            return true;
    }
private:
    bool isValid(char c) {
        if ('0'<=c && c<='9' || 'a'<=c && c<='z' || 'A'<=c && c<='Z')
            return true;
        else
            return false;
    }
    bool isEqual(char c1, char c2) {
        if (c1 == c2)
            return true;
        if ('a'<=c1 && c1<='z' && c1 == c2+32)
            return true;
        if ('A'<=c1 && c1<='Z' && c1+32 == c2)
            return true;
        return false;
    }
};
