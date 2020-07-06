/**
 * @author bjenuhb
 */

public class P1092 {

    public String shortestCommonSupersequence(String text1, String text2) {
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        int lcs = dp[text1.length()][text2.length()];

        int i = text1.length(), j = text2.length();
        StringBuilder result = new StringBuilder();
        while (i > 0 && j > 0) {
            if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                result.insert(0, text1.charAt(i - 1));
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                result.insert(0, text1.charAt(i - 1));
                i--;
            } else {
                result.insert(0, text2.charAt(j - 1));
                j--;
            }
        }
        while (i > 0) {
            result.insert(0, text1.charAt(i - 1));
            i--;
        }
        while (j > 0) {
            result.insert(0, text2.charAt(j - 1));
            j--;
        }
        return result.toString();
    }

    public static void main(String[] args) {
        new P1092().shortestCommonSupersequence("abac", "cab");
    }

}
