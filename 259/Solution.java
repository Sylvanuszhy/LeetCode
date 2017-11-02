import java.util.Arrays;

class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        Arrays.sort(nums);
        int t = 0;
        for (int k = 0; k<nums.length-2; k++) {
            int s = target-nums[k];
            int i = k+1, j = nums.length-1;
            while (i<j) {
                if (nums[i]+nums[j]>=s) {
                    j--;
                } else {
                    t += j-i;
                    i++;
                }
            }
        }
        return t;
    }
}
