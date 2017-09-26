import java.util.Arrays;

class Solution {
    public static int candy(int[] ratings) {
        int n = ratings.length;
        int[] give = new int[n];
        Arrays.fill(give, 1);
        for (int i = 1; i<n; i++)
            if (ratings[i-1]<ratings[i])
                give[i] = give[i-1]+1;
        for (int i = n-2; i>=0; i--)
            if (ratings[i]>ratings[i+1])
                give[i] = give[i+1]+1;
        for (int i = 1; i<n-1; i++)
            if (ratings[i-1]<ratings[i] && ratings[i]>ratings[i+1])
                give[i] = Math.max(give[i-1], give[i+1])+1;
        int s = 0;
        for (int i = 0; i<n; i++)
            s += give[i];
        return s;
    }

    public static void main(String[] args) {
        int[] ratings = {4,2,3,4,1};
        int res = candy(ratings);
        System.out.println(res);
    }
}
