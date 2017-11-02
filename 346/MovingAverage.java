import java.util.LinkedList;
import java.util.Queue;

class MovingAverage {

    public int n, s;
    public Queue q = new LinkedList<Integer>();

    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        n = size;
        s = 0;
    }
    
    public double next(int val) {
        q.add(val);
        s += val;
        if (q.size()>n)
            s -= (int)q.remove();
        return 1.0*s/q.size();
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */