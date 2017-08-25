class Solution {
    public int findPeakElement(int[] nums) {
        int i = 0, j = nums.length-1;
        while (j-i>=3) {
            int mid1 = i+(j-i)/3;
            int mid2 = j-(j-i)/3;
            if (nums[mid1]>nums[mid2])
                j = mid2;
            else
                i = mid1;
        }
        int mid = (i+j)/2;
        if (nums[i]>=nums[mid] && nums[i]>=nums[j])
            return i;
        else if (nums[j]>=nums[i] && nums[j]>=nums[mid])
            return j;
        else
            return mid;
    }
}
