import java.util.Scanner;

/**
 * @author bjenuhb
 */

public class DiceCombinations {

    public static long MOD = 1000000007;

    public static long countDP(long n) {
        long[] dp = new long[new Long(n).intValue() + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            dp[i] = 0;
            for (int j = 1; j <= 6; j++) {
                if (i - j >= 0) {
                    dp[i] = (dp[i] % MOD + dp[i - j] % MOD) % MOD;
                }
            }
        }
        return dp[new Long(n).intValue()];
    }

    public static void main(String[] args) {
        int n = new Scanner(System.in).nextInt();
        System.out.println(countDP(n));
    }

}
