import java.util.HashMap;

class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        HashMap map = new HashMap<Character, Integer>();
        int j = 0, maxLen = 0;
        for (int i = 0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                int count = (int)map.get(c);
                map.put(c, count+1);
            } else {
                map.put(c, 1);
                while (map.keySet().size()>k) {
                    char key = s.charAt(j);
                    int val = (int)map.get(key);
                    if (val == 1)
                        map.remove(key);
                    else
                        map.put(key, val-1);
                    j++;
                }
            }
            maxLen = Math.max(maxLen, i-j+1);
        }
        return maxLen;
    }
};
