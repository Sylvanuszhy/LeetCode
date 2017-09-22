class Solution {
    public static int maxProduct(int[] nums) {
        int res = nums[0];
        int maxVal = res, minVal = res;
        for (int i = 1; i<nums.length; i++) {
            if (nums[i]>0) {
                maxVal = Math.max(maxVal*nums[i], nums[i]);
                minVal = Math.min(minVal*nums[i], nums[i]);
            } else {
                int tmpMax = maxVal, tmpMin = minVal;
                maxVal = Math.max(tmpMin*nums[i], nums[i]);
                minVal = Math.min(tmpMax*nums[i], nums[i]);
            }
            if (maxVal>res)
                res = maxVal;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {-4,-3,-2};
        int res = maxProduct(nums);
        System.out.println(res);
    }
}
