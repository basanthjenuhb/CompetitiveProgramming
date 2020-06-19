/**
 * @author bjenuhb
 */

public class CountSubsets {

    public static int countSubsets(int[] array, int sum, int n) {
        if (sum == 0) {
            return 1;
        }
        if (n < 0 || sum < 0) {
            return 0;
        }
        return countSubsets(array, sum, n - 1) + countSubsets(array, sum - array[n], n - 1);
    }

    public static void main(String[] args) {
        int[] array = new int[]{2, 4, 3, 3, 5, 1, 7};
        int sum = 6;
        System.out.println(countSubsets(array, sum, array.length - 1));
    }

}
