/**
 * @author bjenuhb
 */

public class P152 {

    public int maxProduct(int[] nums) {
        int result = 1;
        int maxResult = nums[0];
        for (int i = 0; i < nums.length; i++) {
            result = result * nums[i];
            maxResult = Math.max(result, maxResult);
            if (result < 0) {
                result = 1;
            }
        }
        return result;
    }

}
