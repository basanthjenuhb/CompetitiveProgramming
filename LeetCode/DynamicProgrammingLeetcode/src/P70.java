import java.util.Arrays;

/**
 * @author bjenuhb
 */

public class P70 {

    int[] dp;

    public int climbStairsRecursive(int totalSteps, int currentStep) {
        if (currentStep == totalSteps) {
            return 1;
        }
        if (currentStep > totalSteps) {
            return 0;
        }
        if (dp[currentStep] != -1) {
            return dp[currentStep];
        }
        return dp[currentStep] = climbStairsRecursive(totalSteps, currentStep + 1)
            + climbStairsRecursive(totalSteps, currentStep + 2);
    }

    public int climbStairs(int n) {
        dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return climbStairsRecursive(n, 0);
    }

}
