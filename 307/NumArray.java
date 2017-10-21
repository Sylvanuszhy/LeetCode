class NumArray {

    public int n;
    public int[] tree;

    public NumArray(int[] nums) {
        n = nums.length;
        int[] s = new int[n+1];
        s[0] = 0;
        for (int i = 0; i<n; i++)
            s[i+1] = s[i]+nums[i];
        tree = new int[n+1];
        for (int i = 1; i<=n; i++) {
            int j = i - (i & -i);
            tree[i] = s[i]-s[j];
        }
    }
    
    public void update(int i, int val) {
        int k = i+1;
        int ori = getSingle(k);
        int inc = val-ori;
        while (k<=n) {
            tree[k] += inc;
            k += (k & -k);
        }
    }
    
    public int sumRange(int i, int j) {
        int k = i;
        int si = 0;
        while (k>0) {
            si += tree[k];
            k -= (k & -k);
        }
        k = j+1;
        int sj = 0;
        while (k>0) {
            sj += tree[k];
            k -= (k & -k);
        }
        return sj-si;
    }

    public int getSingle(int k) {
        int s = tree[k];
        int z = k - (k & -k);
        k -= 1;
        while (k>z) {
            s -= tree[k];
            k -= (k & -k);
        }
        return s;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */