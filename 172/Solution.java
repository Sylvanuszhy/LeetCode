class Solution {
    public int trailingZeroes(int n) {
        long m = 5;
        int s = 0;
        while (m<=(long)n) {
            s += n/m;
            m *= 5;
        }
        return s;
    }
}
