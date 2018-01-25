class Solution {
    public int maximumSwap(int num) {
        int[] map = new int[10];
        int[] digit = new int[9];
        int k = 0;
        Arrays.fill(map, -1);
        while (num>0) {
            digit[k] = num%10;
            if (map[digit[k]] == -1)
                map[digit[k]] = k;
            num /= 10;
            k++;
        }
        int d = 9, i = k-1;
        while (d>0) {
            while (d>0 && map[d] == -1)
                d--;
            while (i>=0 && digit[i]>=d)
                i--;
            if (i>map[d]) {
                digit[map[d]] = digit[i];
                digit[i] = d;
                break;
            }
            d--;
        }
        int res = 0;
        for (i = k-1; i>=0; i--)
            res = res*10+digit[i];
        return res;
    }
}
