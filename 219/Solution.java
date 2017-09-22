import java.util.HashMap;

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap map = new HashMap<Integer, Integer>();
        for (int i = 0; i<nums.length; i++) {
            if (map.containsKey(nums[i])) {
                int pos = (int)map.get(nums[i]);
                if (i-pos<=k)
                    return true;
                else
                    map.put(nums[i], i);
            } else {
                map.put(nums[i], i);
            }
        }
        return false;
    }
}
