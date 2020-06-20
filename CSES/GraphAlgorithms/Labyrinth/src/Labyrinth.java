import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author bjenuhb
 */

class Path {
    int x;
    int y;
    String direction;

    public Path(int x, int y, String direction, char reverseDirection) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getDirection() {
        return direction;
    }
}

class Coordinate {
    int x, y;
    private Coordinate sourceCoordinate;
    private String direction;

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public void setSourceCoordinate(Coordinate sourceCoordinate) {
        this.sourceCoordinate = sourceCoordinate;
    }

    public Coordinate getSourceCoordinate() {
        return sourceCoordinate;
    }

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return "Coordinate{" + "x=" + x + ", y=" + y + ", direction='" + direction + '\'' + '}';
    }
}


class Solver {
    int endX = 0, endY = 0, maxX, maxY;
    Character[][] map;
    boolean[][] visited;
    private static List<Path> paths = new ArrayList<>();
    static {
        paths.add(new Path(1, 0, "D", 'L'));
        paths.add(new Path(0, 1, "R", 'U'));
        paths.add(new Path(-1, 0, "U", 'R'));
        paths.add(new Path(0, -1, "L", 'D'));
    }

    public Solver(int endX, int endY, int maxX, int maxY, Character[][] map) {
        this.endX = endX;
        this.endY = endY;
        this.maxX = maxX;
        this.maxY = maxY;
        this.map = map;
        visited = new boolean[maxX][maxY];
    }

    private boolean isWall(int startX, int startY) {
        return map[startX][startY] == '#';
    }

    private boolean isSafe(int startX, int startY) {
        return startX < maxX && startY < maxY && startX >= 0 && startY >= 0 && !isWall(startX, startY) && !visited[startX][startY];
    }

    private boolean isTarget(int startX, int startY) {
        return startX == endX && startY == endY;
    }

    public String solve2(int startX, int startY) {
        Queue<Coordinate> coordinates = new ArrayDeque<>();
        coordinates.offer(new Coordinate(startX, startY));

        visited[startX][startY] = true;
        Coordinate targetCoordinate = null;
        while (!coordinates.isEmpty()) {
            Coordinate currentCoordinate = coordinates.poll();
            if (isTarget(currentCoordinate.getX(), currentCoordinate.getY())) {
                targetCoordinate = currentCoordinate;
                break;
            }
            for (Path path: paths) {
                Coordinate nextCoordinate = new Coordinate(currentCoordinate.getX() + path.getX(),
                    currentCoordinate.getY() + path.getY());

                if (isSafe(nextCoordinate.getX(), nextCoordinate.getY())) {
                    coordinates.offer(nextCoordinate);
                    visited[nextCoordinate.getX()][nextCoordinate.getY()] = true;
                    nextCoordinate.setSourceCoordinate(currentCoordinate);
                    nextCoordinate.setDirection(path.getDirection());
                }
            }
        }
        if (targetCoordinate != null) {
            List<String> result = new ArrayList<>();
            while (targetCoordinate != null && targetCoordinate.getSourceCoordinate() != null) {
                result.add(targetCoordinate.getDirection());
                targetCoordinate = targetCoordinate.getSourceCoordinate();
            }
            System.out.println("YES");
            System.out.println(result.size());
            Collections.reverse(result);
            System.out.println(String.join("", result));
        } else {
            System.out.println("NO");
        }
        return null;
    }
}

public class Labyrinth {

    public static void main(String[] args) {
        Scanner scanner = new java.util.Scanner(System.in);
        int n = scanner.nextInt(), m = scanner.nextInt();
        int startx = 0, starty = 0, endx = 0, endy = 0;
        Character[][] map = new Character[n][m];

        for (int i = 0; i < n; i++) {
            String next = scanner.next();
            for (int j = 0; j < m; j++) {
                map[i][j] = next.charAt(j);
                if (map[i][j] == 'A') {
                    startx = i;
                    starty = j;
                }
                if (map[i][j] == 'B') {
                    endy = i;
                    endx = j;
                }
            }
        }

        Solver solver = new Solver(endy, endx, n, m, map);
        String solve = solver.solve2(startx, starty);
    }
}
