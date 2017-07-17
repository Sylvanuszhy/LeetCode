class Solution {
public:
    int canCompleteCircuit(vector<int>& gas, vector<int>& cost) {
        int n = gas.size();
        vector<int> s(n*2);
        int i, pos = -1, low = 0;
        for (i = 0; i<n*2; i++) {
            if (i == 0)
                s[i] = gas[0]-cost[0];
            else
                s[i] = s[i-1]+(gas[i%n]-cost[i%n]);
            if (s[i]<low) {
                low = s[i];
                pos = i;
            }
            if (i-pos>=n)
                break;
        }
        if (i<n*2)
            return pos+1;
        else
            return -1;
    }
};
