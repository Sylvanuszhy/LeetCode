class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0, -1);
        int sum = 0;
        for (int i = 0; i<nums.length; i++) {
            sum += nums[i];
            if (k != 0)
                sum = sum%k;
            if (map.containsKey(sum)) {
                int pos = map.get(sum);
                if (i-pos>=2)
                    return true;
            } else {
                map.put(sum, i);
            }
        }
        return false;
    }
}
