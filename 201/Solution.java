class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        int t = -1;
        while ((m&t) != (n&t))
            t = t<<1;
        return m&t;
    }
}
