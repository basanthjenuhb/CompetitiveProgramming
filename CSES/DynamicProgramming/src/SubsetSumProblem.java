/**
 * @author bjenuhb
 */

public class SubsetSumProblem {

    public static boolean doesSubsetExistDP(int[] array, int sum) {
        boolean[][] dp = new boolean[array.length + 1][sum + 1];

        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                if (j - array[i - 1] >= 0) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - array[i - 1]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        for (boolean[] booleans : dp) {
            for (boolean aBoolean : booleans) {
                System.out.print(String.valueOf(aBoolean).toUpperCase().charAt(0) + " ");
            }
            System.out.println();
        }
        return dp[array.length][sum];
    }

    public static boolean doesSubsetExist(int[] array, int sum, int n) {
        if (sum == 0) {
            return true;
        }
        if (n < 0 || sum < 0) {
            return false;
        }
        return doesSubsetExist(array, sum, n - 1) || doesSubsetExist(array, sum - array[n], n - 1);
    }

    public static void main(String[] args) {
        int[] array = new int[]{2, 3, 6, 8};
        int sum = 9;
        System.out.println(doesSubsetExistDP(array, sum));
    }
}
