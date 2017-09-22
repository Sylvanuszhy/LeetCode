class Solution {
    public int maximumGap(int[] nums) {
        int m = 10;
        for (int i = 0; i<m; i++) {
            int[] cnt = {0,0,0,0,0,0,0,0,0,0};
            for (int j = 0; j<nums.length; j++) {
                int digit = nums[j]/(int)Math.pow(10, i)%10;
                cnt[digit]++;
            }
            for (int j = 1; j<m; j++)
                cnt[j] += cnt[j-1];
            int[] tmp = new int[nums.length];
            for (int j = nums.length-1; j>=0; j--) {
                int digit = nums[j]/(int)Math.pow(10, i)%10;
                cnt[digit]--;
                tmp[cnt[digit]] = nums[j];
            }
            for (int j = 0; j<nums.length; j++)
                nums[j] = tmp[j];
        }
        int max = 0;
        for (int i = 1; i<nums.length; i++)
            if (nums[i]-nums[i-1] > max)
                max = nums[i]-nums[i-1];
        return max;
    }
}
