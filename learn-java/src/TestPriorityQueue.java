import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author bjenuhb
 */

class MyPriorityQueue<T extends Comparable<T>> {

    private List<T> array = new ArrayList<>();;
    private Comparator<T> comparator;
    int size = 0;

    public MyPriorityQueue() {
        comparator = Comparator.naturalOrder();
    }

    public MyPriorityQueue(Comparator<T> comparator) {
        this.comparator = comparator;
    }

    public int getSIze() {
        return array.size();
    }

    public void insert(T value) {
        array.add(value);
        int currentPosition = array.size() - 1;
        while (currentPosition > 0) {
            int parent = (currentPosition - 1) / 2;
            T parentValue = array.get(parent);
            if (comparator.compare(value, parentValue) >= 0) {
                break;
            }
            array.set(currentPosition, parentValue);
            currentPosition = parent;
        }
        array.set(currentPosition, value);
    }

    public T remove() {
        int size = array.size() - 1;
        T elementToReturn = array.get(0);
        array.set(0, array.get(size));
        array.remove(size);
        int currentPosition = 0;
        size = array.size() - 1;
        while (currentPosition <= size / 2) {
            int leftChild = currentPosition * 2 + 1;
            int rightChild = currentPosition * 2 + 2;
            if (leftChild <= size
                && comparator.compare(array.get(currentPosition), array.get(leftChild)) > 0) {
                T temp =  array.get(currentPosition);
                array.set(currentPosition, array.get(leftChild));
                array.set(leftChild, temp);
                currentPosition = leftChild;
            } else if (rightChild <= size
                && comparator.compare(array.get(currentPosition), array.get(rightChild)) > 0) {
                T temp =  array.get(currentPosition);
                array.set(currentPosition, array.get(rightChild));
                array.set(rightChild, temp);
                currentPosition = rightChild;
            } else {
                break;
            }
        }
        return elementToReturn;
    }

    @Override
    public String toString() {
        StringBuilder value = new StringBuilder();
        for (T arrayValue: array) {
            value.append(arrayValue).append(",");
        }
        return value.toString();
    }
}

class Node implements Comparable<Node> {

    @Override
    public int compareTo(Node o) {
        return 0;
    }
}

class NodeComparator implements Comparator<Node> {

    @Override
    public int compare(Node o1, Node o2) {
        return 0;
    }
}


public class TestPriorityQueue {
    public static void main(String[] args) {
        Comparator<Integer> integerComparator = Comparator.naturalOrder();
        Comparator<Integer> reversed = integerComparator.reversed();
        MyPriorityQueue<Integer> pq = new MyPriorityQueue<>(reversed);
        pq.insert(10);
        pq.insert(20);
        pq.insert(5);
        pq.insert(7);
        System.out.println("pq = " + pq);
        pq.remove();
        System.out.println("pq = " + pq);
        pq.remove();
        System.out.println("pq = " + pq);
    }

}
