#include <iostream>
#include <vector>
using namespace std;

class Solution {
public:
    vector<int> getRow(int rowIndex) {
        if (rowIndex == 0)
            return vector<int>(1, 1);
        vector<int> last(2, 1);
        for (int i = 3; i<=rowIndex+1; i++) {
            vector<int> row(i, 1);
            for (int j = 1; j<i-1; j++)
                row[j] = last[j-1]+last[j];
            last = row;
        }
        return last;
    }
};
