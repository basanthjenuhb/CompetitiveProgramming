import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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

class Destination {
    int node, finalCost = Integer.MAX_VALUE;
    long cost;

    public Destination(int node, long cost) {
        this.node = node;
        this.cost = cost;
    }

    public long getCost() {
        return cost;
    }

    @Override
    public String toString() {
        return "Destination{" + "node=" + node + ", cost=" + cost + ", finalCost=" + finalCost + '}';
    }
}

class Graph {
    int nodes;
    List<List<Destination>> adjacencyList;

    public Graph(int nodes) {
        this.nodes = nodes;
        adjacencyList =
            IntStream.range(0, nodes + 1).mapToObj(i -> new ArrayList<Destination>()).collect(Collectors.toList());
    }

    void addEdge(Integer source, Integer destination, Long cost) {
        List<Destination> destinations = adjacencyList.get(source);
        destinations.add(new Destination(destination, cost));
    }

    List<Destination> getNeighbours(Integer source) {
        return adjacencyList.get(source);
    }

    @Override
    public String toString() {
        return "Graph{" + "nodes=" + nodes + ", adjacencyList=" + adjacencyList + '}';
    }
}

public class ShortestRoutesI {

    public static void main(String[] args) throws Exception {
        FastReader fastReader = new FastReader();
        int nodes = fastReader.nextInt(), edges = fastReader.nextInt();

//        System.out.println("System.currentTimeMillis() = " + System.currentTimeMillis());

        Graph graph = new Graph(nodes);

        for (int i = 0; i < edges; i++) {
            int source = fastReader.nextInt();
            int destination = fastReader.nextInt();
            long cost = fastReader.nextLong();
            graph.addEdge(source, destination, cost);
        }
//        System.out.println("System.currentTimeMillis() = " + System.currentTimeMillis());

        Queue<Destination> queue = new ArrayDeque<>();
        queue.offer(new Destination(1, 0));
        boolean[] visited = new boolean[nodes + 1];
        long[] cost = new long[nodes + 1];
        for (int i = 0; i < nodes + 1; i++) {
            cost[i] = Long.MAX_VALUE;
        }
        cost[1] = 0;
        visited[1] = true;
        while (!queue.isEmpty()) {
            Destination destination = queue.poll();
            for (Destination neighbour: graph.getNeighbours(destination.node)) {
                if (cost[neighbour.node] > neighbour.cost + cost[destination.node]) {
                    cost[neighbour.node] = neighbour.cost + cost[destination.node];
                    queue.offer(neighbour);
                }
            }
        }
//        System.out.println("done");
//        System.out.println("System.currentTimeMillis() = " + System.currentTimeMillis());
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 1; i < cost.length; i++) {
            stringBuilder.append(cost[i]).append(" ");
        }
        System.out.println(stringBuilder);
    }
}
