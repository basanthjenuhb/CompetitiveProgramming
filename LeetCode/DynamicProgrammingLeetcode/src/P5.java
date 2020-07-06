/**
 * @author bjenuhb
 */

public class P5 {

    private String resultString = "";
    private int maxLength = Integer.MIN_VALUE;
    Boolean[][] dp;

    public boolean lpsR(String text, int leftIndex, int rightIndex) {

        boolean result = false;
        if (Math.min(leftIndex, rightIndex) < 0
            || Math.max(leftIndex, rightIndex) >= text.length()
            || leftIndex > rightIndex) {
            return false;
        }

        if (dp[leftIndex][rightIndex] != null) {
            return dp[leftIndex][rightIndex];
        }

        if (leftIndex == rightIndex) {
            result = true;
        } else if (text.charAt(leftIndex) == text.charAt(rightIndex)) {
            if (leftIndex + 1 == rightIndex) {
                result = true;
            } else {
                result = lpsR(text, leftIndex + 1, rightIndex - 1);
            }
        }
        if (result) {
            int currentLength = rightIndex - leftIndex + 1;
            if (currentLength > maxLength) {
                maxLength = currentLength;
                resultString = text.substring(leftIndex, rightIndex + 1);
            }
        } else {
            lpsR(text, leftIndex + 1, rightIndex);
            lpsR(text, leftIndex, rightIndex - 1);
        }
        return dp[leftIndex][rightIndex] = result;
    }

    public String longestPalindrome(String s) {
        dp = new Boolean[s.length()][s.length()];
        lpsR(s, 0, s.length() - 1);
        return resultString;
    }

    public static void main(String[] args) {
        System.out.println(new P5().longestPalindrome("babad"));
    }

}
