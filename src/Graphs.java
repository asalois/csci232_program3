import java.util.PriorityQueue;

public class Graphs {

    public Graphs() {

    }

    public void Prims(int inArray[][]) {
        PriorityQueue<Edge> pQ = new PriorityQueue<Edge>();
        Edge[] tree = new Edge[25];
        int numTree = 0;
        for (int i = 0; i < inArray.length-1; i++) {
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

    public void Kruskals(int inArray[][]){
        Edge lastNode= null;
        PriorityQueue<Edge> pQ = new PriorityQueue<Edge>();
        for(int i = 0; i < inArray.length; i++){
            for(int j = 0; j < inArray[i].length; j++){
                if (inArray[i][j] != 0) {
                    String edge = getEdge(i, j);
                    pQ.add(new Edge(edge, i, j, inArray[i][j]));
                }
            }
        }
        lastNode = pQ.remove();

    }

    public Edge findSmall(Edge inArray[] ){
        for(int i = 0; i < inArray.length; i++){
            while(inArray[i].next != null){

            }
        }
        return null;
    }

    public void FloydWarshalls(int dimension, int[][] inputMatrix){
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
