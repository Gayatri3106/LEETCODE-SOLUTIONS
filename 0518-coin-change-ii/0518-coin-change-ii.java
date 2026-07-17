class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n + 1][amount + 1];

        for (int i = 0; i <= n; i++){
            dp[i][0] = 1;
        }

        for (int i=1; i<=n; i++){
            int c = coins[i-1];
            for(int j=1; j<=amount; j++){
                int exc = dp[i-1][j];
                int inc=0;
                if(c<=j){
                    inc = dp[i][j-c];
                }
                dp[i][j] = exc + inc;
            }
        }
        return dp[n][amount];
    }
}
