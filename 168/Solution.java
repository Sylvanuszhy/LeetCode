import java.util.ArrayList;
import java.util.List;

class Solution {
    public String convertToTitle(int n) {
        ArrayList<Integer> power = new ArrayList<Integer>();
        power.add(1);
        int s = 0;
        long m = 26;
        while (s+m < (long)n) {
            s += m;
            power.add((int)m);
            m *= 26;
        }
        n -= s;
        StringBuilder str = new StringBuilder();
        for (int i = power.size()-1; i>=0; i--) {
            int k = (n-1)/power.get(i);
            n -= k*power.get(i);
            char c = (char)('A'+k);
            str.append(c);
        }
        return str.toString();
    }
}
