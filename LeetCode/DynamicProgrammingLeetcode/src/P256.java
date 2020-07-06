/**
 * @author bjenuhb
 */

public class P256 {

    private Integer[][] dp;

    private int minCostRecursive(int[][] costs, int currentPosition, int currentColour) {
        if (currentPosition > costs.length - 1) {
            return 0;
        }
        if (currentColour >= 0 && dp[currentPosition][currentColour] != null) {
            return dp[currentPosition][currentColour];
        }
        int cost = Integer.MAX_VALUE;
        for (int i = 0; i < costs[currentPosition].length; i++) {
            if (i != currentColour) {
                cost = Math.min(cost, minCostRecursive(costs, currentPosition + 1, i) + costs[currentPosition][i]);
            }
        }
        if (currentColour != -1) {
            dp[currentPosition][currentColour] = cost;
        }
        return cost;
    }

    public int minCost(int[][] costs) {
        dp = new Integer[costs.length][costs[0].length];
        return minCostRecursive(costs, 0, -1);
    }

}
