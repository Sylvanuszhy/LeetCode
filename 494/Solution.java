class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        if (Math.abs(S)>1000)
            return 0;
        int[] f = new int[2001];
        f[1000] = 1;
        for (int num : nums) {
            int[] tmp = new int[2001];
            for (int i = -1000; i<=1000; i++)
                if (f[i+1000]>0) {
                    tmp[num+i+1000] += f[i+1000];
                    tmp[-num+i+1000] += f[i+1000];
                }
            f = tmp;
        }
        return f[S+1000];
    }
}
