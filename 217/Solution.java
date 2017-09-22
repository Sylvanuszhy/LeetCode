import java.util.HashSet;

class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet set = new HashSet<Integer>();
        for (int num : nums) {
            if (set.contains(num))
                return true;
            else
                set.add(num);
        }
        return false;
    }
}
