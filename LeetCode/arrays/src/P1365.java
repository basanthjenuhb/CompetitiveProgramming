/**
 * @author bjenuhb
 */

public class P1365 {

    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int numberOfMin = 0;
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] < nums[i]) {
                    numberOfMin++;
                }
            }
            result[i] = numberOfMin;
        }
        return result;
    }
}
