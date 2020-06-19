import java.util.HashMap;
import java.util.Map;

/**
 * @author bjenuhb
 */

public class P1 {

    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> positions = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            positions.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {

            int requiredResult = target - nums[i];
            Integer indexOfResult = positions.get(requiredResult);
            if (indexOfResult == null || indexOfResult == i) {
                continue;
            }
            result[0] = i;
            result[1] = indexOfResult;
        }
        return result;
    }

}
