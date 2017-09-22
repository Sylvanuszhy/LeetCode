class Solution {
    public int majorityElement(int[] nums) {
        int candidate = nums[0], cnt = 1;
        for (int i = 1; i<nums.length; i++) {
            if (cnt>0) {
                if (nums[i] == candidate)
                    cnt++;
                else
                    cnt--;
            } else {
                candidate = nums[i];
                cnt = 1;
            }
        }
        return candidate;
    }
}
