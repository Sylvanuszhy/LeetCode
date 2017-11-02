import java.util.HashMap;

class ValidWordAbbr {

    HashMap<String, String> map;

    public ValidWordAbbr(String[] dictionary) {
        map = new HashMap<String, String>();
        for (int i = 0; i<dictionary.length; i++)
            if (dictionary[i].length()>2) {
                int n = dictionary[i].length();
                char st = dictionary[i].charAt(0);
                char ed = dictionary[i].charAt(n-1);
                String key = String.valueOf(st)+String.valueOf(n-2)+String.valueOf(ed);
                if (map.containsKey(key))
                    map.put(key, "0");
                else
                    map.put(key, dictionary[i]);
            }
    }
    
    public boolean isUnique(String word) {
        if (word.length()<=2)
            return true;
        int n = word.length();
        char st = word.charAt(0);
        char ed = word.charAt(n-1);
        String s = String.valueOf(st)+String.valueOf(n-2)+String.valueOf(ed);
        if (map.containsKey(s)) {
            String value = (String)map.get(s);
            if (value == "0" || !value.equals(word))
                return false;
            else
                return true;
        } else {
            return true;
        }
    }
}

/**
 * Your ValidWordAbbr object will be instantiated and called as such:
 * ValidWordAbbr obj = new ValidWordAbbr(dictionary);
 * boolean param_1 = obj.isUnique(word);
 */