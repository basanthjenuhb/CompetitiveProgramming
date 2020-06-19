import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.function.Function;

/**
 * @author bjenuhb
 */


class FastReader
{
    final private int BUFFER_SIZE = 1 << 16;
    private DataInputStream din;
    private byte[] buffer;
    private int bufferPointer, bytesRead;

    public FastReader()
    {
        din = new DataInputStream(System.in);
        buffer = new byte[BUFFER_SIZE];
        bufferPointer = bytesRead = 0;
    }

    public FastReader(String file_name) throws IOException
    {
        din = new DataInputStream(new FileInputStream(file_name));
        buffer = new byte[BUFFER_SIZE];
        bufferPointer = bytesRead = 0;
    }

    public String readLine() throws IOException
    {
        byte[] buf = new byte[64]; // line length
        int cnt = 0, c;
        while ((c = read()) != -1)
        {
            if (c == '\n')
                break;
            buf[cnt++] = (byte) c;
        }
        return new String(buf, 0, cnt);
    }

    public int nextInt() throws IOException
    {
        int ret = 0;
        byte c = read();
        while (c <= ' ')
            c = read();
        boolean neg = (c == '-');
        if (neg)
            c = read();
        do
        {
            ret = ret * 10 + c - '0';
        }  while ((c = read()) >= '0' && c <= '9');

        if (neg)
            return -ret;
        return ret;
    }

    public long nextLong() throws IOException
    {
        long ret = 0;
        byte c = read();
        while (c <= ' ')
            c = read();
        boolean neg = (c == '-');
        if (neg)
            c = read();
        do {
            ret = ret * 10 + c - '0';
        }
        while ((c = read()) >= '0' && c <= '9');
        if (neg)
            return -ret;
        return ret;
    }

    public double nextDouble() throws IOException
    {
        double ret = 0, div = 1;
        byte c = read();
        while (c <= ' ')
            c = read();
        boolean neg = (c == '-');
        if (neg)
            c = read();

        do {
            ret = ret * 10 + c - '0';
        }
        while ((c = read()) >= '0' && c <= '9');

        if (c == '.')
        {
            while ((c = read()) >= '0' && c <= '9')
            {
                ret += (c - '0') / (div *= 10);
            }
        }

        if (neg)
            return -ret;
        return ret;
    }

    private void fillBuffer() throws IOException
    {
        bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
        if (bytesRead == -1)
            buffer[0] = -1;
    }

    private byte read() throws IOException
    {
        if (bufferPointer == bytesRead)
            fillBuffer();
        return buffer[bufferPointer++];
    }

    public void close() throws IOException
    {
        if (din == null)
            return;
        din.close();
    }
}

class Graph<T> {

    private boolean directed = false;
    int nodes = 0;
    private Map<T, List<T>> map;

    public Graph(int nodes) {
        this.nodes = nodes;
        map = new HashMap<>(nodes);
    }

    public int getNodes() {
        return nodes;
    }

    private Function<T, List<T>> arrayListProducer = t -> new ArrayList<>();

    public void addEdge(T source, T destination) {
        map.computeIfAbsent(source, arrayListProducer).add(destination);
        if (!directed) {
            map.computeIfAbsent(destination, arrayListProducer).add(source);
        }
    }

    public List<T> getNeighbours(T source) {
        return map.computeIfAbsent(source, t -> new ArrayList<>());
    }

    public void setDirected(boolean directed) {
        this.directed = directed;
    }
}

class Solver {

    public void solve (Graph<Integer> graph) {
        Map<Integer, Boolean> visited = new HashMap<>();
        Queue<Integer> queue = new ArrayDeque<>();
        Integer[] team = new Integer[graph.getNodes() + 1];

        int currentTeam = 0;
        for (int i = 1; i <= graph.getNodes(); i++) {
            if (visited.get(i) != Boolean.TRUE) {
                queue.offer(i);
                currentTeam = (currentTeam + 1) % 2;
                team[i] = currentTeam;
                while (!queue.isEmpty()) {
                    Integer currentNode = queue.poll();
                    List<Integer> neighbours = graph.getNeighbours(currentNode);
                    final Integer teamId = (team[currentNode] + 1) % 2;
                    neighbours.forEach(neighbour -> {
                        if (visited.get(neighbour) != Boolean.TRUE) {
                            queue.offer(neighbour);
                            team[neighbour] = teamId;
                            visited.put(neighbour, true);
                        } else {
                            if (team[neighbour] != teamId) {
                                System.out.println("IMPOSSIBLE");
                                System.exit(0);
                            }
                        }
                    });
                }
            }
        }
        for (int i = 1; i < team.length; i++) {
            System.out.print((team[i] + 1) + " ");
        }
    }
}

public class BuildingTeams {

    public static void main(String[] args) throws Exception {
        FastReader fastReader = new FastReader();
        int nodes = fastReader.nextInt(), edges = fastReader.nextInt();

        Graph<Integer> graph = new Graph<>(nodes);

        for (int i = 0; i < edges; i++) {
            int source = fastReader.nextInt();
            int destination = fastReader.nextInt();
            graph.addEdge(source, destination);
        }
        new Solver().solve(graph);

    }

}
