class Solution {
    public String shortestPalindrome(String s) {
        int[] next = new int[s.length()];
        for (int k = 0, i = 1; i<s.length(); i++) {
            while (k>0 && s.charAt(i) != s.charAt(k))
                k = next[k-1];
            if (s.charAt(i) == s.charAt(k))
                k++;
            next[i] = k;
        }
        String t = new StringBuilder(s).reverse().toString();
        int k = 0;
        for (int i = 0; i<t.length(); i++) {
            while (k>0 && t.charAt(i) != s.charAt(k))
                k = next[k-1];
            if (t.charAt(i) == s.charAt(k))
                k++;
        }
        return t+s.substring(k);
    }
}
