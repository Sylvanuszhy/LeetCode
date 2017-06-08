#include <iostream>
#include <vector>
using namespace std;

class Solution {
public:
    void merge(vector<int>& nums1, int m, vector<int>& nums2, int n) {
        int k = m+n-1;
        m--, n--;
        while (k>=0) {
            if (m<0) {
                nums1[k] = nums2[n];
                n--, k--;
                continue;
            }
            if (n<0) {
                nums1[k] = nums1[m];
                m--, k--;
                continue;
            }
            if (nums1[m]<nums2[n]) {
                nums1[k] = nums2[n];
                n--;
            } else {
                nums1[k] = nums1[m];
                m--;
            }
            k--;
        }
    }
};
