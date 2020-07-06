/**
 * @author bjenuhb
 */

public class P213 {

    private Integer[] dp;

    private int robRecursive(int[] nums, int currentPosition, int finalPosition) {
        if (currentPosition > finalPosition) {
            return 0;
        }
        if (dp[currentPosition] != null) {
            return dp[currentPosition];
        }
        return dp[currentPosition] = Math.max(
            nums[currentPosition] + robRecursive(nums, currentPosition + 2, finalPosition),
            robRecursive(nums, currentPosition + 1, finalPosition)
        );
    }

    public int rob(int[] nums) {
        dp = new Integer[nums.length];
        int num1 = robRecursive(nums, 0, nums.length - 2);
        dp = new Integer[nums.length];
        int num2 = robRecursive(nums, 1, nums.length - 1);
        return Math.max(num1, num2);
    }

}
