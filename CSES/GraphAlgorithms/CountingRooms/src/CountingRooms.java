import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author bjenuhb
 */

class Pair<T, U> {
    T key;
    U value;

    public Pair(T key, U value) {
        this.key = key;
        this.value = value;
    }

    public T getKey() {
        return key;
    }

    public U getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Pair{" + "key=" + key + ", value=" + value + '}';
    }
}

public class CountingRooms {

    public static boolean isSafe(char[][] map, int x, int y) {
        return
            x >= 0
            && y >= 0
            && x < map.length
            && y < map[0].length &&
            map[x][y] != '#';
    }

    public static void markVisited(char[][] map, int x, int y, boolean[][] visited) {
        int[] nextx = new int[]{1, 0, -1, 0};
        int[] nexty = new int[]{0, -1, 0, 1};
        Queue<Pair<Integer, Integer>> queue = new ArrayDeque<>();
        queue.offer(new Pair<>(x, y));
        while (!queue.isEmpty()) {
            Pair<Integer, Integer> currentNode = queue.poll();
            for (int i = 0; i < nextx.length; i++) {
                Pair<Integer, Integer> nextCoordinate = new Pair<>(
                    currentNode.getKey() + nextx[i],
                    currentNode.getValue() + nexty[i]);

                if (isSafe(map, nextCoordinate.getKey(), nextCoordinate.getValue())
                    && !visited[nextCoordinate.getKey()][nextCoordinate.getValue()]) {
                    queue.offer(nextCoordinate);
                    visited[nextCoordinate.getKey()][nextCoordinate.getValue()] = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt(), width = scanner.nextInt();
        char[][] map = new char[length][width];
        boolean[][] visited = new boolean[length][width];
        for (int i = 0; i < map.length; i++) {
            String line = scanner.next();
            for (int j = 0; j < map[0].length; j++) {
                map[i][j] = line.charAt(j);
            }
        }

        int totalCount = 0;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (isSafe(map, i, j) && !visited[i][j]) {
                    totalCount++;
                    markVisited(map, i, j, visited);
                }
            }
        }
        System.out.println(totalCount);
    }
}
