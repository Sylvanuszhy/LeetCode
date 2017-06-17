#include <iostream>
#include <string>
#include <vector>
using namespace std;

class Solution {
public:
    vector<string> restoreIpAddresses(string s) {
        vector<string> res;
        int n = s.size();
        for (int i = 0; i<n-3; i++)
            for (int j = i+1; j<=i+4 && j<n-2; j++)
                for (int k = j+1; k<=j+4 && k<n-1; k++) {
                    string ip1 = s.substr(0, i+1);
                    string ip2 = s.substr(i+1, j-i);
                    string ip3 = s.substr(j+1, k-j);
                    string ip4 = s.substr(k+1, n-1-k);
                    if (this->isValidIP(ip1) && this->isValidIP(ip2) && this->isValidIP(ip3) && this->isValidIP(ip4))
                        res.push_back(ip1+"."+ip2+"."+ip3+"."+ip4);
                }
        return res;
    }
private:
    bool isValidIP(string ip) {
        if (ip.size() == 1)
            return true;
        if (ip.size() == 2) {
            int num = (ip[0]-48)*10+(ip[1]-48);
            if (10<=num && num<100)
                return true;
        }
        if (ip.size() == 3) {
            int num = (ip[0]-48)*100+(ip[1]-48)*10+(ip[2]-48);
            if (100<=num && num<256)
                return true;
        }
        return false;
    }
};
