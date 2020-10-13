package lab3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Vertex {
    final static int[] size = {10, 7, 4};
    public int[] container;
    Vertex prev;

    public Vertex(Vertex prev, int... content) {
        this.container = content;
        this.prev = prev;
    }

    /**
     * @return adjacency Vertices
     */
    public List<Vertex> getAdjacency() {
        List<Vertex> result = new ArrayList<Vertex>();
        for (int i = 0; i < container.length; i++) {
            for (int j = 0; j < container.length; j++) {
                if (i != j) {
                    int[] childVertex = new int[3];
                    System.arraycopy(this.container, 0, childVertex, 0, this.container.length);
                    // move a volume from container i to container j
                    int moving = Math.min(container[i], size[j] - container[j]);
                    childVertex[i] -= moving;
                    childVertex[j] += moving;
                    result.add(new Vertex(this, childVertex));
                }
            }
        }
        return result;

    }
    // We need to implement hashCode() and equals() so that the Vertex object could be use by HashSet collection
    @Override
    public int hashCode() {
        return Arrays.hashCode(container);
    }

    @Override
    public boolean equals(Object obj) {
        return Arrays.equals(this.container, ((Vertex) obj).container);
    }

    @Override
    public String toString() {
        return String.format("(%s, %s, %s)", this.container[0], this.container[1], this.container[2]);
    }

}
