#include <iostream>
#include <vector>
using namespace std;

class Solution {
public:
    int maxArea(vector<int>& height) {
        int i = 0, j = height.size()-1;
        int lHeight = height[i];
        int rHeight = height[j];
        int mostWater = min(lHeight, rHeight)*j;
        while (i<j) {
            if (lHeight<rHeight) {
                while (height[i]<=lHeight && i<j)
                    i++;
                lHeight = height[i];
            } else {
                while (height[j]<=rHeight && i<j)
                    j--;
                rHeight = height[j];
            }
            int water = min(lHeight, rHeight)*(j-i);
            if (water>mostWater)
                mostWater = water;
        }
        return mostWater;
    }
};

int main() {
    Solution solu;
    vector<int> height = {1, 2, 6, 5, 1};
    int res = solu.maxArea(height);
    cout<<res<<endl;
}
