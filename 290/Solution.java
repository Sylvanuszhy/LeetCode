class Solution {
    public boolean wordPattern(String pattern, String str) {
        String[] strs = str.split(" ");
        if (strs.length != pattern.length())
            return false;
        HashMap<Object, Integer> map = new HashMap<Object, Integer>();
        for (int i = 0; i<pattern.length(); i++) {
            Character c = pattern.charAt(i);
            if (!Objects.equals(map.put(c, i), map.put(strs[i], i)))
                return false;
        }
        return true;
    }
}
