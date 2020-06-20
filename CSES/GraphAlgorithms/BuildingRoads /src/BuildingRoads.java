import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.function.Function;

/**
 * @author bjenuhb
 */

class FastReader
{
    BufferedReader br;
    StringTokenizer st;

    public FastReader()
    {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    String next() throws Exception {
        while (st == null || !st.hasMoreElements()) {
            st = new StringTokenizer(br.readLine());
        }
        return st.nextToken();
    }

    int nextInt() throws Exception {
        return Integer.parseInt(next());
    }

    long nextLong() throws Exception {
        return Long.parseLong(next());
    }

    double nextDouble() throws Exception {
        return Double.parseDouble(next());
    }

    String nextLine()
    {
        String str = "";
        try
        {
            str = br.readLine();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return str;
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
    Map<Integer, Boolean> visited = new HashMap<>();

    private Boolean isVisited(Integer node) {
        return visited.get(node) == Boolean.TRUE;
    }

    private void setVisited(Integer node) {
        visited.put(node, true);
    }

    public void solve(Graph<Integer> graph) {
        Queue<Integer> queue = new ArrayDeque<>(graph.getNodes());
        List<Integer> results = new ArrayList<>();
        for (int i = 1; i <= graph.getNodes(); i++) {
            if (!isVisited(i)) {
                results.add(i);
                setVisited(i);
                queue.offer(i);
                while (!queue.isEmpty()) {
                    Integer node = queue.poll();
                    for (Integer neighbour: graph.getNeighbours(node)) {
                        if (!isVisited(neighbour)) {
                            queue.offer(neighbour);
                            setVisited(neighbour);
                        }
                    }
                }
            }
        }
        System.out.println(results.size() - 1);
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < results.size() - 1; i++) {
            output.append(results.get(i)).append(" ").append(results.get(i + 1)).append("\n");
        }
        System.out.println(output);
    }
}

public class BuildingRoads {

    public static void main(String[] args) throws Exception {
        FastReader fastReader = new FastReader();
        int n = fastReader.nextInt(), m = fastReader.nextInt();
        Graph<Integer> graph = new Graph<>(n);

        for (int i = 0; i < m; i++) {
            int source = fastReader.nextInt();
            int destination = fastReader.nextInt();
            graph.addEdge(source, destination);
        }
        Solver solver = new Solver();
        solver.solve(graph);
    }

}
