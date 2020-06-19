import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;
import java.util.Stack;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author bjenuhb
 */

class Graph<T> {

    int nodes = 0;
    private Function<T, List<T>> arrayListProducer = t -> new ArrayList<>();
    private boolean directed = false;
    private Map<T, List<T>> map;

    public Graph(int nodes) {
        this.nodes = nodes;
        map = new HashMap<>(nodes);
    }

    public int getNodes() {
        return nodes;
    }

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

class Node {
    int nodeId;
    Node source;

    public Node(int nodeId, Node source) {
        this.nodeId = nodeId;
        this.source = source;
    }

    public int getNodeId() {
        return nodeId;
    }

    public Node getSource() {
        return source;
    }

    @Override
    public String toString() {
        return "Node{" + "nodeId=" + nodeId + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return getNodeId() == node.getNodeId() && Objects.equals(getSource(), node.getSource());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNodeId(), getSource());
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


    public void solver(Graph<Integer> graph) {

        Stack<Node> stack = new Stack<>();
        Node target = null;
        for (int i = 1; i <= graph.getNodes(); i++) {
            if (!isVisited(i)) {
                stack.push(new Node(i, null));
                setVisited(i);
                while (!stack.isEmpty()) {
                    Node currentNode = stack.peek();
                    int count = 0;
                    for (Integer neighbour: graph.getNeighbours(currentNode.getNodeId())) {
                        if (!isVisited(neighbour)) {
                            stack.push(new Node(neighbour, currentNode));
                            setVisited(neighbour);
                            count++;
                        } else {
                            int totalCycleCount = 0;
                            Node temp = currentNode;
                            while (temp != null && temp.nodeId != neighbour) {
                                temp = temp.getSource();
                                totalCycleCount++;
                            }
                            if (totalCycleCount >= 2) {
                                System.out.println(totalCycleCount + 2);
                                System.out.print(neighbour + " ");
                                while (currentNode != null) {
                                    System.out.print(currentNode.nodeId + " ");
                                    currentNode = currentNode.source;
                                }
                                System.out.print(neighbour);
                                System.exit(0);
                            }
                        }
                    }
                    if (count == 0) {
                        stack.pop();
                    }
                }
            }
        }

        while (target != null) {
            System.out.println(target);
            target = target.getSource();
        }
    }
}

public class RoundTrip {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cities = scanner.nextInt(), roads = scanner.nextInt();
        Graph<Integer> graph = new Graph<>(cities);
        for (int i = 0; i < roads; i++) {
            int source = scanner.nextInt();
            int destination = scanner.nextInt();
            graph.addEdge(source, destination);
        }
        Solver solver = new Solver();
        solver.solver(graph);
    }

}
