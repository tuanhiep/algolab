package lab4;

import java.util.LinkedList;

public class Node {
    private int id;
    private LinkedList<Node> adjacent = new LinkedList<Node>();

    public Node(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public LinkedList<Node> getAdjacent() {
        return adjacent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Node)) return false;
        Node node = (Node) o;
        return getId() == node.getId();
    }

    @Override
    public int hashCode() {
        return getId();
    }
}
