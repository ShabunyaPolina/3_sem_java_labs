package lab.creator;

import lab.entity.Matrix;

public class MatrixCreator {
    public void fillRandomized(Matrix matrix, int minValue, int maxValue) {
        int v = matrix.getVerticalSize();
        int h = matrix.getHorizontalSize();
        for (int i = 0; i < v; i++) {
            for (int j = 0; j < h; j++) {
                int value = (int) ((Math.random() * (maxValue - minValue)) + minValue);
                matrix.setElement(i, j, value);
            }
        }
    }
    // public int[][] createArray(int n, int m, int minValue, int maxValue) {/*code*/
// public void createFromFile(Matrix matrix, File f) { /* code */ }
// public void createFromStream(Matrix matrix, Stream stream) { /* code */ }
}

