public class Solution {
    // you need to treat n as an unsigned value
    public static int hammingWeight(int n) {
        int m = 0;
        for (int i = 0; i<32; i++) {
            if (Math.abs(n%2) == 1)
                m += 1;
            n = n>>1;
        }
        return m;
    }

    public static void main(String[] args) {
        int res = hammingWeight(11);
        System.out.println(res);
    }
}
