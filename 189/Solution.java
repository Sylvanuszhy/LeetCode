class Solution {
    public void rotate(int[] nums, int k) {
        int n = 0, st = 0;
        while (n<nums.length) {
            int i = st, j = (st+k)%nums.length, prev = nums[i];
            while (j != st) {
                int tmp = nums[j];
                nums[j] = prev;
                prev = tmp;
                n++;
                i = j;
                j = (j+k)%nums.length;
            }
            nums[j] = prev;
            n++;
            st++;
        }
    }
}
