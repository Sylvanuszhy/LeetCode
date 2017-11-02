import java.util.ArrayList;

class Solution {
    public List<String> findStrobogrammatic(int n) {
        ArrayList res = new ArrayList<String>();
        if (n == 0) {
            res.add("");
        } else if (n == 1) {
            res.add("0");
            res.add("1");
            res.add("8");
        } else {
            List tmp = strobogrammatic(n-2);
            for (int i = 0; i<tmp.size(); i++) {
                res.add("1"+(String)tmp.get(i)+"1");
                res.add("8"+(String)tmp.get(i)+"8");
                res.add("6"+(String)tmp.get(i)+"9");
                res.add("9"+(String)tmp.get(i)+"6");
            }
        }
        return res;
    }

    public List<String> strobogrammatic(int k) {
        ArrayList res = new ArrayList<String>();
        if (k == 0) {
            res.add("");
        } else if (k == 1) {
            res.add("0");
            res.add("1");
            res.add("8");
        } else {
            List tmp = strobogrammatic(k-2);
            for (int i = 0; i<tmp.size(); i++) {
                res.add("0"+(String)tmp.get(i)+"0");
                res.add("1"+(String)tmp.get(i)+"1");
                res.add("8"+(String)tmp.get(i)+"8");
                res.add("6"+(String)tmp.get(i)+"9");
                res.add("9"+(String)tmp.get(i)+"6");
            }
        }
        return res;
    }
}
