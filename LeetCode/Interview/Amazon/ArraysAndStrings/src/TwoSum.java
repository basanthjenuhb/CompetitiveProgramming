import java.util.HashMap;
import java.util.Map;

/**
 * @author bjenuhb
 */

public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int number = nums[i];
            int rest = target - number;
            if (map.get(rest) != null && map.get(rest) != i) {
                result[0] = i;
                result[1] = map.get(i);
            }
        }
        return result;
    }
}
