import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    private int dims = 6;
    private String[][] g;

    public Main() {

    }

    public void start() {
        g = readFile();
        Graphs gr = new Graphs();
        gr.Prims(g);
    }

    public String[][] readFile() {
        String[][] s = new String[dims][dims];
        Path f = Paths.get("input/adj_matrix.txt");
        Charset charset = Charset.forName("US-ASCII");
        try (BufferedReader r = Files.newBufferedReader(f, charset)) {
            String line = null;
            int k = 0;

            while (((line = r.readLine()) != null) && k < 6) {
                int i;
                String[] csv = line.split("[,]+"); // Reads line and converts it splits it at the commas
                for (i = 0; i < dims; i++) {
                    s[k][i] = csv[i];
                }
                ++k;
            }
            for (int j = 0; j < dims; j++) {
                for (int m = 0; m < dims; m++) {
                    if(s[j][m].equals("inf")){
                        System.out.print("∞ ");
                    }else {
                        System.out.print(s[j][m] + " ");
                    }
                }
                System.out.println();
            }
        } catch (IOException e) {
            System.err.format("IOException %s%n", e);
        }
        return s;
    }

    public static void main(String[] args) {
        new Main().start();
    }
}
