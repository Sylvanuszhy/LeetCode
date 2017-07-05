#include <iostream>
#include <vector>
using namespace std;

class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int profit = 0, minPrice = -1;
        vector<int>::iterator itor;
        for (itor = prices.begin(); itor != prices.end(); itor++) {
            if (minPrice == -1 || *itor<minPrice)
                minPrice = *itor;
            if (*itor-minPrice > profit)
                profit = *itor-minPrice;
        }
        return profit;
    }
};
