import java.util.ArrayList;

public class ZigzagIterator {

    int k;
    List v;

    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        v = new ArrayList<Integer>();
        for (int i = 0; i<v1.size() || i<v2.size(); i++) {
            if (i<v1.size())
                v.add(v1.get(i));
            if (i<v2.size())
                v.add(v2.get(i));
        }
        k = 0;
    }

    public int next() {
        int val = (int)v.get(k);
        k++;
        return val;
    }

    public boolean hasNext() {
        return k<v.size();
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */