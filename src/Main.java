/* Authors: Alex, Ethan, Zan
 * Date: 04/06/18
 * Overview: Graph Algorithms Program
 *   Implementing Prim's, Kruskal's, and Floyd-Warshall's Algorithms
 *   For input files no connection between vertexes should be symbolized by a zero
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    private int dims = 5;
    private int[][] g;

    public Main() {

    }

    public void start() {

    }

    public void runall(int[][] inArray) {
        int[][] p = inArray.clone();
        int[][] k = inArray.clone();
        int[][] f = inArray.clone();
        Graphs gr = new Graphs();
        //gr.FloydWarshalls(5, f);
        System.out.println("Kruskals");
        gr.Kruskals(k);
        //System.out.println("Prims");
        //gr.Prims(p);

    }

    public int[][] readFile2() {
        int[][] s = new int[dims][dims];
        Path f = Paths.get("input/adj2.txt");
        Charset charset = Charset.forName("US-ASCII");
        try (BufferedReader r = Files.newBufferedReader(f, charset)) {
            String line = null;
            int k = 0;

            while (((line = r.readLine()) != null) && k < 6) {
                int i;
                String[] csv = line.split("[,]+"); // Reads line and converts it splits it at the commas
                for (i = 0; i < dims; i++) {
                    s[k][i] = Integer.parseInt(csv[i]);
                }
                ++k;
            }
            System.out.println("   a  b  c   d  e");
            for (int j = 0; j < dims; j++) {
                if (j == 0)
                    System.out.print("a ");
                else if (j == 1)
                    System.out.print("b ");
                else if (j == 2)
                    System.out.print("c ");
                else if (j == 3)
                    System.out.print("d ");
                else if (j == 4) {
                    System.out.print("e ");
                }
                for (int m = 0; m < dims; m++) {
                    System.out.print(" " + s[j][m] + " ");
                }
                System.out.println();
            }
        } catch (IOException e) {
            System.err.format("IOException %s%n", e);
        }
        return s;
    }

    public int[][] readFile1() {
        int[][] s = new int[dims][dims];
        Path f = Paths.get("input/adj1.txt");
        Charset charset = Charset.forName("US-ASCII");
        try (BufferedReader r = Files.newBufferedReader(f, charset)) {
            String line = null;
            int k = 0;

            while (((line = r.readLine()) != null) && k < 6) {
                int i;
                String[] csv = line.split("[,]+"); // Reads line and converts it splits it at the commas
                for (i = 0; i < dims; i++) {
                    s[k][i] = Integer.parseInt(csv[i]);
                }
                ++k;
            }
            System.out.println("   a  b  c   d  e");
            for (int j = 0; j < dims; j++) {
                if (j == 0)
                    System.out.print("a ");
                else if (j == 1)
                    System.out.print("b ");
                else if (j == 2)
                    System.out.print("c ");
                else if (j == 3)
                    System.out.print("d ");
                else if (j == 4) {
                    System.out.print("e ");
                }
                for (int m = 0; m < dims; m++) {
                    System.out.print(" " + s[j][m] + " ");
                }
                System.out.println();
            }
        } catch (IOException e) {
            System.err.format("IOException %s%n", e);
        }
        return s;
    }

    public int[][] readFile0() {
        int[][] s = new int[dims][dims];
        Path f = Paths.get("input/adj_matrix.txt");
        Charset charset = Charset.forName("US-ASCII");
        try (BufferedReader r = Files.newBufferedReader(f, charset)) {
            String line = null;
            int k = 0;

            while (((line = r.readLine()) != null) && k < 6) {
                int i;
                String[] csv = line.split("[,]+"); // Reads line and converts it splits it at the commas
                for (i = 0; i < dims; i++) {
                    s[k][i] = Integer.parseInt(csv[i]);
                }
                ++k;
            }
            System.out.println("   a  b  c   d  e");
            for (int j = 0; j < dims; j++) {
                if (j == 0)
                    System.out.print("a ");
                else if (j == 1)
                    System.out.print("b ");
                else if (j == 2)
                    System.out.print("c ");
                else if (j == 3)
                    System.out.print("d ");
                else if (j == 4) {
                    System.out.print("e ");
                }
                for (int m = 0; m < dims; m++) {
                    System.out.print(" " + s[j][m] + " ");
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