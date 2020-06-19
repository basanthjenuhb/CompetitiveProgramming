/**
 * @author bjenuhb
 */

public class P1180 {

    public int countLetters(String S) {
        int count = 0;
        int i = 0, j = 0;
        while (i < S.length()) {
            if (i + 1 < S.length() && S.charAt(i) == S.charAt(i + 1)) {
                i++;
            } else {
                int distinct = i - j + 1;
                count += distinct * (distinct + 1) / 2;
                i++;
                j = i;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        new P1180().countLetters("aaaba");
    }

}
