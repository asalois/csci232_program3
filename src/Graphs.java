import java.util.PriorityQueue;

public class Graphs {

    public Graphs() {

    }

    public void Prims(int inArray[][]) {
        PriorityQueue<Edge> pQ = new PriorityQueue<Edge>();
        Edge[] tree = new Edge[25];
        int numTree = 0;
        for (int i = 0; i < inArray.length - 1; i++) {
            for (int j = 0; j < inArray[i].length; j++) {
                if (inArray[i][j] != 0) {
                    String edge = getEdge(i, j);
                    // System.out.println(edge);
                    pQ.add(new Edge(edge, i, j, inArray[i][j]));
                }
            }
            tree[numTree] = pQ.remove();
            inArray[tree[numTree].up][tree[numTree].down] = 0;
            inArray[tree[numTree].down][tree[numTree].up] = 0;
            numTree++;
            pQ.clear();
        }
        int i = 0;
        while (tree[i] != null) {
            System.out.println(tree[i].edge);
            i++;
        }

    }

    public String getEdge(int j, int i) {
        String alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String out = alpha.substring(j, j + 1);
        out += alpha.substring(i, i + 1);
        return out;
    }

    public void Kruskals(int inArray[][]) {
        PriorityQueue<Edge> pQ = new PriorityQueue<Edge>();     //hold all of the edges
        for (int i = 0; i < inArray.length; i++) {                //finds edges to add to the que
            for (int j = 0; j < inArray[i].length; j++) {
                if (inArray[i][j] != 0) {
                    String edge = getEdge(i, j);
                    pQ.add(new Edge(edge, i, j, inArray[i][j]));
                }
            }
        }
        Edge current = pQ.remove();
        Edge[] kPath = new Edge[4];
        char[] vertexes = new char[inArray.length + 1];
        vertexes[0] = current.edge.charAt(0);
        vertexes[1] = current.edge.charAt(1);
        kPath[0] = current;
        int numvertex = 2;
        int x = 1;
        boolean vertexA = false;
        boolean vertexB = false;
        while (!pQ.isEmpty()) {
            Edge temp = pQ.remove();
            if (!temp.comp(current)) {

                for (int i = 0; i < numvertex; i++) {
                    if (temp.edge.charAt(0) == vertexes[i]) {
                        vertexA = true;
                    }
                    if (temp.edge.charAt(1) == vertexes[i]) {
                        vertexB = true;
                    }
                }
                if (!vertexA || !vertexB) {
                    System.out.println(temp.edge + " temp");
                    if(!vertexA){
                        vertexes[numvertex] = temp.edge.charAt(0);
                        numvertex++;
                    }
                    if(!vertexB){
                        vertexes[numvertex] = temp.edge.charAt(1);
                        numvertex++;
                    }

                }
                if (!vertexA || !vertexB) {
                    kPath[x] = temp;
                    current = temp;
                    x++;
                }
            }

        }
        for(int z = 0; z < 5; z++){
            System.out.println(kPath[z].edge);
        }


    }

    public void FloydWarshalls(int dimension, int[][] inputMatrix) {
        int[][] d = new int[dimension][dimension];                  //Creates a new matrix for manipulation
        d = inputMatrix;
    }
}

class Edge implements Comparable<Edge> {
    public String edge;
    public int up;
    public int down;
    public int weight;
    public Edge next;

    public int compareTo(Edge that) {
        return (int) this.weight - that.weight;
    }

    public boolean comp(Edge that) {
        String alt;
        alt = this.edge.substring(1);
        alt += this.edge.substring(0, 1);
        if (that.edge.equals(alt) || that.edge.equals(this.edge)) {
            return true;
        }
        return false;
    }


    public Edge(String e, int u, int d, int w) {
        edge = e;
        up = u;
        down = d;
        weight = w;
    }

    public Edge(String s, int u, int d, int w, Edge e) {
        edge = s;
        up = u;
        down = d;
        weight = w;
        next = e;
    }

}
