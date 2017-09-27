import java.util.ArrayList;
import java.util.List;

public class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
}

class Solution {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        int n = intervals.size();
        int i;
        for (i = 0; i<n; i++) {
            Interval interval = (Interval)intervals.get(i);
            if (interval.start>=newInterval.start)
                break;
        }
        int j;
        for (j = n-1; j>=0; j--) {
            Interval interval = (Interval)intervals.get(j);
            if (newInterval.end>=interval.end)
                break;
        }
        List res = new ArrayList<Interval>();
        for (int k = 0; k<i-1; k++) {
            Interval interval = (Interval)intervals.get(k);
            res.add(interval);
        }
        Interval last = i>0 ? (Interval)intervals.get(i-1) : new Interval(newInterval.start-1, newInterval.start-1);
        Interval next = j<n-1 ? (Interval)intervals.get(j+1) : new Interval(newInterval.end+1, newInterval.end+1);
        if (last.end<newInterval.start && newInterval.end<next.start) {
            if (i>0)
                res.add(last);
            res.add(newInterval);
            if (j<n-1)
                res.add(next);
        }
        if (last.end<newInterval.start && newInterval.end>=next.start) {
            if (i>0)
                res.add(last);
            Interval interval = new Interval(newInterval.start, next.end);
            res.add(interval);
        }
        if (last.end>=newInterval.start && newInterval.end<next.start) {
            Interval interval = new Interval(last.start, newInterval.end);
            res.add(interval);
            if (j<n-1)
                res.add(next);
        }
        if (last.end>=newInterval.start && newInterval.end>=next.start) {
            Interval interval = new Interval(last.start, next.end);
            res.add(interval);
        }
        for (int k = j+2; k<n; k++) {
            Interval interval = (Interval)intervals.get(k);
            res.add(interval);
        }
        return res;
    }
}
