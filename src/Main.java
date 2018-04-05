import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {


    public void readFile() {
        Path f = Paths.get("/input/adj_matrix.txt");
        Charset charset = Charset.forName("US-ASCII");
        try (BufferedReader r = Files.newBufferedReader(f, charset)) {
            String line = null;
            int[] k;
            while ((line = r.readLine()) != null) {
                String[] csv = line.split("[,\\s]+"); // Reads line and converts it splits it at the commas
            }
        } catch (IOException e) {
            System.err.format("IOException %s%n", e);
        }
    }
}
