package lab4;


import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class BreathFirstSearch {

    private static int DISTANCE_EDGE = 6;


    public static void main(String[] args) {

        Graph graph = new Graph();
        graph.addNode(0);
        graph.addNode(1);
        graph.addNode(2);
        graph.addNode(3);
        graph.setEdge(0, 1);
        graph.setEdge(0, 3);
        graph.setEdge(3, 2);
        graph.setInitNode(0);
        System.out.println("Test BFS: ");
        runBFS(graph.getInitNodeID(), graph);


    }

    private static boolean runBFS(int beginId, Graph graph) {
        LinkedList<Integer> queue = new LinkedList<Integer>();
        HashSet<Integer> visited = new HashSet<Integer>();
        queue.add(beginId);
        while (!queue.isEmpty()) {
            int nodeId = queue.remove();
            System.out.print(nodeId+ " ");
            visited.add(nodeId);
            Node node = graph.getNode(nodeId);
            LinkedList<Node> adjacent = node.getAdjacent();
            for (Node n : adjacent) {
                if (!visited.contains(n.getId())) {
                    queue.add(n.getId());

                }
            }
        }
        return false;
    }

//    private static boolean hasPathBFS(int beginId, int destId, Graph graph) {
//        LinkedList<Integer> nextToVisit = new LinkedList<Integer>();
//        HashSet<Integer> visited = new HashSet<Integer>();
//        nextToVisit.add(beginId);
//        while (!nextToVisit.isEmpty()) {
//            int nodeId = nextToVisit.remove();
//            if (nodeId == destId) {
//                return true;
//            }
//            if (visited.contains(nodeId)) {
//                continue;
//            }
//            visited.add(nodeId);
//            Node node = graph.nodeLookUp.get(nodeId);
//            LinkedList<Node> adjacent = node.getAdjacent();
//            for (Node n : adjacent) {
//                if (!visited.contains(n.getId())) {
//                    nextToVisit.add(n.getId());
//
//                }
//            }
//        }
//        return false;
//    }


    /**
     * Algorithm to find the shortest path using BFS and with the hypothesis that all the edges have equal size
     *
     * @param startId
     * @param graph
     * @return
     */
    public HashMap<Node, Integer> shortestReach(int startId, Graph graph) {
        LinkedList<Integer> queue = new LinkedList<Integer>();
        queue.add(startId);
        HashMap<Node, Integer> distances = new HashMap<Node, Integer>();
        Node startNode = graph.getNode(startId);
        distances.put(startNode, 0);
        while (!queue.isEmpty()) {
            int nodeId = queue.poll();
            Node node = graph.getNode(nodeId);
            for (Node neighbor : node.getAdjacent()) {
                if (!distances.containsKey(neighbor)) {
                    // Remark that in this problem we suppose that all the distance edge are of equal size
                    // so we update only if the distance of neighbor is not calculated because if even the cycle exists
                    // there are not problem of shorter path like in Dijkstra problem
                    distances.put(neighbor, distances.get(node) + DISTANCE_EDGE);
                    queue.add(neighbor.getId());
                }
            }
        }
        return distances;

    }
}
