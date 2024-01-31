import java.util.Random;

public class DoubleMatrixMultiplication2 {
    public static void main(String[] args) {
        // Define matrix dimensions
        int rowsA = 1000, colsA = 800, colsB = 1200;

        // Generate random matrices
        double[][] A = generateRandomMatrix(rowsA, colsA, 1000.0);
        double[][] B = generateRandomMatrix(colsA, colsB, 1000.0);

        // Record start time
        long startTime = System.currentTimeMillis();

        // Perform matrix multiplication
        double[][] result = multiplyMatrices(A, B);

        // Record end time and output result
        long endTime = System.currentTimeMillis();
        System.out.println("Execution Time: " + (endTime - startTime) + " ms");
    }

    private static double[][] generateRandomMatrix(int rows, int cols, double maxValue) {
        Random random = new Random();
        double[][] matrix = new double[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = random.nextDouble() * maxValue;
            }
        }
        return matrix;
    }

    private static double[][] multiplyMatrices(double[][] A, double[][] B) {
        int rowsA = A.length, colsA = A[0].length, colsB = B[0].length;
        double[][] result = new double[rowsA][colsB];

        for (int i = 0; i < rowsA; i++) {
            for (int k = 0; k < colsA; k++) { // Change the order of loops
                for (int j = 0; j < colsB; j++) {
                    result[i][j] += A[i][k] * B[k][j];
                }
            }
        }
        return result;
    }

}
