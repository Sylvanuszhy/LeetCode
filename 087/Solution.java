class Solution {
    public boolean isScramble(String s1, String s2) {
        if (s1.equals(s2))
            return true;
        if (s1.length() != s2.length())
            return false;
        int[] chars = new int[26];
        int m = s1.length();
        for (int i = 0; i<m; i++) {
            chars[s1.charAt(i)-'a'] += 1;
            chars[s2.charAt(i)-'a'] -= 1;
        }
        for (int i = 0; i<26; i++)
            if (chars[i] != 0)
                return false;
        for (int k = 1; k<m; k++) {
            if (isScramble(s1.substring(0, k), s2.substring(0, k)) 
                && isScramble(s1.substring(k, m), s2.substring(k, m)))
                return true;
            if (isScramble(s1.substring(0, k), s2.substring(m-k, m)) 
                && isScramble(s1.substring(k, m), s2.substring(0, m-k)))
                return true;
        }
        return false;
    }
}
