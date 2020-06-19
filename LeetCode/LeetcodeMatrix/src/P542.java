import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/**
 * @author bjenuhb
 */

public class P542 {

    static class Position {
        int x, y, length;

        public Position(int x, int y, int length) {
            this.x = x;
            this.y = y;
            this.length = length;
        }

        @Override
        public String toString() {
            return "Position{" + "x=" + x + ", y=" + y + ", length=" + length + '}';
        }
    }

    public int[][] updateMatrix(int[][] matrix) {
        int[][] result = new int[matrix.length][matrix[0].length];
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];

        int[] nextX = new int[]{-1, 0, 1, 0};
        int[] nexty = new int[]{0, 1, 0, -1};

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {

                for (boolean[] array: visited) {
                    Arrays.fill(array, false);
                }

                Queue<Position> queue = new ArrayDeque<>();
                Position position = new Position(i, j, 0);
                queue.offer(position);
                visited[position.x][position.y] = true;
                while (!queue.isEmpty()) {
                    Position currentPosition = queue.poll();
                    if (matrix[currentPosition.x][currentPosition.y] == 0) {
                        result[position.x][position.y] = currentPosition.length;
                        break;
                    }

                    for (int k = 0; k < nextX.length; k++) {
                        Position nextPosition = new Position(currentPosition.x + nextX[k], currentPosition.y + nexty[k],
                            currentPosition.length + 1);
                        if (nextPosition.x >= 0
                            && nextPosition.x < matrix.length
                            && nextPosition.y >= 0
                            && nextPosition.y < matrix[nextPosition.x].length
                            && !visited[nextPosition.x][nextPosition.y]) {
                            queue.add(nextPosition);
                        }
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
            {0, 0, 0},
            {0, 1, 0},
            {0, 0, 0}
        };
        new P542().updateMatrix(matrix);
    }

}
