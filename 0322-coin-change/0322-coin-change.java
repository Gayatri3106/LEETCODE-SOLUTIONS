class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n + 1][amount + 1];
        int temp = amount + 1;

        for (int j = 1; j <= amount; j++) {
            dp[0][j] = temp;
        }
        for (int i = 1; i <= n; i++) {
            dp[i][0] = 0;
        }
        for (int i = 1; i <= n; i++) {
            int c = coins[i - 1];
            for (int j = 1; j <= amount; j++) {
                int exc = dp[i - 1][j];
                int inc = temp;
                if (c <= j) {
                    inc = 1 + dp[i][j - c];
                }

                dp[i][j] = Math.min(exc, inc);
            }
        }
        if(dp[n][amount] == temp){
            return -1;
        }
        return dp[n][amount];
    }
}