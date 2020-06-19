import java.util.Arrays;

/**
 * @author bjenuhb
 */

public class P509 {

    int[] dp;

    public int fibRecursive(int N) {
        if (N <= 1) {
            return N;
        }
        if (dp[N] != -1) {
            return dp[N];
        }
        return dp[N] = fib(N - 1) + fib(N - 2);
    }

    public int fib(int N) {
        dp = new int[N + 1];
        Arrays.fill(dp, -1);
        return fibRecursive(N);
    }

}
