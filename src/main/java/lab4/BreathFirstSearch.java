package lab4;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class BreathFirstSearch {

    public static void main(String[] args) throws IOException {

//      run BFS
        System.out.print("* Run BFS");
//      Test case
//      Input:
//          4( Vertices) 3(Edges)
//          0 1 0 3 3 2
        Graph graph = new Graph();
        graph.addNode(0);
        graph.addNode(1);
        graph.addNode(2);
        graph.addNode(3);
        graph.setEdge(0, 1);
        graph.setEdge(0, 3);
        graph.setEdge(3, 2);
        graph.setInitNode(0);
        System.out.println("\nCase 1: ");
        runBFS(graph.getInitNodeID(), graph);

//      Test case 2
//      Input:
//          6(Vertices) 6(Edges)
//          0 2 0 1 1 3 3 4 4 6 4 5
        graph = new Graph();
        graph.addNode(0);
        graph.addNode(1);
        graph.addNode(2);
        graph.addNode(3);
        graph.addNode(4);
        graph.addNode(5);
        graph.addNode(6);
        graph.setEdge(0, 2);
        graph.setEdge(0, 1);
        graph.setEdge(1, 3);
        graph.setEdge(3, 4);
        graph.setEdge(4, 6);
        graph.setEdge(4, 5);
        graph.setInitNode(0);
        System.out.println("\nCase 2: ");
        runBFS(graph.getInitNodeID(), graph);

//      shortest Path using  BFS
        System.out.print("\n* Test Shortest Path using BFS:");
//      Test case 1
//      Input
//        3(vertices) 2(edges)
//        1 2
//        1 3
        graph = new Graph();
        graph.addNode(1);
        graph.addNode(2);
        graph.addNode(3);
        graph.setEdge(1, 2);
        graph.setEdge(1, 3);
        System.out.println("\nCase 1: ");
        shortestPathBFS(1, 3, graph);

//      Test case 2
//      Input
//        3(vertices) 2(edges)
//        1 2
//        2 3
        graph = new Graph();
        graph.addNode(1);
        graph.addNode(2);
        graph.addNode(3);
        graph.setEdge(1, 2);
        graph.setEdge(2, 3);
        System.out.println("\nCase 2:");
        shortestPathBFS(1, 3, graph);

//      Test case 3
//      shortest Path using BFS, graph configuration is loaded from file graph1.conf, line 1 contains number of vertices
//      and edges. From line 2, they are the edges in the form: source vertex --> destination vertex
//      we can easily change the graph1.conf to test
//      Input
//        3(vertices) 2(edges)
//        1 2
//        2 3
        graph = loadConfig("graph1.conf");
        System.out.println("\nCase 3: Graph is loaded from graph1.conf file.");
        shortestPathBFS(1, 3, graph);

//      Test case 4
//      shortest Path using BFS, graph configuration is loaded from file graph1.conf, line 1 contains number of vertices
//      and edges. From line 2, they are the edges in the form: source vertex --> destination vertex
//      we can easily change the graph1.conf to test
//      Input
//        6(vertices) 6(edges)
//            0 1
//            1 2
//            2 3
//            2 5
//            3 4
//            4 5
        graph = loadConfig("graph2.conf");
        System.out.println("\nCase 4: Graph is loaded from graph2.conf file.");
        shortestPathBFS(0, 5, graph);

    }

    /**
     * Method to load configuration for graph from the external file graph1.conf
     *
     * @param location
     * @return graph object
     * @throws IOException
     */
    private static Graph loadConfig(String location) throws IOException {
        Graph graph = new Graph();
        List lines = Files.readAllLines(Paths.get("src/main/java/lab4/"+location));

        for (int i = 1; i < lines.size(); i++) {
            String[] nodeIds = ((String) lines.get(i)).split("\\s+");
            int ida = Integer.parseInt(nodeIds[0]);
            int idb = Integer.parseInt(nodeIds[1]);
            graph.addNode(ida);
            graph.addNode(idb);
            graph.setEdge(ida, idb);
        }
        return graph;
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
        System.out.println("Shortest distance is " + (stack.size() - 1));
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
