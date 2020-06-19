/**
 * @author bjenuhb
 */

public class P1351 {

    public int countNegatives(int[][] grid) {
        int count = 0;
        for (int[] array: grid) {
            for (int i = array.length - 1; i >= 0; i--) {
                if (array[i] < 0) {
                    count++;
                } else {
                    break;
                }
            }
        }
        return count;
    }

}
