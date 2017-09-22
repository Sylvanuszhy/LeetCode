class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums.length == 0)
            return 0;
        int minLen = 0;
        int p = 0, q = 0;
        int t = 0;
        while (q<=nums.length) {
            if (t<s) {
                if (q == nums.length)
                    break;
                t += nums[q];
                q++;
            } else {
                int len = q-p;
                if (len<minLen || minLen == 0)
                    minLen = len;
                t -= nums[p];
                p++;
            }
        }
        return minLen;
    }
}
