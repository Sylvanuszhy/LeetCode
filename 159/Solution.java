class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        char c1 = '#', c2 = '#';
        int s1 = 0, s2 = 0;
        int j = 0, maxLen = 0;
        for (int i = 0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (s1>0 && c == c1) {
                s1++;
                maxLen = Math.max(maxLen, i-j+1);
                continue;
            }
            if (s2>0 && c == c2) {
                s2++;
                maxLen = Math.max(maxLen, i-j+1);
                continue;
            }
            while (s1>0 && s2>0) {
                if (s.charAt(j) == c1)
                    s1--;
                if (s.charAt(j) == c2)
                    s2--;
                j++;
            }
            if (s1 == 0) {
                c1 = c;
                s1 = 1;
            } else if (s2 == 0) {
                c2 = c;
                s2 = 1;
            }
            maxLen = Math.max(maxLen, i-j+1);
        }
        return maxLen;
    }
}
