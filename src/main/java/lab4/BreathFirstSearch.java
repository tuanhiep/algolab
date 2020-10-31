package lab4;


import java.util.HashSet;
import java.util.LinkedList;

public class BreathFirstSearch {

    public static void main(String[] args) {

        Graph graph = new Graph();
        graph.addNode(1);
        graph.addNode(2);
        graph.addNode(3);
        graph.addNode(4);
        graph.addNode(5);
        graph.addNode(6);
        graph.addNode(7);
        graph.setEdge(1, 2);
        graph.setEdge(2, 3);
        graph.setEdge(3, 4);
        graph.setEdge(2, 5);
        graph.setEdge(5, 6);
        graph.setEdge(3, 7);
        graph.setInitNode(1);

        int keyNode = 7;
        boolean result = hasPathBFS(graph.getInitNodeID(), keyNode, graph);


    }

    private static boolean hasPathBFS(int beginId, int destId, Graph graph) {
        LinkedList<Integer> nextToVisit = new LinkedList<Integer>();
        HashSet<Integer> visited = new HashSet<Integer>();
        nextToVisit.add(beginId);
        while (!nextToVisit.isEmpty()) {
            int nodeId = nextToVisit.remove();
            if (nodeId == destId) {
                return true;
            }
            if (visited.contains(nodeId)) {
                continue;
            }
            visited.add(nodeId);
            Node node = graph.nodeLookUp.get(nodeId);
            LinkedList<Node> adjacent = node.getAdjacent();
            for (Node n : adjacent) {
                if (!visited.contains(n.getId())) {
                    nextToVisit.add(n.getId());

                }
            }
        }
        return false;
    }

}
