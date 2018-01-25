class Solution {
    public boolean validPalindrome(String s) {
        int i = 0, j = s.length()-1;
        while (i<j && s.charAt(i) == s.charAt(j)) {
            i++;
            j--;
        }
        if (i<j)
            return checkPalindrome(s, i+1, j) || checkPalindrome(s, i, j-1);
        else
            return true;
    }
    
    public boolean checkPalindrome(String s, int i, int j) {
        while (i<j && s.charAt(i) == s.charAt(j)) {
            i++;
            j--;
        }
        if (i<j)
            return false;
        else
            return true;
    }
}
