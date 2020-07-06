import java.util.HashMap;
import java.util.Map;

/**
 * @author bjenuhb
 */

public class P219 {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.get(nums[i]) != null && i - map.get(nums[i]) <= k) {
                return true;
            }
            map.put(nums[i], i);
        }
        return false;
    }

    public static void main(String[] args) {
        new P219().containsNearbyDuplicate(new int[]{1,2,3,1,2,3}, 2);
    }

}
