#include <iostream>
#include <vector>
using namespace std;

class Solution {
public:
    bool searchMatrix(vector<vector<int>>& matrix, int target) {
        int i = 0, j = matrix.size()-1;
        if (j<0)
            return false;
        while (i<j) {
            int k = (i+j+1)/2;
            if (matrix[k][0]>target)
                j = k-1;
            else
                i = k;
        }
        int x = i;
        i = 0, j = matrix[x].size()-1;
        while (i<=j) {
            int k = (i+j)/2;
            if (matrix[x][k]>target)
                j = k-1;
            else if (matrix[x][k]<target)
                i = k+1;
            else
                return true;
        }
        return false;
    }
};
