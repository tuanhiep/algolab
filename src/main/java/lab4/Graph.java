package lab4;

import java.util.HashMap;

public class Graph {
    HashMap<Integer, Node> nodeLookUp = new HashMap<Integer, Node>();
    private int initNode;

    public Node getNode(int id) {
        return nodeLookUp.get(id);
    }

    public void setEdge(int sourceId, int destinationId) {
        Node sourceNode = getNode(sourceId);
        Node destinationNode = getNode(destinationId);
        sourceNode.getAdjacent().add(destinationNode);
    }

    public int getInitNodeID() {
        return initNode;
    }

    public void setInitNode(int initNodeID) {
        this.initNode = initNodeID;
    }

    public void addNode(int id) {
        if (this.getNode(id) != null) return;
        Node node = new Node(id);
        this.nodeLookUp.put(id, node);
    }
}
