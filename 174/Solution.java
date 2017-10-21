class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length, n = dungeon[0].length;
        int[][] hp = new int[m][n];
        hp[m-1][n-1] = Math.max(-dungeon[m-1][n-1]+1, 1);
        for (int j = n-2; j>=0; j--) {
            hp[m-1][j] = Math.max(-dungeon[m-1][j]+hp[m-1][j+1], 1);
        }
        for (int i = m-2; i>=0; i--) {
            hp[i][n-1] = Math.max(-dungeon[i][n-1]+hp[i+1][n-1], 1);
            for (int j = n-2; j>=0; j--) {
                if (hp[i][j+1]>hp[i+1][j])
                    hp[i][j] = Math.max(-dungeon[i][j]+hp[i+1][j], 1);
                else
                    hp[i][j] = Math.max(-dungeon[i][j]+hp[i][j+1], 1);
            }
        }
        return hp[0][0];
    }
}

