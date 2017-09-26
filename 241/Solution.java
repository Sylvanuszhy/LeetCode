import java.util.ArrayList;
import java.util.List;

class Solution {

    public ArrayList<Integer> nums;
    public ArrayList<Character> ops;

    public List<Integer> diffWaysToCompute(String input) {
        nums = new ArrayList<Integer>();
        ops = new ArrayList<Character>();
        int num = 0;
        for (int i = 0; i<=input.length(); i++) {
            char c = i<input.length() ? input.charAt(i) : '#';
            if (Character.isDigit(c)) {
                num = num*10+(c-'0');
            } else {
                nums.add(num);
                num = 0;
                ops.add(c);
            }
        }
        return calculate(0, ops.size()-2);
    }

    public List<Integer> calculate(int st, int ed) {
        List<Integer> res = new ArrayList<Integer>();
        if (st>ed) {
            res.add((Integer)nums.get(st));
        } else {
            for (int k = st; k<=ed; k++) {
                List<Integer> leftRes = calculate(st, k-1);
                List<Integer> rightRes = calculate(k+1, ed);
                res.addAll(compute(leftRes, rightRes, (char)ops.get(k)));
            }
        }
        return res;
    }

    public List<Integer> compute(List<Integer> leftRes, List<Integer> rightRes, char op) {
        List<Integer> res = new ArrayList<Integer>();
        for (int i = 0; i<leftRes.size(); i++)
            for (int j = 0; j<rightRes.size(); j++) {
                int left = leftRes.get(i);
                int right = rightRes.get(j);
                switch (op) {
                    case '+': res.add(left+right); break;
                    case '-': res.add(left-right); break;
                    case '*': res.add(left*right); break;
                }
            }
        return res;
    }
}
