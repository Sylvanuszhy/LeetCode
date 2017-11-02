class Solution {
    public boolean isStrobogrammatic(String num) {
        int[] rotate = {0, 1, -1, -1, -1, -1, 9, -1, 8, 6};
        int n = num.length();
        for (int i = 0; i<n; i++) {
            char c = num.charAt(i);
            int d = c-48;
            if (d>=0 && d<=9 && rotate[d] != -1) {
                if (num.charAt(n-1-i)-48 == rotate[d])
                    continue;
            }
            return false;
        }
        return true;
    }
}
