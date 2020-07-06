/**
 * @author bjenuhb
 */

public class P153 {

    public int findMin(int[] nums) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int previous = (mid + nums.length - 1) % nums.length;

            if (low == high || low + 1 == high) {
                return Math.min(nums[low], nums[high]);
            }

            if (nums[mid] < nums[previous]) {
                return nums[mid];
            }

            if (nums[mid] > nums[high]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

}
