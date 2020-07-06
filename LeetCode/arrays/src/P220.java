import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * @author bjenuhb
 */

public class P220 {

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Long> treeSet = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            Long floor = treeSet.floor((long) nums[i]);
            if (floor != null && Math.abs(nums[i] - floor) <= t) {
                return true;
            }

            Long ceiling = treeSet.ceiling((long) nums[i]);
            if (ceiling != null && Math.abs((long) nums[i] - (long)ceiling) <= t) {
                return true;
            }

            treeSet.add((long)nums[i]);

            if (treeSet.size() > k) {
                treeSet.remove((long)nums[i - k]);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        new P220().containsNearbyAlmostDuplicate(new int[]{-1, Integer.MAX_VALUE}, 1, Integer.MAX_VALUE);
    }

}
