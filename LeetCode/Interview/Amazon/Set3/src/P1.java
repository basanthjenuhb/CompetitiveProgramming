/**
 * @author bjenuhb
 */

public class P1 {

    public int dietPlanPerformance(int[] calories, int k, int lower, int upper) {
        int[] cumulative = new int[calories.length];
        for (int i = 0; i < cumulative.length; i++) {
            cumulative[i] = calories[i];
            if (i > 0) {
                cumulative[i] = cumulative[i] + cumulative[i - 1];
            }
        }


        int points = 0;
        for (int i = k - 1; i < calories.length; i++) {
            int right = cumulative[i];
            int left = 0;
            if (i - k >= 0) {
                left = cumulative[i - k];
            }
            int sum = right - left;
            if (sum > upper) {
                points++;
            } else if (sum < lower) {
                points--;
            }
        }
        return points;
    }

}
