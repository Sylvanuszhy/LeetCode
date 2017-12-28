class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        if (n == 0)
            return 1;
        for (int i = 0; i<n; i++) {
            int m = nums[i];
            if (m>0 && m<n && m != i && nums[m] != m) {
                int tmp = nums[m];
                nums[m] = nums[i];
                nums[i] = tmp;
                i--;
            }
        }
        for (int i = 1; i<n; i++)
            if (nums[i] != i)
                return i;
        if (nums[0] != n)
            return n;
        else
            return n+1;
    }
}
