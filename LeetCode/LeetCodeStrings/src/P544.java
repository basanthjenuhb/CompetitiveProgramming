import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author bjenuhb
 */

public class P544 {

    public String findContestMatch(int n) {
        List<String> strings = IntStream.range(1, n + 1).mapToObj(String::valueOf).collect(Collectors.toList());
        while (n > 1) {
            int i = 0, j = n - 1;
            while (i < j) {
                strings.set(i, "(" + strings.get(i) + "," + strings.get(j) + ")");
                i++;
                j--;
            }
            n = n / 2;
        }
        return strings.get(0);
    }

    public static void main(String[] args) {
        System.out.println(new P544().findContestMatch(8));
    }
}
