import java.util.PriorityQueue;

public class Graphs {

    public Graphs() {

    }

    public void Prims(int nArray[][]) {
        int[][] inArray = nArray.clone();  // an array to use with out
        PriorityQueue<Edge> pQ1 = new PriorityQueue<Edge>();  // create a priority que of type Edge and sorted by weight
        Edge[] tree = new Edge[inArray.length];  //  an array of edges to hold the edges foe the output
        int numTree = 0;  //  number of edges in the tree
        for (int i = 0; i < inArray.length - 1; i++) {  // the last vertex does not need to be used as it will already be connected
            for (int j = 0; j < inArray[i].length; j++) { // double for loop to look through entire matrix
                if (inArray[i][j] != 0) {  // if the weight is not 0 or empty
                    String edge = getEdge(i, j);  // gets the edge as a string
                    pQ1.add(new Edge(edge, i, j, inArray[i][j]));  //  creates an edge and then adds to the que
                }
            }
            tree[numTree] = pQ1.remove();  // pop the first one on the que
            inArray[tree[numTree].up][tree[numTree].down] = 0;  // zero out and replace the edge popped
            inArray[tree[numTree].down][tree[numTree].up] = 0;  // make sure to remove in both places
            numTree++; // keep track of how many in the tree
            pQ1.clear(); // clean the que and start over for the next vertex
        }
        int count = 0;  //  integer to go through tree array
        while (tree[count] != null) { // print the tree array until there is nothing to print
            System.out.println(tree[count].edge);
            count++;
        }

    }

    public String getEdge(int j, int i) { // returns a string of the edge
        String alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";  //  all the alphabet to grab use
        String out = alpha.substring(j, j + 1);  // grab the first vertex in the matrix give it the corresponding letter
        out += alpha.substring(i, i + 1);  // add the next to letter the string
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
        char[] vertexes = new char[inArray.length + 1];
        vertexes[0] = current.edge.charAt(0);
        vertexes[1] = current.edge.charAt(1);
        kPath[0] = current;
        int numvertex = 2;
        int x = 1;
        boolean vertexA = false;
        boolean vertexB = false;
        while (!pQ.isEmpty()) {
            temp = pQ.remove();
            vertexA = false;
            vertexB = false;
            for (int i = 0; i < numvertex; i++) {
                if (temp.edge.charAt(0) == vertexes[i]) {
                    vertexA = true;
                }
                if (temp.edge.charAt(1) == vertexes[i]) {
                    vertexB = true;
                }
            }
            if (!vertexA || !vertexB) {
                if (!vertexA) {
                    vertexes[numvertex] = temp.edge.charAt(0);
                    numvertex++;
                }
                if (!vertexB) {
                    vertexes[numvertex] = temp.edge.charAt(1);
                    numvertex++;
                }
            }
            if (!vertexA || !vertexB) {
                kPath[x] = temp;
                x++;
            }
        }

        int i = 0;
        while (kPath[i] != null) {
            System.out.println(kPath[i].edge);
            i++;
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
