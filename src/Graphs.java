import java.util.PriorityQueue;

public class Graphs {

    public Graphs() {

    }

    public void Prims(int inArray[][]) {
        PriorityQueue<Edge> pQ = new PriorityQueue<Edge>();
        int j = 0;
        for (int i = 0; i < inArray.length; i++) {
            if (inArray[i][j] != 0) {
                String edge = getEdge(i, j);
                pQ.add(new Edge(edge, i, j, inArray[i][j]));
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

class Edge implements Comparable<Edge> {
    public String edge;
    public int up;
    public int down;
    public int weight;
    public boolean inTree;

    public int compareTo(Edge that) {
        return (int) this.weight - that.weight;
    }


    public Edge(String e, int u, int d, int w) {
        edge = e;
        up = u;
        down = d;
        weight = w;
        inTree = false;
    }

    public void toTrue(){
        inTree = true;
    }
}
