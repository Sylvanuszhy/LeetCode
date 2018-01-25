import java.util.Stack;

class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] res = new int[n];
        Stack<Integer> stack = new Stack<Integer>();
        String[] last = logs.get(0).split(":");
        assert(last[1].equals("start"));
        stack.push(Integer.valueOf(last[0]));
        for (int i = 1; i<logs.size(); i++) {
            String[] cur = logs.get(i).split(":");
            int t = Integer.valueOf(cur[2])-Integer.valueOf(last[2]);
            if (last[1].equals("start") && cur[1].equals("start")) {
                int fid = Integer.valueOf(last[0]);
                res[fid] += t;
                stack.push(Integer.valueOf(cur[0]));
            }
            if (last[1].equals("end") && cur[1].equals("end")) {
                int fid = Integer.valueOf(cur[0]);
                res[fid] += t;
                assert(stack.pop() == fid);
            }
            if (last[1].equals("start") && cur[1].equals("end")) {
                int fid = Integer.valueOf(cur[0]);
                assert(stack.pop() == fid);
                res[fid] += t+1;
            }
            if (last[1].equals("end") && cur[1].equals("start")) {
                if (!stack.isEmpty()) {
                    int fid = stack.peek();
                    res[fid] += t-1;
                }
                stack.push(Integer.valueOf(cur[0]));
            }
            last = cur;
        }
        return res;
    }
}
