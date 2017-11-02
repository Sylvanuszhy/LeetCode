class Solution {
    public String encode(String s) {
        int n = s.length();
        String[][] f = new String[n][n];
        for (int l = 1; l<=n; l++) {
            for (int i = 0; i<=n-l; i++) {
                int j = i+l-1;
                f[i][j] = s.substring(i, j+1);
                for (int k = i; k<j; k++) {
                    if (f[i][j].length()>f[i][k].length()+f[k+1][j].length())
                    f[i][j] = f[i][k]+f[k+1][j];
                    String patt = s.substring(i, k+1);
                    String t = s.substring(k+1, j+1);
                    if (t.length()%patt.length() == 0 && t.replaceAll(patt, "").isEmpty()) {
                        int cnt = t.length()/patt.length();
                        String enc = String.valueOf(cnt+1)+"["+f[i][k]+"]";
                        if (f[i][j].length()>enc.length())
                            f[i][j] = enc;
                    }
                }
            }
        }
        return f[0][n-1];
    }
}
