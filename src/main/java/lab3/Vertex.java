package lab3;

import java.util.ArrayList;
import java.util.List;

public class Vertex {
    int container10;
    int container7;
    int container4;
    List<Vertex> adjacency;


    public Vertex(int container10, int container7, int container4) {
        this.container10 = container10;
        this.container7 = container7;
        this.container4 = container4;
        this.adjacency = new ArrayList<Vertex>();
    }

    public void putAdjacency(Vertex vertex) {
        this.adjacency.add(vertex);
    }


}
