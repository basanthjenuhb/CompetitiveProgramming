/**
 * @author bjenuhb
 */

public class P198 {

    private Integer[] dp;

    private int robRecursive(int[] nums, int currentPosition) {
        if (currentPosition > nums.length - 1) {
            return 0;
        }
        if (dp[currentPosition] != null) {
            return dp[currentPosition];
        }
        return dp[currentPosition] = Math.max(
            nums[currentPosition] + robRecursive(nums, currentPosition + 2),
               robRecursive(nums, currentPosition + 1)
            );
    }

    public int rob(int[] nums) {
        dp = new Integer[nums.length];
        return robRecursive(nums, 0);
    }

}
