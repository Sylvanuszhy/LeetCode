class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        if (m>n) {
            int[] tmp = nums1;
            nums1 = nums2;
            nums2 = tmp;
            m = nums1.length;
            n = nums2.length;
        }
        int p = 0, q = m;
        while (p<=q) {
            int i = (p+q)/2;
            int j = (m+n+1)/2-i;
            if (i>0 && nums1[i-1]>nums2[j]) {
                q = i-1;
            } else if (i<m && nums1[i]<nums2[j-1]) {
                p = i+1;
            } else {
                if ((m+n)%2 == 1) {
                    if (i>0)
                        return Math.max(nums1[i-1], nums2[j-1]);
                    else
                        return nums2[j-1];
                } else {
                    int left, right;
                    if (i == 0)
                        left = nums2[j-1];
                    else if (j == 0)
                        left = nums1[i-1];
                    else
                        left = Math.max(nums1[i-1], nums2[j-1]);
                    if (i == m)
                        right = nums2[j];
                    else if (j == n)
                        right = nums1[i];
                    else
                        right = Math.min(nums1[i], nums2[j]);
                    return (left+right)/2.0;
                }
            }
        }
        return 0;
    }
}
