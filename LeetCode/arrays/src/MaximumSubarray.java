/**
 * @author bjenuhb
 */

public class MaximumSubarray {

    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int sumTillNow = 0;
        for (int num: nums) {
            sumTillNow += num;
            max = Math.max(sumTillNow, max);
            if (sumTillNow < 0) {
                sumTillNow = 0;
            }
        }
        return max;
    }

}
