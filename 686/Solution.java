class Solution {
    public int repeatedStringMatch(String A, String B) {
        int m = A.length();
        int n = B.length();
        int cnt = n/m;
        if (cnt*m<n)
            cnt += 1;
        String rep = new String(new char[cnt]).replaceAll("\0", A);
        if (rep.contains(B))
            return cnt;
        if ((rep+A).contains(B))
            return cnt+1;
        return -1;
    }
}
