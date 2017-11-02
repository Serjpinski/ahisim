package flatland.util;

import java.util.Objects;
import java.util.Random;

public class Utils {

    public static final Random RANDOM = new Random();

    public static boolean hasOrtogonalNeighboursWithValue(Object[][] matrix, Object value, int x, int y) {

        if (x - 1 >= 0 && Objects.equals(matrix[x - 1][y], value)) return true;
        if (x + 1 < matrix.length && Objects.equals(matrix[x + 1][y], value)) return true;
        if (y - 1 >= 0 && Objects.equals(matrix[x][y - 1], value)) return true;
        if (y + 1 < matrix[0].length && Objects.equals(matrix[x][y + 1], value)) return true;
        return false;
    }

    public static int ortogonalNeighboursWithValue(Object[][] matrix, Object value, int x, int y) {

        int count = 0;
        if (x - 1 >= 0 && Objects.equals(matrix[x - 1][y], value)) count++;
        if (x + 1 < matrix.length && Objects.equals(matrix[x + 1][y], value)) count++;
        if (y - 1 >= 0 && Objects.equals(matrix[x][y - 1], value)) count++;
        if (y + 1 < matrix[0].length && Objects.equals(matrix[x][y + 1], value)) count++;
        return count;
    }

    public static boolean hasNeighboursWithValue(Object[][] matrix, Object value, int x, int y) {

        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i != 0 && j != 0
                        && x + i >= 0 && x + i < matrix.length
                        && y + j >= 0 && y + j < matrix[0].length
                        && Objects.equals(matrix[x + i][y + j], value)) {
                    return true;
                }
            }
        }

        return false;
    }

    public static int neighboursWithValue(Object[][] matrix, Object value, int x, int y) {

        int count = 0;

        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i != 0 && j != 0
                        && x + i >= 0 && x + i < matrix.length
                        && y + j >= 0 && y + j < matrix[0].length
                        && Objects.equals(matrix[x + i][y + j], value)) {
                    count ++;
                }
            }
        }

        return count;
    }
}
