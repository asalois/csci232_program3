import java.util.PriorityQueue;

public class Graphs {

    public Graphs() {

    }

    public void Prims(int inArray[][]) {
        PriorityQueue<Vertex> pQ = new PriorityQueue<Vertex>();
        for (int i = 0; i < inArray.length; i++) {
            for (int j = 0; j < inArray[i].length; j++) {
                if (inArray[i][j] != 0) {
                    System.out.println(getEdge(i, j));
                }
            }
        }
    }

    public String getEdge(int i, int j) {
        String alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String out = alpha.substring(i, i + 1);
        out += alpha.substring(j, j + 1);
        return out;
    }
}

class Vertex{
    public String edge;
    public int up;
    public int down;

    public Vertex(String e, int u, int d){
        edge = e;
        up = u;
        down = d;
    }
}
