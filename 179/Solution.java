import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public String largestNumber(int[] nums) {
        String[] strNums = new String[nums.length];
        for (int i = 0; i<nums.length; i++)
            strNums[i] = String.valueOf(nums[i]);

        Comparator<String> comp = new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                String s1s2 = s1+s2;
                String s2s1 = s2+s1;
                return s1s2.compareTo(s2s1);
            }
        };

        Arrays.sort(strNums, comp.reversed());

        StringBuilder s = new StringBuilder();
        for (String str : strNums)
            s.append(str);
        if (s.charAt(0) == '0')
            return "0";
        else
            return s.toString();
    }
}
