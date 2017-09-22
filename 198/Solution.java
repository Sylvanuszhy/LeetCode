class Solution {
    public int rob(int[] nums) {
        int[] f = new int[nums.length];
        int[] nf = new int[nums.length];
        if (nums.length>0) {
            f[0] = nums[0];
            nf[0] = 0;
        }
        if (nums.length>1) {
            f[1] = nums[1];
            nf[1] = nums[0];
        }
        for (int i = 2; i<nums.length; i++) {
            f[i] = Math.max(f[i-2], nf[i-1])+nums[i];
            nf[i] = Math.max(f[i-1], nf[i-1]);
        }
        if (nums.length == 0)
            return 0;
        else
            return Math.max(f[nums.length-1], nf[nums.length-1]);
    }
}
