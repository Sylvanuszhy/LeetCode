import java.util.ArrayList;

class Solution {
    public int countPrimes(int n) {
        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 2; i<n; i++) {
            if (isPrime[i])
                list.add(i);
            for (int j = 0; j<list.size(); j++) {
                if (i*list.get(j)>=n)
                    break;
                isPrime[i*list.get(j)] = false;
                if (i%list.get(j) == 0)
                    break;
            }
        }
        return list.size();
    }
}
