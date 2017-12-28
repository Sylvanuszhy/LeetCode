class Solution {
    public int rob(int[] nums) {
        int[] f0 = new int[nums.length];
        int[] nf0 = new int[nums.length];
        int[] f1 = new int[nums.length];
        int[] nf1 = new int[nums.length];
        if (nums.length>0) {
            f0[0] = 0;
            nf0[0] = 0;
            f1[0] = nums[0];
            nf1[0] = 0;         // impossible
        }
        if (nums.length>1) {
            f0[1] = nums[1];
            nf0[1] = 0;
            f1[1] = 0;          // impossible
            nf1[1] = nums[0];
        }
        for (int i = 2; i<nums.length; i++) {
            f0[i] = Math.max(f0[i-2], nf0[i-1])+nums[i];
            nf0[i] = Math.max(f0[i-1], nf0[i-1]);
            f1[i] = Math.max(f1[i-2], nf1[i-1])+nums[i];
            nf1[i] = Math.max(f1[i-1], nf1[i-1]);
        }
        if (nums.length == 0)
            return 0;
        else if (nums.length == 1)
            return nums[0];
        else
            return Math.max(Math.max(f0[nums.length-1], nf0[nums.length-1]), 
                            Math.max(f1[nums.length-2], nf1[nums.length-2]));
    }
}
