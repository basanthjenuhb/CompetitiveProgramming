import java.util.Arrays;

/**
 * @author bjenuhb
 */

public class P416 {

    Boolean[][] dp;

    public boolean canPartitionRecursive(int[] nums, int currentIndex, int sum) {
        if (sum == 0) {
            return true;
        }
        if (sum < 0 || currentIndex < 0) {
            return false;
        }
        if (dp[currentIndex][sum] != null) {
            return dp[currentIndex][sum];
        }
        return dp[currentIndex][sum] =
            canPartitionRecursive(nums, currentIndex - 1, sum - nums[currentIndex])
            || canPartitionRecursive(nums, currentIndex - 1, sum);
    }

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num: nums) {
            sum += num;
        }
        if (sum % 2 != 0) {
            return false;
        }
        dp = new Boolean[nums.length + 1][sum/2 + 1];
        for (Boolean[] array: dp) {
            Arrays.fill(array, null);
        }
        return canPartitionRecursive(nums, nums.length - 1, sum / 2);
    }

}
