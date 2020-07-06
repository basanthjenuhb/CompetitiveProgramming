/**
 * @author bjenuhb
 */

public class P238 {

    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];

        left[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            left[i] = nums[i] * left[i - 1];
        }

        right[nums.length - 1] = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            right[i] = nums[i] * right[i + 1];
        }

        for (int i = 0; i < nums.length; i++) {
            int leftProduct = 1;
            int rightProduct = 1;

            if (i - 1 >= 0) {
                leftProduct = left[i - 1];
            }

            if (i < nums.length - 1) {
                rightProduct = right[i + 1];
            }

            result[i] = leftProduct * rightProduct;
        }

        return result;
    }

}
