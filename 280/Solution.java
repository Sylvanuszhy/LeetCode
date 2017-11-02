class Solution {
    public void wiggleSort(int[] nums) {
        if (nums.length<2)
            return;
        if (nums[0]>nums[1]) {
            exchange(0, 1, nums);
        }
        for (int i = 2; i<nums.length; i++) {
            if (i%2 == 0 && nums[i]>nums[i-1]) {
                exchange(i, i-1, nums);
            }
            if (i%2 == 1 && nums[i]<nums[i-1]) {
                exchange(i, i-1, nums);
            }
        }
    }

    public void exchange(int x, int y, int[] nums) {
        int tmp = nums[x];
        nums[x] = nums[y];
        nums[y] = tmp;
    }
}
