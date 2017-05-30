#include <iostream>
#include <vector>
using namespace std;

struct Interval {
    int start;
    int end;
    Interval() : start(0), end(0) {}
    Interval(int s, int e) : start(s), end(e) {}
};

bool cmp(Interval a, Interval b) {
    return a.start<b.start;
}

class Solution {
public:
    vector<Interval> merge(vector<Interval>& intervals) {
        sort(intervals.begin(), intervals.end(), cmp);
        vector<Interval> res;
        vector<Interval>::iterator itor = intervals.begin();
        if (itor == intervals.end())
            return res;
        int left = itor->start, right = itor->end;
        for (itor++; itor != intervals.end(); itor++) {
            if (itor->start > right) {
                res.push_back(Interval(left, right));
                left = itor->start;
                right = itor->end;
            } else {
                if (itor->end > right)
                    right = itor->end;
            }
        }
        res.push_back(Interval(left, right));
        return res;
    }
};

int main() {
    Solution solu;
    vector<Interval> intervals = {Interval(1, 3)};
    vector<Interval> res = solu.merge(intervals);
}