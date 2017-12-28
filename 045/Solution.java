class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int p = 0, q = 0;
        int s = 0;
        while (q<n-1) {
            int r = q;
            for (int i = p; i<=q; i++)
                r = Math.max(r, i+nums[i]);
            p = q+1;
            q = r;
            s++;
        }
        return s;
    }
}
