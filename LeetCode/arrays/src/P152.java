/**
 * @author bjenuhb
 */

public class P152 {

    public int maxProduct(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        int currentMax = nums[0];
        int currentMin = nums[0];
        int finalMax = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int temp = currentMax;
            currentMax = Math.max(Math.max(currentMax * nums[i], currentMin * nums[i]), nums[i]);
            currentMin = Math.min(Math.min(currentMin * nums[i], temp * nums[i]), nums[i]);
            finalMax = Math.max(finalMax, currentMax);
        }
        return finalMax;
    }

}
