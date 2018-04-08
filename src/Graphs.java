import java.util.PriorityQueue;

public class Graphs {

    public Graphs() {

    }

    public void Prims(int nArray[][]) {
        int[][] inArray = nArray.clone();
        PriorityQueue<Edge> pQ1 = new PriorityQueue<Edge>();
        Edge[] tree = new Edge[25];
        int numTree = 0;
        for (int i = 0; i < inArray.length - 1; i++) {
            for (int j = 0; j < inArray[i].length; j++) {
                if (inArray[i][j] != 0) {
                    String edge = getEdge(i, j);
                    // System.out.println(edge);
                    pQ1.add(new Edge(edge, i, j, inArray[i][j]));
                }
            }
            tree[numTree] = pQ1.remove();
            inArray[tree[numTree].up][tree[numTree].down] = 0;
            inArray[tree[numTree].down][tree[numTree].up] = 0;
            numTree++;
            pQ1.clear();
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
        Edge[] kPath = new Edge[inArray.length];
        Edge temp;
        Edge[] vertexes = new Edge[pQ.size()+2];
        vertexes[0] = current;
        kPath[0] = current;
        int numvertex = 1;
        int x = 1;
        while (!pQ.isEmpty()) {
            boolean inVert = false;
            temp = pQ.remove();
            for (int i = 0; i < numvertex; i++) {
                if (vertexes[i] != null) {
                    if (temp.comp(vertexes[i])) {
                       inVert = true;
                       break;
                    }
                }
            }
            if(!inVert){
                kPath[x] = temp;
                x++;
                if(x == inArray.length){
                    break;
                }
            }
            vertexes[numvertex] = temp;
            ++numvertex;
        }

        for(int i = 0; i < kPath.length; i++) {
            System.out.println(kPath[i].edge);
        }

        System.out.println();
    }

    public void FloydWarshalls(int dimension, int[][] inputMatrix) {
        int[][] floyd;                  //Creates a new matrix for manipulation
        floyd = inputMatrix;
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                for (int k = 0; k < dimension; k++) {
                    if (floyd[j][i] == 0) {
                        if (floyd[j][k] > 99999 + floyd[i][k]) {
                            floyd[j][k] = floyd[j][i] + floyd[i][k];
                        }
                    } else if (floyd[i][k] == 0) {
                        if (floyd[j][k] > floyd[j][i] + 99999) {
                            floyd[j][k] = floyd[j][i] + floyd[i][k];
                        }
                    } else if (floyd[j][k] == 0 && j != k) {
                        if (floyd[j][i] != 0 && floyd[i][k] != 0) {
                            floyd[j][k] = floyd[j][i] + floyd[i][k];
                        }
                    } else if (floyd[j][k] > floyd[j][i] + floyd[i][k]) {
                        floyd[j][k] = floyd[j][i] + floyd[i][k];
                    }
                }
                printFloyd(dimension, floyd);
            }
        }
    }

    public void printFloyd(int dimension, int[][] floyd) {
        System.out.println();
        for (int x = 0; x < dimension; x++) {
            for (int y = 0; y < dimension; y++) {
                System.out.print(floyd[x][y] + " ");
            }
            System.out.println();
        }
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
