import java.util.Arrays;
import java.util.Comparator;

public class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
}

class Solution {
    public boolean canAttendMeetings(Interval[] intervals) {
        Comparator comp = new Comparator<Interval>() {
            public int compare(Interval a, Interval b) {
                return a.start-b.start;
            }
        };
        Arrays.sort(intervals, comp);
        for (int i = 1; i<intervals.length; i++) {
            Interval a = intervals[i-1];
            Interval b = intervals[i];
            if (a.end>b.start)
                return false;
        }
        return true;
    }
}
