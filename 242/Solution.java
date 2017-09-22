class Solution {
    public boolean isAnagram(String s, String t) {
        int[] wc = new int[26];
        for (int i = 0; i<s.length(); i++)
            wc[s.charAt(i)-'a'] += 1;
        for (int i = 0; i<t.length(); i++)
            wc[t.charAt(i)-'a'] -= 1;
        for (int cnt : wc)
            if (cnt != 0)
                return  false;
        return true;
    }
}
