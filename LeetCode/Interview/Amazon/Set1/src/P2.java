import java.util.HashMap;
import java.util.Map;

/**
 * @author bjenuhb
 */

public class P2 {

    public int[] prisonAfterNDays(int[] cells, int N) {
        int[] nextResult = new int[cells.length];
        Map<String, Integer> stateMap = new HashMap<>();

        for (int j = 0; j < nextResult.length; j++) {
            nextResult[j] = cells[j];
        }

        for (int i = 0; i < N; i++) {
            int numberOfChanges = 0;
            for (int j = 1; j < cells.length - 1; j++) {
                if ((cells[j - 1] == 0 && cells[j + 1] == 0) ||
                    (cells[j - 1] == 1 && cells[j + 1] == 1)) {
                    if (nextResult[j] != 1) {
                        nextResult[j] = 1;
                        numberOfChanges++;
                    }
                } else {
                    if (nextResult[j] != 0) {
                        nextResult[j] = 0;
                        numberOfChanges++;
                    }
                }
            }
            if (nextResult[0] != 0) {
                numberOfChanges++;
                nextResult[0] = 0;
            }
            if (nextResult[nextResult.length - 1] != 0) {
                nextResult[nextResult.length - 1] = 0;
                numberOfChanges++;
            }
            if (numberOfChanges == 0) {
                break;
            }
            for (int j = 0; j < nextResult.length; j++) {
                cells[j] = nextResult[j];
            }
            StringBuilder initialResult = new StringBuilder();
            for (int j = 0; j < nextResult.length; j++) {
                initialResult.append(cells[j]);
            }
            if (stateMap.get(initialResult.toString()) != null) {
                i = N - (N % i);
                stateMap.remove(initialResult.toString());
            } else {
                stateMap.put(initialResult.toString(), i);
            }
        }
        return cells;
    }

    public static void main(String[] args) {
        int[] input = new int[]{1,0,0,1,0,0,1,0};
        int target = 1000000000;
        int[] result = new P2().prisonAfterNDays(input, target);
    }

}
