import java.util.LinkedList;

public class Graph<T> {
    LinkedList<Node<T>> nodes = new LinkedList<>();

    class Node<T> {
        T val;

        public LinkedList<Node> getConnections() {
            return connections;
        }

        LinkedList<Node> connections;

        Node(T val) {
            this.val = val;
        }

    }

    Graph() {
    }

    public void add(T val) {
        nodes.add(new Node<>(val));
    }

    public Node<T> get(T val) {
        for (Node<T> t : nodes
        ) {
            if (t.val == val)
                return t;
        }
        return null;
    }

    public void addConnections(T val,LinkedList<T> linkedNodes){
        for (T t:linkedNodes
             ) {
            get(val).getConnections().add(get(t));
        }
    }
}
