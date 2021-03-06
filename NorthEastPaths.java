import java.util.*;

public class NEpaths {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter rows apart: ");
        int rows = sc.nextInt();
        System.out.print("Enter columns apart: ");
        int cols = sc.nextInt();

        String path = "";
        System.out.println("Number of paths = " + ne(rows, cols, path));
    }

    // ne computes the number of NE paths as well as displays the paths
    public static int ne(int rows, int cols, String path) {
        // fill in your code here
        if (rows == 0 && cols == 0) {// reached destination, one possible path
            System.out.println(path);
            return 1;
        }
        if (rows == 0) {
            return ne(rows, cols - 1, path + "E ");// keep travelling east
        }
        if (cols == 0) {
            return ne(rows - 1, cols, path + "N ");// keep travelling north
        }
        return ne(rows - 1, cols, path + "N ") + ne(rows, cols - 1, path + "E ");
    }
}
