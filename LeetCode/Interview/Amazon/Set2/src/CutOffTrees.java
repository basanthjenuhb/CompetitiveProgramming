import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author bjenuhb
 */

class Position {
    int x, y, length;

    public Position(int x, int y, int length) {
        this.x = x;
        this.y = y;
        this.length = length;
    }
}

public class CutOffTrees {

    public int cutOffTree(List<List<Integer>> forest) {
        int[] pathx = new int[]{1, 0, -1, 0};
        int[] pathy = new int[]{0, -1, 0, 1};
        Map<Integer, Integer> pathLength = new HashMap<>();
        int max = Integer.MIN_VALUE;
        for (List<Integer> rows: forest) {
            for (Integer column: rows) {
                if (column > 0) {
                    pathLength.put(column, Integer.MAX_VALUE);
                }
                max = Math.max(max, column);
            }
        }

        List<Integer> allTrees = new ArrayList<>(pathLength.keySet());
        Collections.sort(allTrees);

        int sourcex = 0, sourcey = 0;
        boolean[][] visited = new boolean[forest.size()][forest.get(0).size()];

        for (Integer targetTree: allTrees) {

            for (boolean[] booleans : visited) {
                Arrays.fill(booleans, false);
            }

            Queue<Position> queue = new ArrayDeque<>();
            Position sourcePosition = new Position(sourcex, sourcey, 0);
            queue.offer(sourcePosition);
            visited[sourcePosition.x][sourcePosition.y] = true;
            int count = 0;
            boolean success = false;
            while (!queue.isEmpty()) {
                Position currentPosition = queue.poll();
                if (forest.get(currentPosition.x).get(currentPosition.y).equals(targetTree)) {
                    sourcex = currentPosition.x;
                    sourcey = currentPosition.y;
                    success = true;
                    count = currentPosition.length;
                    break;
                }
                for (int i = 0; i < pathx.length; i++) {
                    int nextx = pathx[i] + currentPosition.x;
                    int nexty = pathy[i] + currentPosition.y;
                    if (nextx >= 0
                        && nexty >= 0
                        && nextx < forest.size()
                        && nexty < forest.get(nextx).size()
                        && forest.get(nextx).get(nexty) != 0
                        && !visited[nextx][nexty]) {
                        Position nextPosition = new Position(nextx, nexty, currentPosition.length + 1);
                        queue.offer(nextPosition);
                        visited[nextPosition.x][nextPosition.y] = true;
                    }
                }
            }
            if (success) {
                pathLength.put(targetTree, count);
            } else {
                return -1;
            }
        }
        int count = 0;
        for (Integer tree: pathLength.keySet()) {
            count += pathLength.get(tree);
        }
        return count;
    }

    public static void main(String[] args) {
        List<List<Integer>> forest = new ArrayList<>();
        List<Integer> row1 = new ArrayList<>();
        row1.add(2);
        row1.add(3);
        row1.add(4);

        List<Integer> row2 = new ArrayList<>();
        row2.add(0);
        row2.add(0);
        row2.add(0);

        List<Integer> row3 = new ArrayList<>();
        row3.add(7);
        row3.add(6);
        row3.add(5);

        forest.add(row1);
        forest.add(row2);
        forest.add(row3);
        new CutOffTrees().cutOffTree(forest);
    }

}
