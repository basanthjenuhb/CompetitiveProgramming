import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author bjenuhb
 */

public class P268 {
    public int missingNumber(int[] nums) {
        Set<Integer> numberSets = new HashSet<>();
        for (int num: nums) {
            numberSets.add(num);
        }
        for (int i = 0; i <= nums.length; i++) {
            if (!numberSets.contains(i)) {
                return i;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int i = new P268().missingNumber(new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1});
        System.out.println("i = " + i);
    }
}
