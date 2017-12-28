class Solution {
    public int findKthLargest(int[] nums, int k) {
        return qsort(0, nums.length-1, nums, nums.length-k);
    }

    public int qsort(int left, int right, int[] nums, int k) {
        if (left == right)
            return nums[k];
        int pivot = median3(left, right, nums);
        int i = left, j = right-1;
        while (i<j) {
            while (nums[++i]<pivot) ;
            while (pivot<nums[--j]) ;
            if (i<j)
                swap(i, j, nums);
        }
        swap(i, right-1, nums);
        if (k<i)
            return qsort(left, i-1, nums, k);
        else if (k>i)
            return qsort(i+1, right, nums, k);
        else
            return nums[i];
    }

    public int median3(int left, int right, int[] nums) {
        int center = (left+right)/2;
        if (nums[left]>nums[center])
            swap(left, center, nums);
        if (nums[left]>nums[right])
            swap(left, right, nums);
        if (nums[center]>nums[right])
            swap(center, right, nums);
        swap(center, right-1, nums);
        return nums[right-1];
    }

    public void swap(int x, int y, int[] nums) {
        int tmp = nums[x];
        nums[x] = nums[y];
        nums[y] = tmp;
    }
}
