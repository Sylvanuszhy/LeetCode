import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0)+1);
        }
        PriorityQueue<String> heap = new PriorityQueue<String>(new Comparator<String>() {
            public int compare(String s1, String s2) {
                if (map.get(s1) != map.get(s2))
                    return map.get(s1)-map.get(s2);
                else
                    return -s1.compareTo(s2);
            }
        });
        for (String word : map.keySet()) {
            heap.add(word);
            if (heap.size()>k)
                heap.poll();
        }
        ArrayList<String> res = new ArrayList<String>();
        while (!heap.isEmpty()) {
            res.add(heap.poll());
        }
        Collections.reverse(res);
        return res;
    }
}
