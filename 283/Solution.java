class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int p = 0, q = 0;
        while (q<n) {
            if (nums[q] != 0) {
                nums[p] = nums[q];
                p++;
            }
            q++;
        }
        for (int i = p; i<n; i++)
            nums[i] = 0;
    }
}
