import java.util.PriorityQueue;

public class Graphs {

    public Graphs(){

    }

    public void Prims(int inArray[][]){
        PriorityQueue<String> pQ = new PriorityQueue<String>();
        for(int i = 0; i < inArray.length; i++){
            for(int j = 0; j < inArray[i].length; j++){
                if(inArray[i][j] != 0){
                    System.out.println(getEdge(i,j));
                }
            }
        }
    }

    public String getEdge(int i, int j){
        String alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String out = alpha.substring(i,i+1);
        out.concat(alpha.substring(j, j +1));
        return out;
    }
}
