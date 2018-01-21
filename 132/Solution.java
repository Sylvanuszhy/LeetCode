class Solution {
    public int minCut(String s) {
        int n = s.length();
        int[] f = new int[n+1];
        for (int i = 0; i<=n; i++)
            f[i] = i;
        for (int i = 0; i<n; i++) {
            for (int j = 0; i-j>=0 && i+j<n; j++)
                if (s.charAt(i-j) == s.charAt(i+j))
                    f[i+j+1] = Math.min(f[i+j+1], f[i-j]+1);
                else
                    break;
            for (int j = 0; i-j-1>=0 && i+j<n; j++)
                if (s.charAt(i-j-1) == s.charAt(i+j))
                    f[i+j+1] = Math.min(f[i+j+1], f[i-j-1]+1);
                else
                    break;
        }
        return f[n]-1;
    }
}
