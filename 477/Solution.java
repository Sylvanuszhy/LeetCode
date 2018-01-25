class Solution {
    public int totalHammingDistance(int[] nums) {
        int n = nums.length;
        boolean flag = true;
        int sum = 0;
        while (flag) {
            flag = false;
            int k = 0;
            for (int i = 0; i<n; i++) {
                if (nums[i]>0)
                    flag = true;
                k += nums[i]%2;
                nums[i] = nums[i]/2;
            }
            sum += k*(n-k);
        }
        return sum;
    }
}
