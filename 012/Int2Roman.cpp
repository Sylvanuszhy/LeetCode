#include <iostream>
#include <string>
using namespace std;

class Solution {
public:
    string intToRoman(int num) {
        string basic = "IVXLCDM__";
        string thousand = convertDigit(num/1000, basic.substr(6, 3));
        string hundred = convertDigit(num/100%10, basic.substr(4, 3));
        string ten = convertDigit(num/10%10, basic.substr(2, 3));
        string one = convertDigit(num%10, basic.substr(0, 3));
        return thousand+hundred+ten+one;
    }
private:
    string convertDigit(int digit, string b) {
        string b1(1, b[0]), b5(1, b[1]), b10(1, b[2]);
        string str = "";
        switch (digit) {
            case 5:
                str = b5;
                break;
            case 4:
                str = b1+b5;
                break;
            case 9:
                str = b1+b10;
                break;
            default:
                if (digit>5)
                    str = b5;
                for (int i = 0; i<digit%5; i++)
                    str += b1;
        }
        return str;
    }
};

int main() {
    Solution solu;
    int num = 1;
    string res = solu.intToRoman(num);
    cout<<res<<endl;
}
