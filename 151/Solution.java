public class Solution {
    public static String reverseWords(String s) {
        String[] words = s.trim().split("\\s+");
        String res = "";
        for (String word : words) {
            res = " "+word+res;
        }
        if (res.length()==0)
            return res;
        else
            return res.substring(1);
    }

    public static void main(String[] args) {
        String res = reverseWords("  1");
        System.out.println(res);
    }
}
