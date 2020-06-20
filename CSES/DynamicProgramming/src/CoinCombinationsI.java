import java.util.Scanner;

/**
 * @author bjenuhb
 */

public class CoinCombinationsI {

    public static long countDP(int[] coins, int x) {
        long[] dp = new long[x + 1];
        dp[0] = 1;
        for (int i = 1; i <= x; i++) {
            for (int coin : coins) {
                if (i - coin >= 0) {
                    dp[i] = (dp[i] + dp[i - coin]) % 1000000007;
                }
            }
        }
        return dp[x];
    }

    static int totalCombinations(int[] coins, int sum) {
        if (sum == 0) {
            return 1;
        }
        if (sum < 0) {
            return 0;
        }
        int result = 0;
        for (int i = 0; i < coins.length; i++) {
            result += totalCombinations(coins, sum - coins[i]);
        }
        return result;
    }

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int totalCoins = scanner.nextInt(), sum = scanner.nextInt();
        int[] coins = new int[totalCoins];
        for (int i = 0; i < totalCoins; i++) {
            coins[i] = scanner.nextInt();
        }
        System.out.println((countDP(coins, sum)));
    }

}
