# CompetitiveProgramming
CompetitiveProgramming

### Coin change

```
// Minimum number of coins to generate amount
// 2d Array
class Solution {
    public int coinChange(int[] coins, int amount) {
        int[][] dp = new int[coins.length + 1][amount + 1];
        Arrays.sort(coins);
        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = Integer.MAX_VALUE;
        }
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 0;
        }
        for (int coin = 1; coin < dp.length; coin++) {
            for (int sum = 1; sum < dp[coin].length; sum++) {
                dp[coin][sum] = Integer.MAX_VALUE;
                if (sum < coins[coin - 1]) {
                    dp[coin][sum] = Math.min(Integer.MAX_VALUE, dp[coin - 1][sum]);
                } else if (sum == coins[coin - 1]) {
                    dp[coin][sum] = 1;
                } else if (sum > coins[coin - 1]) {
                    if (dp[coin][sum - coins[coin - 1]] != Integer.MAX_VALUE) {
                        dp[coin][sum] = 1 + dp[coin][sum - coins[coin - 1]];
                    }
                    dp[coin][sum] = Math.min(dp[coin][sum], dp[coin - 1][sum]);
                }
            }
        }
        if (dp[coins.length][amount] == Integer.MAX_VALUE) {
            return -1;
        }
        return dp[coins.length][amount];
    }
}

// 1d array
class Solution {
    public int coinChange(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[max];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
```

```
// Number of ways to generate change 2d array
class Solution {    
    public int change(int amount, int[] coins) {
        if (coins.length == 0 && amount == 0){
            return 1;
        }
        int[][] dp = new int[coins.length + 1][amount + 1];
        for (int i = 1; i < dp.length; i++) {
            dp[i][0] = 1;
            for (int j = 1; j < dp[0].length; j++) {
                if (j >= coins[i - 1]) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[coins.length][amount];
    }
}

// 1 d array
class Solution {
  public int change(int amount, int[] coins) {
    int[] dp = new int[amount + 1];
    dp[0] = 1;

    for (int coin : coins) {
      for (int x = coin; x < amount + 1; ++x) {
        dp[x] += dp[x - coin];
      }
    }
    return dp[amount];
  }
}
```
