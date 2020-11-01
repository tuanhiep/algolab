package lab4;


import java.util.HashSet;
import java.util.LinkedList;

public class BreathFirstSearch {

    public static void main(String[] args) {

//      run BFS
        Graph graph = new Graph();
        graph.addNode(0);
        graph.addNode(1);
        graph.addNode(2);
        graph.addNode(3);
        graph.setEdge(0, 1);
        graph.setEdge(0, 3);
        graph.setEdge(3, 2);
        graph.setInitNode(0);
        System.out.println("Run BFS: ");
        runBFS(graph.getInitNodeID(), graph);

//      shortest Path using  BFS
        graph = new Graph();
        graph.addNode(1);
        graph.addNode(2);
        graph.addNode(3);
        graph.setEdge(1, 2);
        graph.setEdge(2, 3);
        System.out.println("\nCase 1: Shortest Path using BFS: ");
        shortestPathBFS(1, 3, graph);

        graph = new Graph();
        graph.addNode(1);
        graph.addNode(2);
        graph.addNode(3);
        graph.setEdge(1, 2);
        graph.setEdge(1, 3);
        System.out.println("\nCase 2: Shortest Path using BFS: ");
        shortestPathBFS(1, 3, graph);

    }

    /**
     * Implementation of BFS algorithm
     *
     * @param beginId
     * @param graph
     */
    private static void runBFS(int beginId, Graph graph) {
        LinkedList<Integer> queue = new LinkedList<Integer>();
        HashSet<Integer> visited = new HashSet<Integer>();
        queue.add(beginId);
        while (!queue.isEmpty()) {
            int nodeId = queue.remove();
            System.out.print(nodeId + " ");
            visited.add(nodeId);
            Node node = graph.getNode(nodeId);
            LinkedList<Node> adjacent = node.getAdjacent();
            for (Node n : adjacent) {
                if (!visited.contains(n.getId())) {
                    queue.add(n.getId());

                }
            }
        }
    }

    /**
     * Get the shortest path from beginId to destId by using BFS algorithm
     *
     * @param beginId
     * @param destId
     * @param graph
     * @return
     */
    private static boolean shortestPathBFS(int beginId, int destId, Graph graph) {
        LinkedList<Integer> queue = new LinkedList<Integer>();
        HashSet<Integer> visited = new HashSet<Integer>();
        queue.add(beginId);
        while (!queue.isEmpty()) {
            int nodeId = queue.remove();
            if (nodeId == destId) {
                printShortestPath(beginId, destId, graph);
                return true;
            }
            visited.add(nodeId);
            Node node = graph.getNode(nodeId);
            LinkedList<Node> adjacent = node.getAdjacent();
            for (Node n : adjacent) {
                if (!visited.contains(n.getId())) {
                    queue.add(n.getId());
                    n.setPrev(node, graph);
                }
            }
        }
        System.out.println("The path doesn't exist");
        return false;
    }

    /**
     * Print out the shortest path to reach destID node
     *
     * @param destId
     * @param graph
     */
    private static void printShortestPath(int sourceId, int destId, Graph graph) {
        LinkedList<Integer> stack = new LinkedList<Integer>();
        Node node = graph.getNode(destId);
        while (node.getId() != sourceId) {
            stack.add(node.getId());
            node = node.getPrev();
        }
        stack.add(sourceId);
        while (!stack.isEmpty()) {
            int top = stack.remove(stack.size() - 1);
            if (stack.size() > 0) {
                System.out.print(top + " --> ");
            } else {
                System.out.print(top);
            }
        }
    }
}
