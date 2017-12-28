import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
}

class Solution {
    public int minMeetingRooms(Interval[] intervals) {
        Comparator comp = new Comparator<Interval>() {
            public int compare(Interval a, Interval b) {
                return a.start-b.start;
            }
        };
        Arrays.sort(intervals, comp);
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>();
        int num = 0;
        for (Interval interval : intervals) {
            if (!heap.isEmpty() && interval.start>=heap.peek())
                heap.remove();
            heap.add(interval.end);
            num = Math.max(num, heap.size());
        }
        return num;
    }
}
