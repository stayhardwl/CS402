import java.util.Random;

public class IntegerMatrixMultiplication {
    public static void main(String[] args) {
        // Define matrix dimensions
        int rowsA = 1000, colsA = 800, colsB = 1200;

        // Generate random matrices
        int[][] A = generateRandomMatrix(rowsA, colsA, Integer.MAX_VALUE);
        int[][] B = generateRandomMatrix(colsA, colsB, Integer.MAX_VALUE);

        // Record start time
        long startTime = System.currentTimeMillis();

        // Perform matrix multiplication
        int[][] result = multiplyMatrices(A, B);

        // Record end time and output result
        long endTime = System.currentTimeMillis();
        System.out.println("Execution Time: " + (endTime - startTime) + " ms");
    }

    private static int[][] generateRandomMatrix(int rows, int cols, int maxValue) {
        Random random = new Random();
        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = random.nextInt(maxValue);
            }
        }
        return matrix;
    }

    private static int[][] multiplyMatrices(int[][] A, int[][] B) {
        int rowsA = A.length, colsA = A[0].length, colsB = B[0].length;
        int[][] result = new int[rowsA][colsB];

        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsB; j++) {
                for (int k = 0; k < colsA; k++) {
                    result[i][j] += A[i][k] * B[k][j];
                }
            }
        }
        return result;
    }
}
