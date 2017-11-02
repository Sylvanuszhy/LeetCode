class Solution {
    public int trap(int[] height) {
        int n = height.length;
        if (n == 0)
            return 0;
        int maxVal = -1, t = -1;
        for (int i = 0; i<n; i++)
            if (maxVal<height[i]) {
                maxVal = height[i];
                t = i;
            }
        int val = 0, pos = -1;
        int s = 0;
        for (int i = 0; i<=t; i++)
            if (height[i]>=val) {
                if (val>0) {
                    s += val*(i-pos-1);
                }
                val = height[i];
                pos = i;
            } else {
                s -= height[i];
            }
        val = 0;
        for (int i = n-1; i>=t; i--)
            if (height[i]>=val) {
                if (val>0) {
                    s += val*(pos-i-1);
                }
                val = height[i];
                pos = i;
            } else {
                s -= height[i];
            }
        return s;
    }
}
