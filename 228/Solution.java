import java.util.ArrayList;

class Solution {
    public List<String> summaryRanges(int[] nums) {
        List res = new ArrayList<String>();
        if (nums.length == 0)
            return res;
        int st = nums[0];
        for (int i = 1; i<nums.length; i++) {
            if (nums[i] != nums[i-1]+1) {
                if (nums[i-1] == st)
                    res.add(String.valueOf(st));
                else
                    res.add(String.valueOf(st)+"->"+String.valueOf(nums[i-1]));
                st = nums[i];
            }
        }
        if (nums[nums.length-1] == st)
            res.add(String.valueOf(st));
        else
            res.add(String.valueOf(st)+"->"+String.valueOf(nums[nums.length-1]));
        return res;
    }
}
