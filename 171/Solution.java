class Solution {
    public int titleToNumber(String s) {
        int len = s.length();
        int[] power = new int[len];
        power[0] = 1;
        int t = 0;
        for (int i = 1; i<len; i++) {
            power[i] = power[i-1]*26;
            t += power[i];
        }
        for (int i = 0; i<len; i++) {
            t += (int)(s.charAt(i)-'A')*power[len-1-i];
        }
        return t+1;
    }
}
