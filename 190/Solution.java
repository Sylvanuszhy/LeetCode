public class Solution {
    // you need treat n as an unsigned value
    public static int reverseBits(int n) {
        int m = 0;
        for (int i = 0; i<32; i++) {
            m = m<<1;
            if (Math.abs(n%2) == 1)
                m += 1;
            n = n>>1;
        }
        return m;
    }

    public static void main(String[] args) {
        int res = reverseBits(-2147483647);
        System.out.println(res);
    }
}
