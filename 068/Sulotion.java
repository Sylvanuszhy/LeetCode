import java.util.ArrayList;

class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        ArrayList<String> res = new ArrayList<String>();
        int i = 0;
        while (i<words.length) {
            int len = words[i].length(), j = i;
            while (j+1<words.length && len+1+words[j+1].length()<=maxWidth) {
                len += 1+words[j+1].length();
                j++;
            }
            if (j>i && j<words.length-1) {
                int b = (maxWidth-len)/(j-i);
                int extra = maxWidth-len-b*(j-i);
                StringBuilder s = new StringBuilder();
                String blanks = new String(new char[b+1]).replace('\0', ' ');
                for (int k = 0; k<extra; k++, i++) {
                    s.append(words[i]);
                    s.append(blanks);
                    s.append(' ');
                }
                for (; i<j; i++) {
                    s.append(words[i]);
                    s.append(blanks);
                }
                s.append(words[j]);
                res.add(s.toString());
            } else {
                StringBuilder t = new StringBuilder();
                for (; i<j; i++) {
                    t.append(words[i]);
                    t.append(' ');
                }
                t.append(words[j]);
                String s = "";
                if (maxWidth>0)
                    s = String.format("%-"+maxWidth+"s", t.toString());
                res.add(s);
            }
            i++;
        }
        return res;
    }
}
