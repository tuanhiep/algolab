package lab3;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PouringWater {

    public static void main(String[] args) {
        // Do experiments
        pouring(0, 7, 4, 2, 7, 2);
        pouring(10, 0, 4, 2, 7, 2);
        pouring(8, 6, 3, 7, 6, 4);
        pouring(1, 7, 4, 3, 6, 2);
        pouring(2, 7, 4, 3, 6, 2);
        pouring(6, 3, 3, 3, 6, 3);

    }

    /**
     * Method to pour water from start state to target state
     *
     * @param start10
     * @param start7
     * @param start4
     * @param target10
     * @param target7
     * @param target4
     */
    private static void pouring(int start10, int start7, int start4, int target10, int target7, int target4) {

        // stopping rule
        Vertex source = new Vertex(null, start10, start7, start4);
        // Use DFS
        Set<Vertex> reached = new HashSet<Vertex>();
        List<Vertex> stack = new ArrayList<Vertex>();
        stack.add(source);
        while (!stack.isEmpty()) {
            Vertex node = stack.remove(stack.size() - 1);
            if (isTarget(node, target10, target7, target4)) {
                System.out.println(String.format("\nPouring water from (%d, %d, %d) to (%d, %d, %d) by the following steps:", start10, start7, start4, target10, target7, target4));
                outputSequence(node);
                System.out.println("\n");
                return;
            }
            for (Vertex s : node.getAdjacency()) {
                if (!reached.contains(s)) {
                    reached.add(s);
                    stack.add(s);
                }
            }
        }

        System.out.println(String.format("No sequence of pourings from (%d, %d, %d) to (%d, %d, %d)", start10, start7, start4, target10, target7, target4));

    }

    /**
     * output the sequence to the target
     *
     * @param node
     */
    private static void outputSequence(Vertex node) {
        if (node != null) {
            outputSequence(node.prev);
            System.out.print(node.toString() + ", ");
        }
    }

    /**
     * Check if this vertex is the target in which exactly 2 pints in the 7 or 4 pint container
     *
     * @param v
     * @param target10
     * @param target7
     * @param target4
     * @return
     */
    private static boolean isTarget(Vertex v, int target10, int target7, int target4) {

        if (v.container[0] == target10 && v.container[1] == target7 && v.container[2] == target4) {
            return true;
        }
        return false;
    }

}
