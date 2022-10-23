package flatland.model.ai;

import flatland.util.Utils;

public class TerrainGenerator {

    public static double[][] fallingSandSimulation(int width, int height, int radius) {

        double[][] matrix = new double[width][height];
        double[][] sample = getSandHillSample(radius);
        int samples = width * height;

        for (int i = 0; i < samples; i++) {
            applySample(matrix, sample, Utils.RANDOM.nextInt(width), Utils.RANDOM.nextInt(height));
        }

        return matrix;
    }

    private static double[][] getSandHillSample(int radius) {

        int size = 2 * radius + 1;
        double[][] matrix = new double[size][size];

        for (int i = -radius; i <= radius; i++) {
            for (int j = -radius; j <= radius; j++) {
                double norm = Math.sqrt(Math.pow(i, 2) + Math.pow(j, 2));
                if (norm <= radius) {
                    matrix[radius + i][radius + j] = 1 / (1 + norm);
                }
            }
        }

        return matrix;
    }

    private static void applySample(double[][] matrix, double[][] sample, int x, int y) {

        int width = matrix.length;
        int height = matrix[0].length;
        int radius = sample.length  / 2;
        int xr = x - radius;
        int yr = y - radius;

        for (int i = 0; i < sample.length; i++) {
            for (int j = 0; j < sample[0].length; j++) {
                int ixr = i + xr;
                int jyr = j + yr;
                if (ixr >= 0 && ixr < width && jyr >= 0 && jyr < height) {
                    matrix[ixr][jyr] += sample[i][j];
                }
            }
        }
    }

    public static void main(String[] args) {

        double[][] a = fallingSandSimulation(30, 60, 5);
        double mean = 0;

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                mean += a[i][j];
            }
        }
        mean /= a.length * a[0].length;

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                if (a[i][j] > 1.4 * mean) System.out.print("X ");
                else if (a[i][j] > 1.3 * mean) System.out.print("+ ");
                else if (a[i][j] > 1.2 * mean) System.out.print("o ");
                else if (a[i][j] > 1.1 * mean) System.out.print("· ");
                else if (a[i][j] > 1.0 * mean) System.out.print("  ");
                else if (a[i][j] > 0.9 * mean) System.out.print("- ");
                else System.out.print("= ");
            }
            System.out.println();
        }
    }
}
