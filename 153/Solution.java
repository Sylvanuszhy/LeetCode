class Solution {
    public int findMin(int[] nums) {
        int i = 0, j = nums.length-1;
        while (i<j) {
            if (nums[i]<nums[j])
                break;
            int k = (i+j)/2;
            if (nums[i]<=nums[k])
                i = k+1;
            if (nums[k]<nums[j])
                j = k;
        }
        return nums[i];
    }
}
