import java.util.Arrays;

/**
 * @author bjenuhb
 */

public class P746 {

    int[] dp;

    public int minCostRecursive(int[] cost, int currentStep) {
        if (currentStep >= cost.length) {
            return 0;
        }
        if (dp[currentStep] != -1) {
            return dp[currentStep];
        }
        return dp[currentStep] = cost[currentStep] + Math.min(minCostRecursive(cost, currentStep + 1), minCostRecursive(cost,
            currentStep + 2));
    }

    public int minCostClimbingStairs(int[] cost) {
        dp = new int[cost.length + 1];
        Arrays.fill(dp, -1);
        return Math.min(minCostRecursive(cost, 0), minCostRecursive(cost, 1));
    }

    public static void main(String[] args) {
        int[] steps = new int[]{10, 15, 20};
        System.out.println(new P746().minCostClimbingStairs(steps));
    }
}
