/**
 * @author bjenuhb
 */

public class P2 {

    public int[][] generateMatrix(int n) {

        int[][] result = new int[n][n];


        int left = 0, right = n - 1, high = 0, low = n - 1;

        int num = 1;
        while (left <= right) {

            for (int i = left; i <= right; i++) {
                result[high][i] = num;
                num++;
            }

            for (int i = high + 1; i <= low; i++) {
                result[i][right] = num;
                num++;
            }

            for (int i = right - 1; i >= left; i--) {
                result[low][i] = num;
                num++;
            }

            for (int i = low - 1; i >= high + 1; i--) {
                result[i][left] = num;
                num++;
            }

            left++;
            right--;
            high++;
            low--;

        }


        return result;
    }

    public static void main(String[] args) {
        new P2().generateMatrix(3);
    }

}
