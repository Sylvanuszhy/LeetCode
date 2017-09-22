class Solution {
    public int countDigitOne(int n) {
        long t = 1;
        int s = 0;
        while (n/t>0) {
            int before = n/t/10;
            int current = n/t%10;
            int after = n%t;
            if (current == 0)
                s += before*t;
            else if (current == 1)
                s += before*t+(after+1);
            else
                s += (before+1)*t;
            t *= 10;
        }
        return s;
    }
}
