import java.util.HashMap;

class Solution {
    public int longestConsecutive(int[] nums) {
        HashMap map = new HashMap<Integer, Integer>();
        int maxLen = 0;
        for (int i = 0; i<nums.length; i++) {
            int k = nums[i];
            if (map.containsKey(k))
                continue;
            int leftLen = map.containsKey(k-1) ? (int)map.get(k-1) : 0;
            int rightLen = map.containsKey(k+1) ? (int)map.get(k+1) : 0;
            int len = leftLen+1+rightLen;
            map.put(k, len);
            map.put(k-leftLen, len);
            map.put(k+rightLen, len);
            maxLen = Math.max(maxLen, len);
        }
        return maxLen;
    }
}
