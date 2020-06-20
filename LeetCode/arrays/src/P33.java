/**
 * @author bjenuhb
 */

public class P33 {

    public int findPivot(int[] nums) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int next = (mid + 1) % nums.length;
            int previous = (mid + nums.length - 1) % nums.length;

            if (nums[mid] < nums[previous]) {
                return mid;
            }
            if (nums[next] < nums[mid]) {
                return next;
            }
            if (nums[low] <= nums[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
       }
       return 0;
    }

    public int binarySearch(int[] nums, int target, int low, int high) {
        if (high == -1) {
            return -1;
        }
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public int search(int[] nums, int target) {
        int k = findPivot(nums);
        return Math.max(
            binarySearch(nums, target, 0, k - 1),
            binarySearch(nums, target, k, nums.length - 1));
    }

    public static void main(String[] args) {
        System.out.println(new P33().search(new int[]{4,5,6,7,0,1,2}, 0));
    }

}