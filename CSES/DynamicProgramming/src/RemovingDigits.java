import java.util.Arrays;
import java.util.Scanner;

/**
 * @author bjenuhb
 */

public class RemovingDigits {

    static int[] dp;

    static int countDigits(int n, int depth) {
        if (n < 10) {
            return depth + 1;
        }
        if (dp[n] != -1) {
            return dp[n];
        }
        int sum = Integer.MAX_VALUE;
        int nCopy = n;
        while (nCopy != 0) {
            int digit = nCopy % 10;
            if (digit != 0) {
                sum = Math.min(countDigits(n - digit, depth + 1), sum);
            }
            nCopy = nCopy / 10;
        }
        return dp[n] = sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        dp = new int[n + 1];
        Arrays.fill(dp, -1);
        System.out.println(countDigits(n, 0));
    }

}
