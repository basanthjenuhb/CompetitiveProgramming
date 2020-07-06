import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author bjenuhb
 */

public class P1 {

    private class Pair {
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Pair{" + "x=" + x + ", y=" + y + '}';
        }
    }

    public int orangesRotting(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        Queue<Pair> queue = new ArrayDeque<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new Pair(i, j));
                    visited[i][j] = true;
                }
            }
        }

        int[] nextX = new int[]{1, 0, -1, 0};
        int[] nextY = new int[]{0, -1, 0, 1};

        int minutes = 0;
        while (!queue.isEmpty()) {
            minutes++;
            Queue<Pair> nextLevelQueue = new ArrayDeque<>();
            while (!queue.isEmpty()) {
                Pair currentPosition = queue.poll();
                for (int i = 0; i < nextX.length; i++) {
                    Pair nextPosition = new Pair(currentPosition.x + nextX[i], currentPosition.y + nextY[i]);
                    if (nextPosition.x >= 0
                        && nextPosition.x < grid.length
                        && nextPosition.y >= 0
                        && nextPosition.y < grid[nextPosition.x].length
                        && !visited[nextPosition.x][nextPosition.y]
                        && grid[nextPosition.x][nextPosition.y] == 1) {
                        nextLevelQueue.offer(nextPosition);
                        visited[nextPosition.x][nextPosition.y] = true;
                        grid[nextPosition.x][nextPosition.y] = 2;
                    }
                }
            }
            queue = nextLevelQueue;
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }
        return Math.max(0, minutes - 1);
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{{2,1,1}, {1,1,0}, {0,1,1}};
        System.out.println(new P1().orangesRotting(grid));
    }

}
