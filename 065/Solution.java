class Solution {
    public boolean isNumber(String s) {
        int len = s.length();
        char c = s.charAt(len-1);
        if (Character.isLetter(c))
            return false;
        try {
            Float.parseFloat(s);
            return true;
        } catch (Exception NumberFormatException) {
            return false;
        }
    }
}
