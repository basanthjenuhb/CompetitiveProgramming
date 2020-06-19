import java.util.Arrays;
import java.util.Scanner;

/**
 * @author bjenuhb
 */

public class CoinCombinationsII {

    static int[][] dp;

    static int totalCombinationsDp(int[] coins, int sum) {
        int[] dp = new int[sum + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int j = 1; j <= sum; j++) {
                if (j - coin >= 0) {
                    dp[j] = (dp[j] + dp[j - coin]) % 1000000007;
                }
            }
        }
        return dp[sum];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int totalCoins = scanner.nextInt(), totalSum = scanner.nextInt();
        int[] coins = new int[totalCoins];
        for (int i = 0; i < totalCoins; i++) {
            coins[i] = scanner.nextInt();
        }
        dp = new int[totalCoins + 1][totalSum + 1];
        for (int[] array: dp) {
            Arrays.fill(array, -1);
        }
        System.out.println(totalCombinationsDp(coins, totalSum));
    }

}
