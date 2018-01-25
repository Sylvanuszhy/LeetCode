class NumArray {
    
    public int[] a;

    public NumArray(int[] nums) {
        int n = nums.length;
        a = new int[n+1];
        a[0] = 0;
        for (int i = 0; i<n; i++)
            a[i+1] = a[i]+nums[i];
    }
    
    public int sumRange(int i, int j) {
        return a[j+1]-a[i];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */