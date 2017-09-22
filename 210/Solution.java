import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        ArrayList[] adjacency = new ArrayList[numCourses];
        Arrays.fill(inDegree, 0);
        for (int i = 0; i<numCourses; i++)
            adjacency[i] =  new ArrayList<Integer>();
        int edge = prerequisites.length;
        for (int i = 0; i<edge; i++) {
            int ed = prerequisites[i][0], st = prerequisites[i][1];
            inDegree[ed] += 1;
            adjacency[st].add(ed);
        }

        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i<numCourses; i++)
            if (inDegree[i] == 0)
                queue.add(i);

        int k = 0;
        int[] order = new int[numCourses];
        while (!queue.isEmpty()) {
            int node = queue.remove();
            for (int i = 0; i<adjacency[node].size(); i++) {
                int ed = (int)adjacency[node].get(i);
                inDegree[ed] -= 1;
                edge--;
                if (inDegree[ed] == 0)
                    queue.add(ed);
            }
            order[k++] = node;
        }
        if (edge>0)
            return new int[0];
        else
            return order;
    }
}
