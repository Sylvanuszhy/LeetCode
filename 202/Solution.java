import java.util.HashSet;

class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<Integer>();
        int m = n;
        while (set.add(m)) {
            int t = 0;
            while (m>0) {
                t += (m%10)*(m%10);
                m /= 10;
            }
            if (t == 1)
                return true;
            else
                m = t;
        }
        return false;
    }
}
