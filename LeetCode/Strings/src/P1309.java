import java.util.HashMap;
import java.util.Map;

/**
 * @author bjenuhb
 */

public class P1309 {

    public static Map<String, Character> map = new HashMap<>();

    static {
        for (int i = 1; i <= 9; i++) {
            char newChar = (char) ('a' + i - 1);
            map.put(String.valueOf(i), newChar);
        }
        for (int i = 10; i <= 26; i++) {
            char newChar = (char) ('a' + i - 1);
            map.put(String.valueOf(i) + "#", newChar);
        }
        System.out.println(map);
    }

    public String freqAlphabets(String s) {
        boolean x = false;
        boolean y = false;
        if (!x && !y) {

        }
        int i = 0;
        int j = 0;
        while (i < s.length()) {
            String substring = s.substring(j, i + 1);
            while (map.get(substring) != null) {
                i++;
                substring = s.substring(j, i + 1);
            }
            j = i;
        }
        return null;
    }

    public static void main(String[] args) {
        new P1309().freqAlphabets("10#11#12");
    }

}
