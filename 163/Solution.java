class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        ArrayList<String> ranges = new ArrayList<String>();
        int n = nums.length;
        if (n == 0) {
            if (lower == upper)
                ranges.add(String.valueOf(lower));
            if (lower<upper)
                ranges.add(String.valueOf(lower)+"->"+String.valueOf(upper));
            return ranges;
        }
        long diff = (long)nums[0] - (long)lower;
        if (diff == 1)
            ranges.add(String.valueOf(lower));
        if (diff>1)
            ranges.add(String.valueOf(lower)+"->"+String.valueOf(nums[0]-1));
        for (int i = 1; i<n; i++) {
            diff = (long)nums[i] - (long)nums[i-1];
            if (diff == 2)
                ranges.add(String.valueOf(nums[i]-1));
            if (diff>2)
                ranges.add(String.valueOf(nums[i-1]+1)+"->"+String.valueOf(nums[i]-1));
        }
        diff = (long)upper - (long)nums[n-1];
        if (diff == 1)
            ranges.add(String.valueOf(upper));
        if (diff>1)
            ranges.add(String.valueOf(nums[n-1]+1)+"->"+String.valueOf(upper));
        return ranges;
    }
}
