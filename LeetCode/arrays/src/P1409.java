import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author bjenuhb
 */

public class P1409 {

    public int[] processQueries(int[] queries, int m) {
        int[] result = new int[queries.length];
        List<Integer> permutation = IntStream.range(1, m + 1).boxed().collect(Collectors.toList());
        int pos = 0;
        for (int num: queries) {
            for (int i = 0; i < permutation.size(); i++) {
                if (permutation.get(i) == num) {
                    Integer remove = permutation.remove(i);
                    permutation.add(0, remove);
                    result[pos++] = i;
                    break;
                }
            }
        }
        return result;
    }
}
