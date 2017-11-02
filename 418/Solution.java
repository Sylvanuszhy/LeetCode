class Solution {
    public int wordsTyping(String[] sentence, int rows, int cols) {
        int n = sentence.length;
        int[] s = new int[2*n];
        s[0] = sentence[0].length();
        for (int i = 1; i<2*n; i++)
            s[i] = s[i-1]+sentence[i%n].length();
        
        int t = cols/(s[n-1]+n);
        cols -= t*(s[n-1]+n);
        int[] next = new int[n];
        for (int i = 0; i<n; i++) {
            next[i] = i;
            for (int j = i+1; j<2*n; j++)
                if (s[j]-s[i]+j-i-1<=cols)
                    next[i] = j;
                else
                    break;
        }

        int last = n-1, m = 0;
        for (int i = 0; i<rows; i++) {
            last = next[last];
            if (last>=n) {
                last -= n;
                m++;
            }
        }
        if (last<n-1)
            m--;
        return m+rows*t;
    }
}
